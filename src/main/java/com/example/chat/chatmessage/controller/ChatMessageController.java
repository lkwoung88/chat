package com.example.chat.chatmessage.controller;

import com.example.chat.chatmessage.model.ChatMessageDto;
import com.example.chat.chatmessage.service.ChatMessageService;
import com.example.chat.common.model.BaseRequest;
import com.example.chat.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatMessageController {

    private final ChatMessageService chatMessageService;
    @MessageMapping("chat/message")
    public BaseResponse message(BaseRequest<ChatMessageDto> req){
        return chatMessageService.sendMessage(req.getRequestBody());
    }
}