package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {
    //查询当前用户的会话列表,每个会话返回最新对话
    List<Message> selectConversations(int userId, int offset, int limit);

    //查询当前用户的会话数量
    int selectConversationCount(int userId);

    //查询某个会话的列表
    List<Message> selectLetter(String conversationId, int offset, int limit);

    //查询某个私信会话数量
    int selectLetterCount(String conversationId);

    //查询未读消息数量
    int selectLetterUnreadCount(int userId, String conversationId);
}
