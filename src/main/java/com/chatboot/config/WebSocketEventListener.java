package com.chatboot.config;

import com.chatboot.controller.request.ChatMessage;
import com.chatboot.controller.request.MESSAGETYPE;
import com.chatboot.model.ChatroomModel;
import com.chatboot.repo.ChatroomRepo;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.time.Instant;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messageTemplate;
    @EventListener
    public void handleWebSocketDisconnetListner(SessionDisconnectEvent disconnect){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(disconnect.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null){
            log.info("User: {} disconnected", username);
            var chatMessage = ChatMessage.builder()
                    .messagetype(MESSAGETYPE.LEAVE)
                    .sender(username)
                    .build();
            messageTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}
