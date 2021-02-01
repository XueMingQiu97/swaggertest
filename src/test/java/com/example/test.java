package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =Application.class)
public class test {

    Integer res;
    public String result(Integer res){
        if(res==1){
            return "操作成功";
        }else {
            return "操作失败,或用户名已存在";
        }
    }
@Autowired
private UserService userService;
    @Test
    public void findAll(){
        List<User> users = userService.findAll();
        for (User user: users) {
            System.out.println(user);
        }
    }
    @Test
    public void get() {
        User finfById = userService.findById(1);
        System.out.println(finfById);
    }
    @Test
    public void selectAllTest(){
        List<User> users = userService.findAll();
        for (User user: users) {
            System.out.println(user);
        }
    }
    @Test
    public void insertUser(){
        res = userService.insertUser("test01", "19");
        String result = result(res);
        System.out.println(result);
    }

    @Test
    public void updateById(){
        int res = userService.updateUser("test04",6);
        System.out.println(result(res));
    }

}
