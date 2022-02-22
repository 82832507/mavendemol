package com.ys.community;

import com.ys.community.config.alphaConfig;
import com.ys.community.dao.alphadao;
import com.ys.community.dao.alphodaoHibernateImpl;
import com.ys.community.service.alphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
//test类中运行时以main目录中的CommunityApplication为主并以它为配置类
class CommunityApplicationTests implements ApplicationContextAware {
	//哪个类要创建spring就实现ApplicationContextAwaree

	private  ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		alphadao bean =applicationContext.getBean(alphadao.class);
		System.out.println(bean.select());
		//bean = (alphadao) applicationContext.getBean("alphahibernate");
		bean=applicationContext.getBean("alphahibernate",alphadao.class);
		System.out.println(bean.select());
	}
	@Test
	public void alphaServiceTset(){
		alphaService bean = applicationContext.getBean(alphaService.class);
		System.out.println(bean);
		bean.init();
		bean.destroy();
		 bean = applicationContext.getBean(alphaService.class);
		System.out.println(bean);
		bean.init();
		bean.destroy();
	}
	@Test
	public void alphaBeanTest(){
		SimpleDateFormat simpleDateFormat=
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
	@Autowired
	@Qualifier("alphahibernate")
	private alphadao alphadao;
	@Autowired
	private alphaService alphaService;
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	@Test
	public void testDI(){
		System.out.println(alphadao);
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);
	}
}
