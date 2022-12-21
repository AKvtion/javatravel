package com.example.travel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.travel.entity.TAdmin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (TAdmin)表数据库访问层
 *
 * @author fauchard
 * @since 2022-12-06 14:05:45
 */
@Mapper
public interface TAdminDao extends BaseMapper<TAdmin> {

    @Select("select * from javatravel.t_admin where username = #{username} and password = #{password} ")
    TAdmin selectLogin(@Param("username") String username, @Param("password") String password);

    @Select("select * from javatravel.t_admin")
    List<TAdmin> selectAll();

    @Delete("delete from javatravel.t_admin where id = #{id}")
    int delById(@Param("id") Integer id);

    @Select("select * from javatravel.t_admin where id = #{id}")
    TAdmin selectOne(@Param("id") Integer id);

    @Insert("insert into javatravel.t_admin (id,username,name,password,phone,state) values (#{id},#{username},#{name},#{password},#{phone},#{state})")
    int add(TAdmin users);

    @Insert("insert into javatravel.t_admin (username, name, password, phone, state) VALUES (#{username},#{name},#{password},#{phone},#{state})")
    int insert(TAdmin tAdmin);

    @Update("update javatravel.t_admin set username=#{username},name=#{name},password=#{password},phone=#{phone},state=#{state} where id = #{id}")
    int updateOne(TAdmin admin);

    @Select("select * from javatravel.t_admin where CONCAT(id,username,name,password,phone,state) like CONCAT('%',#{name},'%')")
    List<TAdmin> getUserList(String name);

    @Select("select * from javatravel.t_admin where username = #{username}")
    TAdmin findByUserName(String username);

    @Select("select * from javatravel.t_admin where username like #{s}")
    List<TAdmin> findListByQuery(@Param("s") String s);

    @Select("select * from javatravel.t_admin")
    List<TAdmin> findList();



    @Select("select count(*) from javatravel.t_admin")
    int selectCount();

    @Select("select * from javatravel.t_admin where username = #{userName}")
    TAdmin selectUsername(@Param("userName") String userName);

    @Insert("insert into javatravel.t_admin (username,password) values (#{username},#{password})")
    int register(@Param("username") String username, @Param("password") String password);
}

