package com.example.chat.domain.user.controller;

import com.example.chat.domain.chatroom.model.ChatRoomDto;
import com.example.chat.global.common.model.BaseRequest;
import com.example.chat.global.common.model.BaseResponse;
import com.example.chat.domain.user.service.UserService;
import com.example.chat.domain.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public BaseResponse<UserDto> createUser(@RequestBody BaseRequest<UserDto> req, BindingResult result){
        if(result.hasErrors()){
            return BaseResponse.ofFail(400, result.toString());
        }
        return userService.createUser(req);
    }

    @PostMapping("/out/chat_room")
    public BaseResponse<ChatRoomDto> outChatRoom(@RequestBody BaseRequest<UserDto> req){
        return userService.outChatRoom(req);
    }




}
