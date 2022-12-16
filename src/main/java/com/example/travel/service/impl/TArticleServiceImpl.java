package com.example.travel.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.travel.dao.TArticleDao;
import com.example.travel.entity.TArticle;
import com.example.travel.service.TArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * (TArticle)表服务实现类
 *
 * @author fauchard
 * @since 2022-12-09 07:57:12
 */
@Service("tArticleService")
public class TArticleServiceImpl implements TArticleService {

    @Resource
    private TArticleDao tArticleDao;

    @Override
    public TArticle queryByid(Integer id) {
        return tArticleDao.queryById(id);
    }

    @Override
    public long count2() {
        return tArticleDao.count();
    }

    @Override
    public List<TArticle> findByPage(int pageNumber, int pageSize, String query) {
        List<TArticle> list = new ArrayList<>();
        PageHelper.startPage(pageNumber,pageSize);
        if (Validator.isNotEmpty(query)){
            list = tArticleDao.findListByQuery("%"+query+"%");
        }else {
            list = tArticleDao.findList();
        }
        PageInfo<TArticle> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }

    @Override
    public void deleteById(Integer id) {
        tArticleDao.deleteById(id);
    }

    @Override
    public TArticle findByUserName(String title) {
        return tArticleDao.findByUserName(title);
    }

    @Override
    public int updateOne(TArticle entity) {
        return tArticleDao.update(entity);
    }

    @Override
    public int insert(TArticle tArticle) {
        return tArticleDao.insert(tArticle);
    }

    @Override
    public boolean saveBatch(Collection<TArticle> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TArticle> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<TArticle> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(TArticle entity) {
        return false;
    }

    @Override
    public TArticle getOne(Wrapper<TArticle> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<TArticle> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<TArticle> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<TArticle> getBaseMapper() {
        return null;
    }

    @Override
    public Class<TArticle> getEntityClass() {
        return null;
    }
}

