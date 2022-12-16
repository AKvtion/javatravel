package com.example.travel.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (TAdmin)表实体类
 *
 * @author fauchard
 * @since 2022-12-06 14:05:46
 */
@SuppressWarnings("serial")
@Data
public class TAdmin extends Model<TAdmin> {
    //主键
    private Integer id;
    //用户名
    private String username;
    //真实名字
    private String name;
    //密码
    private String password;
    //手机号
    private String phone;
    //状态
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }

