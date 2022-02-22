package com.ys.community;

import com.ys.community.dao.DiscussPostMapper;
import com.ys.community.dao.UserMapper;
import com.ys.community.entity.DiscussPost;
import com.ys.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(150);
        System.out.println(user);
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        //user.setId(150);id不用传，数据库自动生成
        user.setUsername("杨塞");
        user.setPassword("123456");
        user.setSalt("abcd");
        user.setEmail("123456@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int n=userMapper.insertUser(user);
        System.out.println(n);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
    }
    @Test
    public void testUpdateUser(){
        int n=userMapper.updatePassword(150,"6543221");
        System.out.println(n);
        n=userMapper.updateStatus(150,1);
        System.out.println(n);
    }

    @Test
    public void testSelectDiscussPosts(){
        List<DiscussPost> list=new LinkedList<>();
       list= discussPostMapper.selectDiscussPosts(149,0,10);
        for (DiscussPost post:list) {
            System.out.println(post);
        }
        System.out.println("=====================================");
        int n=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(n);
    }

}
