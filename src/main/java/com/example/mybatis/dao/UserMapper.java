package com.example.mybatis.dao;

import com.example.mybatis.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *@ClassName UserMapper.java
 *@Description 数据操作类
 *@Author Xiao Nong
 *@Date 2018/12/1
  **/
@Mapper
public interface UserMapper {

    /** 
    * @Description: 查询用户列表
    * @Param: [] 
    * @return: java.util.List<com.example.mybatis.bean.User> 
    * @Author: Xiao Nong
    * @Date: 2018/12/1 
    */ 
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "regTime", column = "reg_time")
    })
    List<User> getAll();
    /**
     *@ClassName UserMapper.java
     *@Description 通过用户id查询User
     *@Author Xiao Nong
     *@Date 2018/12/1
      **/
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "nickName", column = "nick_name"),
            @Result(property = "regTime", column = "reg_time")
    })
    User getOne(Long id);

    /**
     *@ClassName UserMapper.java
     *@Description 保存用户信息
     *@Author Xiao Nong
     *@Date 2018/12/1
      **/
    @Insert("INSERT INTO user(user_name,pass_word,email,nick_name,reg_time) VALUES(#{userName}, #{passWord}, #{email},#{nickName},#{regTime})")
    void insert(User user);

    /**
     *@ClassName UserMapper.java
     *@Description 修改用户信息
     *@Author Xiao Nong
     *@Date 2018/12/1
      **/
    @Update("UPDATE user SET user_name=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(User user);

    /**
     *@ClassName UserMapper.java
     *@Description 删除用户信息
     *@Author Xiao Nong
     *@Date 2018/12/1
      **/
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);


}
