package com.example.conntroller;

import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags ="用户CRUD-API接口")  //标记它作为swagger的资源文档 tags控制api所属的标签列表，可以是数据[]填写多个
public class UserController {
    @Autowired
    private UserService userService;

   @GetMapping("/list")
   // 注解，添加在 Controller 方法上，标记它是一个 API 操作。
   @ApiOperation(value = "查询用户列表",notes ="测试返回全部用户列表")
   public List<User> findAll(){
        List<User> findAll = userService.findAll();
//        JSONArray js = JSONArray.fromObject(findAll);
       return findAll;
    }

    @GetMapping("/get")
    @ApiOperation("获得指定用户编号的用户")
    //添加在 Controller 方法上，声明每个请求参数的信息。
    @ApiImplicitParam(name = "id", value = "用户编号", paramType = "query", dataType = "Integer", required = true, example = "1024")
    public User get(@RequestParam("id") Integer id) {
        User finfById = userService.findById(id);
        return finfById;
    }

    @PostMapping("add")
    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query", dataType = "String", required = true, example = "1024"),
            @ApiImplicitParam(name = "password", value = "用户密码", paramType = "query", dataType = "String", required = true, example = "1024"),
    })
    public Integer add(String username,String password) {
        int insertUser = userService.insertUser(username, password);
        return insertUser;
    }

    @PostMapping("/update")
    @ApiOperation("更新指定用户编号的用户的名字")
    public int update(String username,Integer id) {
        int updateUser = userService.updateUser(username, id);
        return updateUser;
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除指定用户编号的用户")
    @ApiImplicitParam(name = "id", value = "用户编号", paramType = "query", dataTypeClass = Integer.class, required = true, example = "1024")
    public int delete(@RequestParam("id") Integer id) {
        int delUserById = userService.delUserById(id);
        return delUserById;
    }

}
