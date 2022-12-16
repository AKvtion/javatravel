package com.example.travel.service;

import com.example.travel.entity.TUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TUser)表服务接口
 *
 * @author fauchard
 * @since 2022-12-06 16:42:56
 */
public interface TUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUser queryByid(Integer id);

    /**
     * 分页查询
     *
     * @param tUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TUser> queryByPage(TUser tUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    TUser insert(TUser tUser);

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    TUser update(TUser tUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    long count2();

    long count(TUser u);

    TUser findByUserName(String username);

    void save(TUser entity);

    List<TUser> findByPage(int pageNumber, int pageSize, String query);
}
