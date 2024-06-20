package com.example.chat.domain.chatroom.model;

import com.example.chat.domain.chatmessage.model.ChatMessage;
import com.example.chat.domain.chatroomuser.model.ChatRoomUser;
import com.example.chat.global.common.model.BaseEntity;
import com.example.chat.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_room")
public class ChatRoom extends BaseEntity {
    @Id
    private String roomId;

    private String roomName;

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatMessage> messages;

    @ManyToOne
    private User creator;

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatRoomUser> chatRoomUserList = new ArrayList<>();

    public ChatRoomDto fromEntity(){
        return ChatRoomDto.builder()
                .roomName(this.roomName)
                .creatorId(this.creator.getUserId())
                .userIdList(getParticipantIdList())
                .createdAt(this.getCreatedAt())
                .build();
    }

    public List<String> getParticipantIdList(){
        List<String> participantIdList = new ArrayList<>();
        for(ChatRoomUser chatRoomUser : this.chatRoomUserList){
            participantIdList.add(chatRoomUser.getUser().getUserId());
        }
        return participantIdList;
    }
}
