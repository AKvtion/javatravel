package com.example.travel.controller.manager;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import com.example.travel.controller.base.BaseController;
import com.example.travel.controller.base.PageParam;
import com.example.travel.entity.TUser;
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
@RequestMapping("/manager")
public class UserController extends BaseController {

    @Autowired
    TUserService userService;

    @RequestMapping("/userList")
    public ModelAndView userList(PageParam pageParam, @RequestParam(value = "query", required = false) String query) {
        ModelAndView mv = this.getModeAndView();
        if(pageParam.getPageNumber()<1){
            pageParam =new PageParam();
            long count = 0;
            try {
                count = userService.count2();
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
        List<TUser> list = userService.findByPage(pageParam.getPageNumber(),pageParam.getPageSize(), query);
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
        mv.setViewName("user/allUsers");
        return mv;
    }


    @RequestMapping("/userAdd")
    public ModelAndView userAdd(){
        ModelAndView mv = this.getModeAndView();
        mv.addObject("entity",new TUser());
        mv.setViewName("user/userEdit");
        return mv;
    }

    @RequestMapping("/userView")
    public ModelAndView userView(Integer id){
        ModelAndView mv = this.getModeAndView();
        try {
            mv.addObject("entity",userService.queryByid(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("user/userView");
        return mv;
    }

    @RequestMapping("/userEdit")
    public ModelAndView userEdit(Integer id){
        ModelAndView mv = this.getModeAndView();
        System.out.println(id);
        try {
            mv.addObject("entity",userService.queryByid(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        mv.setViewName("user/userEdit");
        return mv;
    }

    @RequestMapping("/userSave")
    public ModelAndView userSave(HttpServletRequest request, Integer id, RedirectAttributes redirectAttributes){
        ModelAndView mv = this.getModeAndView();
        TUser entity = null;
        try {
            if(Validator.isNotEmpty(id)){
                entity = userService.queryByid(id);
            }else{
                entity = new TUser();
            }
            this.bindValidateRequestEntity(request,entity);
            if (Validator.isEmpty(entity.getId())){
                TUser object = userService.findByUserName(entity.getUsername());
                if (object != null) {
                    mv.addObject("message","用户名已存在!");
                    mv.addObject("entity",entity);
                    mv.setViewName("user/userEdit");
                    return mv;
                }
                entity.setId(RandomUtil.randomInt(32));
                userService.save(entity);
            }else{
                userService.update(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("pageData", userService.findByPage(1, 10,null));
        PageParam pageParam =new PageParam();
        long count = 0;
        try {
            count = userService.count2();
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
        mv.setViewName("user/allUsers");
        return mv;
    }

    /**
     * 删除用户方法
     * @param id
     * @return
     */
    @RequestMapping("/userDelete")
    public String userDelete(Integer id){
        if(Validator.isNotEmpty(id)){
            try {
                userService.deleteById(id);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return REDIRECT+"/manager/userList";
    }
}
