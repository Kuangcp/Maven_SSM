package com.book.controller;

import com.book.bean.Author;
import com.book.bean.Messages;
import com.book.bean.Users;
import com.book.dao.AuthorDao;
import com.book.dao.MessageDao;
import com.book.dao.UserDao;
import com.book.redis.RedisUtils;
import com.book.service.MessageService;
import com.book.service.UserService;
import com.book.util.GetRunTime;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Myth on 2017/1/25 0025
 * 没有setget方法也注入成功了，原因是？
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    GetRunTime Time;
    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserDao userDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    RedisUtils redisUtils;

    private static org.slf4j.Logger Log = LoggerFactory.getLogger(UserController.class);

    /**
     * 常规的登录跳转
     * @param users
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute Users users, HttpServletRequest request, HttpServletResponse response)throws Exception{
        HttpSession session = request.getSession();
        ModelAndView view = new ModelAndView("index");
        String email = users.getEmail();
        String pass = users.getPassword();
        String inputcode = request.getParameter("code");
        String code = (String)session.getAttribute("code");
        Log.info("用户输入验证码:"+inputcode);
        String id="";
        if(inputcode!=null && inputcode.equals(code)){
            long idd = userService.Login(email,pass);
            id =idd+"";
            if(id.length()==10){
                session.setAttribute("author_id",id);
            }else if(id.length()==12){
                Users u = (Users)userDao.getOne(idd);
                Log.info("用户："+u.toString());
                session.setAttribute("user",u);
            }else{

            }
        }

        Log.info("执行结果："+id+"__"+users.toString());
        return view;
    }

    /**
     * 所有用户下线，Session销毁的函数
     * @param session
     * @return
     */
    @RequestMapping("/logout/{type}")
    public ModelAndView logout(@PathVariable("type") String type, HttpSession session){
        String viewName="login";

        String name="";
        Users u = (Users)session.getAttribute("user");
        Author a = (Author)session.getAttribute("author");
        Log.info("_"+a+"_"+u);
        Jedis jedis = redisUtils.getConnect();
        if(u==null && a==null){
            name="当前没有用户在线，下线失败";
        }
        if("user".equals(type)&& u!=null){
            viewName="index";
            name=u.getName();
            ClearRedis(jedis,u.getUser_id());
            session.removeAttribute("user");
        }else if("author".equals(type)&&a!=null){
            name=a.getName();
            ClearRedis(jedis,a.getAuthor_id());
            session.removeAttribute("author");
        }
        jedis.disconnect();
        Log.info("注销登录 : ["+name+"] 视图名："+viewName);
        ModelAndView view = new ModelAndView("redirect:/l/"+viewName+".jsp");
        return view;
    }

    /*
        ajax 发起登录请求 返回1成功0失败
        所有用户都是使用这个来发起登录请求，根据ID的长度来判断身份
     */
    @RequestMapping(value="/ajax_in",method = RequestMethod.POST)
    @ResponseBody
    public String login(@ModelAttribute Users users, HttpServletRequest request)throws Exception {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        int sex = users.getSex();
        String email = users.getEmail();
        String pass = users.getPassword();
        String inputCode = request.getParameter("code").toUpperCase();
        Log.info("ajax____用户输入验证码:"+inputCode);

        //验证验证码的逻辑，注释就验证码失效
//        if (inputCode != null && inputCode.equals(code)) {
            long id = userService.Login(email, pass);
            Log.info("查询到的id"+id);
            String result = id + "";
            if (result.length() == 10 && sex==1) {//作家
                Author a = (Author)authorDao.getOne(id);
                InitUserMessageList(a.getAuthor_id(),0);
                Log.info("作家__"+a.toString());
                session.setAttribute("author",a);
                return "1";
            } else if (result.length() == 12 && sex==0) {//用户
                Users u = (Users) userDao.getOne(id);
                InitUserMessageList(u.getUser_id(),0);
                Log.info("用户__"+u.toString());
                session.setAttribute("user", u);
                return "1";
            }
//        }
        return "0";

    }

    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(HttpSession session){
        session.removeAttribute("code");
        String init="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String code="";
        for(int i=0;i<4;++i){
            int index = (int)(Math.random()*36);
            code+=init.charAt(index);
        }
        session.setAttribute("code",code);
        Log.info("生成验证码 : "+code);
        return code;
    }

    /**
     * 改作家资料
     * @param author
     * @return
     * @throws Exception
     */
    @RequestMapping("/update_author")
    @ResponseBody
    public String update(@ModelAttribute Author author)throws Exception{
        String result=null;
        boolean flag = authorDao.update(author);
        if(flag){
            result="1";
        }else{
            result="0";
        }
        return result;
    }

    /**
     * 获取未读消息的数目 方便显示
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/getMessageNum")
    @ResponseBody
    public String getNums(HttpSession session)throws Exception{
        Author author = (Author) session.getAttribute("author");
        List<Messages> messageList = null;
        if(author!=null ){
            messageList = messageDao.getAll("receive="+author.getAuthor_id()+" and readed=0");
        }else{
            Users users = (Users)session.getAttribute("user");
            messageList = messageDao.getAll("receive="+users.getUser_id()+" and readed=0");
        }
        if(messageList!=null){
            return messageList.size()+"";
        }else{
            return "";
        }
    }

    /**
     * 初始化消息列表，只将部分放入redis中，其余的到历史消息中分页查看
     */
    public void InitUserMessageList(long id,int read){
        Jedis jedis = redisUtils.getConnect();
        // 使用管道，提高效率
        Pipeline pipelined = jedis.pipelined();
        Map<String,List<Messages>> messageList =  messageService.getMessageList(id,read);
        Set<String> SendNames_id = messageList.keySet();
        // 当前用户和 所有 有消息来往的映射
        ClearRedis(jedis,id);
        for(String name:SendNames_id){
            pipelined.lpush(""+id,name);
            List<Messages> messages = messageList.get(name);
            for (Messages  m:messages){
                pipelined.lpush(name,m.getSend()+"|///|"+m.getMessage());
            }
        }
        //管道提交
        pipelined.sync();
        jedis.close();

    }
    // 删除指定用户id的所有消息记录缓存
    public void ClearRedis(Jedis jedis, long id){
        List<String>list = jedis.lrange(""+id,0,-1);
        for(String key:list){
            jedis.del(key);
        }
        jedis.del(""+id);
    }

    public GetRunTime getTime() {
        return Time;
    }

    public void setTime(GetRunTime time) {
        Time = time;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public RedisUtils getRedisUtils() {
        return redisUtils;
    }

    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
