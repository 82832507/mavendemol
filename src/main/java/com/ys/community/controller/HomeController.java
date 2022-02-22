package com.ys.community.controller;

import com.ys.community.entity.DiscussPost;
import com.ys.community.entity.Page;
import com.ys.community.entity.User;
import com.ys.community.service.DiscussPostService;
import com.ys.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService  userService;
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        //方法调用前，SpringMvc会自动实例化Model和Page注入Model
        //所以，在tymeleaf中可以直接访问Page对象中的数据
        page.setRows(discussPostService.findSelectDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list=new LinkedList<>();
        list=discussPostService.findSelectDiscussPost(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        if(list!=null){
            for (DiscussPost discussPost:list) {
                Map<String,Object> map=new HashMap<>();
                User user=userService.findUserById(discussPost.getUserId());
                map.put("discussPost",discussPost);
                map.put("user",user);
                discussPosts.add(map);
            }

        }
        model.addAttribute("post",discussPosts);
        return "/index";
    }
}