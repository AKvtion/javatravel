package com.example.travel.controller.front;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.example.travel.controller.base.BaseController;
import com.example.travel.controller.base.PageParam;
import com.example.travel.entity.TArticle;
import com.example.travel.entity.TUser;
import com.example.travel.service.TArticleService;
import com.example.travel.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/front")
public class route extends BaseController {

    @Autowired
    TArticleService tArticleService;

    @RequestMapping("/allArticle")
    public ModelAndView articleList(PageParam pageParam, @RequestParam(value = "query", required = false) String query) {
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = tArticleService.count2();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pageParam.setCount(count);
            if(count<=10){
                pageParam.setSize(1);
            }else{
                pageParam.setSize(count%10==0?count/10:count/10+1);
            }
            pageParam.setPageNumber(1);
            pageParam.setPageSize(10);
        }
        List<TArticle> list = tArticleService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize(), query);

        mv.addObject("pageData", list);
        if (Validator.isNotEmpty(query)) {
            mv.addObject("query", query);
            pageParam.setCount(list.size());
            if (list.size() > pageParam.getPageSize()) {
                pageParam.setSize(list.size() / pageParam.getPageSize());
            } else {
                pageParam.setSize(1);
            }
        }
        mv.addObject("pageParam",pageParam);
        mv.setViewName("article/allContent");
        return mv;
    }


    @RequestMapping("/articleOne")
    public ModelAndView articleOne(Integer id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",tArticleService.queryByid(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("article/articleOne");
        return mv;
    }
}
