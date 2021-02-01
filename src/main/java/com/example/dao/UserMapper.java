package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();
    User selectByIdAndName( String id,String username);
    int updateNameById(String username, Integer id);
    int insert(User user);
    String selectByIdInt(String id);




}
