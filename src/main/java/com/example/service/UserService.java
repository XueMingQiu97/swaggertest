package com.example.service;

import com.example.dao.UserMapper;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //查询所有用户
    public List<User> findAll(){
        List<User> users = userMapper.selectAll();
        return users;
    }
    //根据id查询用户
    public User findById(Integer id){
        User user = userMapper.selectById(id);
        return user;
    }
    //添加用户
    public int insertUser(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int insertResult = userMapper.insert(user);
        return insertResult;
    }
    //根据id删除用户
    public  int delUserById(Integer id){
        int delUserByIdResult = userMapper.deleteById(id);
        return delUserByIdResult;
    }
    //更新修改用户 根据id修改
    public  int updateUser(String username,Integer id){
        int updateNameByIdResult = userMapper.updateNameById(username, id);
        return updateNameByIdResult;
    }


}
