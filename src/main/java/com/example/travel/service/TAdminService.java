package com.example.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.travel.entity.TAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (TAdmin)表服务接口
 *
 * @author fauchard
 * @since 2022-12-06 14:05:46
 */

public interface TAdminService extends IService<TAdmin> {
    TAdmin login(String username,String password);

    List<TAdmin> selectAll();

    int delId(Integer id);

    TAdmin selectOne(Integer id);

    int add(TAdmin users);

    int updateOne(TAdmin admin);

    List<TAdmin> getUsersList(String name);

    TAdmin findByUserName(String username);

    List<TAdmin> findByPage(int pageNumber, int pageSize, String query);
}

