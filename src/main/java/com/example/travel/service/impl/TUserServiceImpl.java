package com.example.travel.service.impl;

import cn.hutool.core.lang.Validator;
import com.example.travel.entity.TUser;
import com.example.travel.dao.TUserDao;
import com.example.travel.service.TUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TUser)表服务实现类
 *
 * @author fauchard
 * @since 2022-12-06 16:42:56
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {
    @Resource
    private TUserDao tUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUser queryByid(Integer id) {
        return this.tUserDao.queryByid(id);
    }

    /**
     * 分页查询
     *
     * @param tUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TUser> queryByPage(TUser tUser, PageRequest pageRequest) {
        long total = this.tUserDao.count(tUser);
        return new PageImpl<>(this.tUserDao.queryAllByLimit(tUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser insert(TUser tUser) {
        this.tUserDao.insert(tUser);
        return tUser;
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserDao.update(tUser);
        return this.queryByid(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUserDao.deleteById(id) > 0;
    }

    @Override
    public long count2() {
        return tUserDao.count2();
    }

    @Override
    public long count(TUser u) {
        return tUserDao.count(u);
    }

    @Override
    public TUser findByUserName(String username) {
        return tUserDao.findByUserName(username);
    }

    @Override
    public void save(TUser entity) {
        tUserDao.save(entity);
    }

    @Override
    public List<TUser> findByPage(int pageNumber, int pageSize, String query) {
        List<TUser> list = new ArrayList<>();
        PageHelper.startPage(pageNumber,pageSize);
        if (Validator.isNotEmpty(query)){
            list = tUserDao.findListByQuery("%"+query+"%");
        }else {
            list = tUserDao.findList();
        }
        PageInfo<TUser> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }


}
