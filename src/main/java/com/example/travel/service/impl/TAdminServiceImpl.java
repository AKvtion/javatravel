package com.example.travel.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.travel.dao.TAdminDao;
import com.example.travel.entity.TAdmin;
import com.example.travel.service.TAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TAdmin)表服务实现类
 *
 * @author fauchard
 * @since 2022-12-06 14:05:46
 */
@Service("tAdminService")
public class TAdminServiceImpl extends ServiceImpl<TAdminDao, TAdmin> implements TAdminService {
    @Resource
    TAdminDao tAdminDao;

    @Override
    public TAdmin login(String username, String password) {
        TAdmin tAdmin = tAdminDao.selectLogin(username,password);
        return  tAdmin;
    }

    @Override
    public List<TAdmin> selectAll() {
        List<TAdmin> tAdmins = tAdminDao.selectAll();
        return tAdmins;
    }

    @Override
    public int delId(Integer id) {
        return tAdminDao.delById(id);
    }

    @Override
    public TAdmin selectOne(Integer id) {
        return tAdminDao.selectOne(id);
    }

    @Override
    public int add(TAdmin users) {
        return tAdminDao.add(users);
    }

    @Override
    public int updateOne(TAdmin admin) {
        return tAdminDao.updateOne(admin);
    }

    @Override
    public List<TAdmin> getUsersList(String name) {
        return tAdminDao.getUserList(name);
    }

    @Override
    public TAdmin findByUserName(String username) {
        return tAdminDao.findByUserName(username);
    }

    @Override
    public List<TAdmin> findByPage(int pageNumber, int pageSize, String query) {
        List<TAdmin> list = new ArrayList<>();
        PageHelper.startPage(pageNumber,pageSize);
        if (Validator.isNotEmpty(query)){
            list = tAdminDao.findListByQuery("%"+query+"%");
        }else {
            list = tAdminDao.findList();
        }
        PageInfo<TAdmin> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }

}

