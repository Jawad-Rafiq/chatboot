package com.chatboot.service;

import com.chatboot.controller.request.ChatMessage;
import com.chatboot.controller.request.MESSAGETYPE;
import com.chatboot.model.MessageModel;
import com.chatboot.repo.MessageRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageRepo messageRepo;

    public ChatMessage sendMessage(ChatMessage chatMessage){
        messageRepo.save(MessageModel.builder()
                        .messagetype(MESSAGETYPE.CHAT)
                        .sender(chatMessage.getSender())
                        .content(chatMessage.getContent())
                .build());
        log.info("saved message in database message: {}, by: {}", chatMessage.getContent(), chatMessage.getSender());
        return chatMessage;
    }
}
