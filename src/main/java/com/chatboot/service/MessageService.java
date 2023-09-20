package com.chatboot.service;

import com.chatboot.controller.request.ChatMessage;

public interface MessageService {
    ChatMessage sendMessage(ChatMessage chatMessage);
}
