package com.example.travel.controller.manager;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.example.travel.controller.base.BaseController;
import com.example.travel.controller.base.PageParam;
import com.example.travel.entity.TArticle;
import com.example.travel.service.TArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ArticleController extends BaseController {

    @Autowired
    TArticleService tArticleService;


    @RequestMapping("/articleList")
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
        mv.setViewName("article/articleList");
        return mv;
    }


    @RequestMapping("/articleAdd")
    public ModelAndView articleAdd(){
        ModelAndView mv = this.getModeAndView();
        mv.addObject("entity",new TArticle());
        mv.setViewName("article/articleEdit");
        return mv;
    }

    @RequestMapping("/articleView")
    public ModelAndView articleView(Integer id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",tArticleService.queryByid(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("article/articleView");
        return mv;
    }

    @RequestMapping("/articleEdit")
    public ModelAndView articleEdit(Integer id){
        ModelAndView mv = this.getModeAndView();
        System.out.println(id);
        try {
            mv.addObject("entity",tArticleService.queryByid(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("article/articleEdit");
        return mv;
    }

    @RequestMapping("/articleSave")
    public ModelAndView articleSave(HttpServletRequest request, Integer id, RedirectAttributes redirectAttributes){
        ModelAndView mv = this.getModeAndView();
        TArticle entity = null;
        try {
            if(Validator.isNotEmpty(id)){
                entity = tArticleService.queryByid(id);
            }else{
                entity = new TArticle();
            }
            this.bindValidateRequestEntity(request,entity);
            if (Validator.isEmpty(entity.getId())){
                TArticle object = tArticleService.findByUserName(entity.getTitle());
                if (object != null) {
                    mv.addObject("message","标题已存在!");
                    mv.addObject("entity",entity);
                    mv.setViewName("article/articleEdit");
                    return mv;
                }
                entity.setId(RandomUtil.randomInt(32));
                tArticleService.insert(entity);
            }else{
                tArticleService.updateOne(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("pageData", tArticleService.findByPage(1, 10,null));
        PageParam pageParam =new PageParam();
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
        mv.addObject("pageParam",pageParam);
        mv.setViewName("article/articleList");
        return mv;
    }

    @RequestMapping("/articleDelete")
    public String articleDelete(Integer id){
        if(Validator.isNotEmpty(id)){
            try {
                tArticleService.deleteById(id);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return REDIRECT+"/manager/articleList";
    }
}
