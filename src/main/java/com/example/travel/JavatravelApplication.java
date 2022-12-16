package com.example.travel;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.travel.dao.TArticleDao;
import com.example.travel.entity.TArticle;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@MapperScan("com.example.travel.dao")
public class JavatravelApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavatravelApplication.class, args);
    }


}
