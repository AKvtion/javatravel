package com.example.travel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.travel.dao.TArticleDao;
import com.example.travel.dao.TUserDao;
import com.example.travel.entity.TArticle;
import com.example.travel.entity.TUser;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TArticle)表服务接口
 *
 * @author fauchard
 * @since 2022-12-09 07:57:12
 */
public interface TArticleService extends IService<TArticle> {

    TArticle queryByid(Integer id);

    long count2();

    List<TArticle> findByPage(int pageNumber, int pageSize, String query);

    void deleteById(Integer id);

    TArticle findByUserName(String title);

    int updateOne(TArticle entity);

    int insert(TArticle tArticle);
}

