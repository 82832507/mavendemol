package com.ys.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class alphaConfig {
    @Bean//其中Bean的名字就是方法名simpleDateFormat
    public SimpleDateFormat simpleDateFormat(){
        return  new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    }
}
