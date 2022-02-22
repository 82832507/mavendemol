package com.ys.community.service;

import com.ys.community.dao.alphadao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
public class alphaService {
    public alphaService(){
        System.out.println("alphaService的构造方法");
    }//空参构造方法
    @PostConstruct//构造方法后进行初始化
    public void init(){
        System.out.println("初始化alphaService");
    }
    @PreDestroy//销毁之前进行销毁
    public void destroy(){
        System.out.println("销毁alphaService");
    }
 @Autowired
    private alphadao alphadao;
    public String find(){
        return alphadao.select();
    }
}
