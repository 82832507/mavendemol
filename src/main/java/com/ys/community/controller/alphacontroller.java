package com.ys.community.controller;

import com.ys.community.dao.alphadao;
import com.ys.community.service.alphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class alphacontroller {
    @RequestMapping("hello")
    @ResponseBody
    public String Hello() {
        return "Springboot Hello~";
    }

    @Autowired
    private alphaService alphaService;

    @RequestMapping("show")
    @ResponseBody
    public String show() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getMethod());
        System.out.println(request.getContextPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println("name:" + value);
        }
        System.out.println(request.getParameter("name"));
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.write("<h1>Spring Mvc</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "count", required = false, defaultValue = "1") int count, @RequestParam(name = "limit", required = false, defaultValue = "20") int limit) {
        System.out.println(count);
        System.out.println(limit);
        return "some students";
    }

    //  /student/123 请求参数作为路径的一部分的访问方式
//    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public String getStudent(@PathVariable(name = "id") int id){
//        System.out.println(id);
//        return "a student";
//    }
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(@PathParam(value = "name") String name, @PathParam(value = "age") int age) {
        System.out.println(name);
        System.out.println(age);
        return "a student";
    }

    //响应html数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getteacher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "张英");
        modelAndView.addObject("age", 28);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",190);
        return "/demo/view";
    }
    //响应JASON数据（异步请求中）当前网页不动，不刷新
    // 悄悄的访问了服务器一次，得到了一个结果，显然不是一个html
    //局部验证的结果是否成功与失败用到JASON
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","杨塞");
        emp.put("age",18);
        emp.put("salary",20000);
        return emp;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> emp=new HashMap<>();
        emp.put("name","杨塞");
        emp.put("age",18);
        emp.put("salary",20000);
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","杨憨憨");
        emp.put("age",28);
        emp.put("salary",30000);
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","杨小塞");
        emp.put("age",38);
        emp.put("salary",50000);
        list.add(emp);

        return list;
    }
}