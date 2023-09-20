package com.chatboot.service;

import com.chatboot.controller.request.ChatMessage;
import com.chatboot.model.ChatroomModel;
import com.chatboot.repo.ChatroomRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final ChatroomRepo chatroomRepo;

    @Override
    public ChatMessage addUser(ChatMessage message, SimpMessageHeaderAccessor simpMessageHeaderAccessor) {
        //Add username in websocket
        simpMessageHeaderAccessor.getSessionAttributes().put("username", message.getSender());
        chatroomRepo.save(ChatroomModel.builder().username(message.getSender()).build());
        return message;
    }
}
