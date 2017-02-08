package com.book.util;

import com.book.bean.Messages;
import com.book.dao.MessageDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Myth on 2017/2/7
 * 使用Spring WebSocket是可以同处于 IOC容器内的，调用方法就方便了
 *
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {

    @Autowired
    MessageDao messageDao;

    private Logger log = LoggerFactory.getLogger(SystemWebSocketHandler.class);

    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();;


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("ConnectionEstablished");
        log.debug("ConnectionEstablished");
        users.add(session);

       // session.sendMessage(new TextMessage("connect"));
       // session.sendMessage(new TextMessage("new_msg"));

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        System.out.println("handleMessage" + message.toString());
        try {
            log.debug("收到：" + message.getPayload());
            String tempp = message.getPayload().toString();
            sendMessageToUsers(new TextMessage(tempp));
            //处理JSON 得以转化保存
            ObjectMapper mapper = new ObjectMapper();
            String json = message.getPayload().toString();
            String temp[] = json.split(",");
            json = "";
            for (int i = 0; i < temp.length; i++) {
                if (!temp[i].startsWith("\"receive_name") && !temp[i].startsWith("\"send_name")) {
                    json += temp[i] + ",";
                }
            }
            json = json.substring(0, json.length() - 1);
            log.info("json:"+json);
            Messages as = mapper.readValue(json, Messages.class);
            messageDao.save(as);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }


        //回馈数据
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        session.sendMessage(new TextMessage(sdf.format(new Date()) + " 服务器回馈数据"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        users.remove(session);

        log.debug("handleTransportError" + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        users.remove(session);
        log.debug("afterConnectionClosed" + closeStatus.getReason());

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}