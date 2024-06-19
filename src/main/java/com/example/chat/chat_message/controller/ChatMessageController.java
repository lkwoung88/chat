package com.example.chat.chat_message.controller;

import com.example.chat.chat_message.model.ChatMessageDto;
import com.example.chat.chat_message.repository.ChatMessageRepository;
import com.example.chat.chat_room.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatMessageController {
    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    @MessageMapping("chat/message")
    public void message(ChatMessageDto requestDto){

    }
}