package com.chatboot.controller;

import com.chatboot.controller.request.ChatMessage;
import com.chatboot.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MessageController {

    @Autowired
    MessageService service;
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage){
        log.info("recieved request to send message  : [{}]", chatMessage);
        return service.sendMessage(chatMessage);
    }
}
