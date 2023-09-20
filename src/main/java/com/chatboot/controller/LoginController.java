package com.chatboot.controller;

import com.chatboot.controller.request.ChatMessage;
import com.chatboot.service.ChatroomService;
import com.chatboot.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    LoginService chatroomService;
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor simpMessageHeaderAccessor){
        log.info("request recieved for addUser: [{}]", chatMessage);
        return chatroomService.addUser(chatMessage, simpMessageHeaderAccessor);
    }
}
