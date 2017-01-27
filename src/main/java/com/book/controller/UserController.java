package com.book.controller;

import com.book.bean.Users;
import com.book.dao.UserDao;
import com.book.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Myth on 2017/1/25 0025
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    private static org.slf4j.Logger Log = LoggerFactory.getLogger(UserController.class);

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
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){
        ModelAndView view = new ModelAndView("index");
        Users u = (Users)session.getAttribute("user");
        String name="当前没有用户在线，下线失败";
        if(u!=null) name=u.getName();
        session.removeAttribute("user");
        Log.info("注销登录 : "+name);
        return view;
    }

    /*
        ajax 发起登录请求 返回1成功0失败
     */
    @RequestMapping("/ajax_in")
    @ResponseBody
    public String login(@ModelAttribute Users users, HttpServletRequest request)throws Exception {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        String inputCode = request.getParameter("code");
        inputCode = inputCode.toUpperCase();
        Log.info("用户输入验证码:"+inputCode);
        String email = users.getEmail();
        String pass = users.getPassword();

        if (inputCode != null && inputCode.equals(code)) {
            long id = userService.Login(email, pass);
            String result = id + "";
            if (result.length() == 10) {//作家
                //session.setAttribute("user_id", id);
                return "1";
            } else if (result.length() == 12) {//用户
                Users u = (Users) userDao.getOne(id);
                Log.info("用户："+u.toString());
                session.setAttribute("user", u);
                return "1";
            }
        }
        return "0";

    }
    @RequestMapping("/getCode")
    @ResponseBody
    public String getCode(HttpSession session){
        session.removeAttribute("code");
        String init="ZXCVBNMLKJHGFDSAQWERTYUIOP1234567890";
        String code="";
        for(int i=0;i<4;++i){
            int index = (int)(Math.random()*36);
            code+=init.charAt(index);
        }
        session.setAttribute("code",code);
        Log.info("生成验证码 : "+code);
        return code;
    }
}
