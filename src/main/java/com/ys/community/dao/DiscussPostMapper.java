package com.ys.community.dao;

import com.ys.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
    //@Param注解是给后面的参数取一个别名
    //需要动态的拼接条件（在if()里面使用），并且只有一个条件
    // 则这个参数前必须写上@Param这个注解，为其取别名
    int selectDiscussPostRows(@Param("userId") int userId);

}
