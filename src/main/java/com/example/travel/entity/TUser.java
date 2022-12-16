package com.example.travel.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author fauchard
 * @since 2022-12-06 16:42:22
 */
@Data
public class TUser implements Serializable {
    private static final long serialVersionUID = 970297274844897626L;
    
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 真实名字
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 省份
     */
    private Integer province;


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

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

}

