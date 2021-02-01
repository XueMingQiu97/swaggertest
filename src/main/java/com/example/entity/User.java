package com.example.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@ApiModel(value = "通用返回对象",description = "实体类")  //注释这个类的信息 model类
@TableName(value = "t_user")
@Data
public class User implements Serializable {


    @ApiModelProperty(value = "用户id", dataType = "Integer",example = "1")
    private Integer id;

    @ApiModelProperty(value = "用户名", dataType = "String",example = "lanny")
    private String username;

    @ApiModelProperty(value = "用户密码", dataType = "String",example = "123abc")
    private String password;

}
