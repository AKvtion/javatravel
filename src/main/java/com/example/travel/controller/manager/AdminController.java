package com.example.travel.controller.manager;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.example.travel.controller.base.BaseController;
import com.example.travel.controller.base.PageParam;
import com.example.travel.entity.TAdmin;
import com.example.travel.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class AdminController extends BaseController {

    @Autowired
    TAdminService adminService;

    @RequestMapping("/adminList")
    public ModelAndView adminList(PageParam pageParam, @RequestParam(value = "query", required = false) String query) {
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = adminService.count();
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
        List<TAdmin> list = adminService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize(), query);
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
        mv.setViewName("admin/adminList");
        return mv;
    }


    @RequestMapping("/adminAdd")
    public ModelAndView adminAdd(){
        ModelAndView mv = this.getModeAndView();
        mv.addObject("entity",new TAdmin());
        mv.setViewName("admin/adminEdit");
        return mv;
    }

    @RequestMapping("/adminView")
    public ModelAndView adminView(Integer id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",adminService.selectOne(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("admin/adminView");
        return mv;
    }

    @RequestMapping("/adminEdit")
    public ModelAndView adminEdit(Integer id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",adminService.selectOne(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("admin/adminEdit");
        return mv;
    }

    @RequestMapping("/adminSave")
    public ModelAndView adminSave(HttpServletRequest request, Integer id){
        ModelAndView mv = this.getModeAndView();
        TAdmin entity = null;
        try {
            if(Validator.isNotEmpty(id)){
                entity = adminService.selectOne(id);
            }else{
                entity = new TAdmin();
            }
            this.bindValidateRequestEntity(request,entity);
            if (Validator.isEmpty(entity.getId())){
                TAdmin object = adminService.findByUserName(entity.getUsername());
                if (object != null) {
                    mv.addObject("message","用户名已存在!");
                    mv.addObject("entity",entity);
                    mv.setViewName("admin/adminEdit");
                    return mv;
                }
                entity.setId(RandomUtil.randomInt(32));
                adminService.save(entity);
            }else{
                adminService.updateOne(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("pageData", adminService.findByPage(1, 10,null));
        PageParam pageParam =new PageParam();
        long count = 0;
        try {
            count = adminService.count();
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
        mv.setViewName("admin/adminList");
        return mv;
    }

    @RequestMapping("/adminDelete")
    public String adminDelete(Integer id){
        if(Validator.isNotEmpty(id)){
            try {
                adminService.delId(id);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return REDIRECT+"/manager/adminList";
    }
}
