package com.example.chat.domain.chatroom.model;

import com.example.chat.global.common.model.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomDto extends BaseDto {
    private String roomName;
    private String creatorId;
    private String userId;
    private List<String> userIdList;
    private String createdAt;

    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .roomId(UUID.randomUUID().toString())
                .roomName(this.roomName)
                .creator(userRepository.findByUserId(creatorId))
                .build();

    }

    public ChatRoom createRoom(){
        return chatRoomRepository.save(toEntity());
    }
}
