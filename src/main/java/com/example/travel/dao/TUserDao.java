package com.example.travel.dao;

import com.example.travel.entity.TUser;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TUser)表数据库访问层
 *
 * @author fauchard
 * @since 2022-12-06 16:42:56
 */
@Mapper
public interface TUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from javatravel.t_user where id = #{id}")
    TUser queryByid(@Param("id") Integer id);

    /**
     * 查询指定行数据
     *
     * @param tUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TUser> queryAllByLimit(TUser tUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     *
     * @return 总行数
     */
    @Select("SELECT COUNT(*) FROM javatravel.t_user;")
    long count2();

    long count(TUser user);
    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    int insert(TUser tUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUser> entities);

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    @Update("update javatravel.t_user set username=#{username},name=#{name},password=#{password},phone=#{phone},state=#{state}," +
            "province=#{province} where id = #{id} ")
    int update(TUser tUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from javatravel.t_user where id=#{id} ")
    int deleteById(Integer id);

    @Select("select * from javatravel.t_user where username = #{username}")
    TUser findByUserName(@Param("username") String username);

    @Insert("insert into javatravel.t_user (username, name, password, phone, state,province) VALUES (#{username},#{name},#{password},#{phone},#{state},#{province})")
    void save(TUser entity);

    @Select("select * from javatravel.t_user where username like #{s}")
    List<TUser> findListByQuery(@Param("s") String s);

    @Select("select * from javatravel.t_user")
    List<TUser> findList();
}

