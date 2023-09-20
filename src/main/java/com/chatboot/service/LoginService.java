package com.chatboot.service;

import com.chatboot.controller.request.ChatMessage;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

public interface LoginService {
    ChatMessage addUser (ChatMessage message, SimpMessageHeaderAccessor simpMessageHeaderAccessor);

}
