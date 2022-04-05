package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
//mapper.xml方式写sql
import java.util.List;
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param注解用于对参数取别名
    //在thyeleaf的<if>语句中如果参数只有一个，必须使用别名
    int selectDiscussRows(@Param("userId") int userId);
}
