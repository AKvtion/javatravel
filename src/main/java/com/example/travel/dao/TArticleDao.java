package com.example.travel.dao;

import com.example.travel.entity.TArticle;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TArticle)表数据库访问层
 *
 * @author fauchard
 * @since 2022-12-09 09:08:36
 */
public interface TArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from javatravel.t_article where id = #{id}")
    TArticle queryById(@Param("id") Integer id);

    /**
     * 查询指定行数据
     *
     * @param tArticle 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TArticle> queryAllByLimit(TArticle tArticle, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @return 总行数
     */
    @Select("select COUNT(*) from javatravel.t_article")
    long count();

    /**
     * 新增数据
     *
     * @param tArticle 实例对象
     * @return 影响行数
     */
    @Insert("insert into javatravel.t_article (title, author, content, time) VALUES (#{title},#{author},#{content},#{time})")
    int insert(TArticle tArticle);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TArticle> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TArticle> entities);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TArticle> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TArticle> entities);

    /**
     * 修改数据
     *
     * @param tArticle 实例对象
     * @return 影响行数
     */
    @Update("update javatravel.t_article set title=#{title},author=#{author},content=#{content},time=#{time} where id = #{id} ")
    int update(TArticle tArticle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Delete("delete from javatravel.t_article where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from javatravel.t_article where title like #{s}")
    List<TArticle> findListByQuery(@Param("s") String s);

    @Select("select * from javatravel.t_article")
    List<TArticle> findList();

    @Select("select * from javatravel.t_article where title = #{title}")
    TArticle findByUserName(@Param("title") String title);
}

