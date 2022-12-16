package com.example.travel.controller.manager;

import cn.hutool.core.lang.Validator;
import com.example.travel.controller.base.BaseController;
import com.example.travel.entity.TAdmin;
import com.example.travel.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController extends BaseController {

    @Autowired
    TAdminService adminService;

    @RequestMapping("/")
    public String index(){
        return "front";
    }

    @RequestMapping("index")
    public String index2(){
        return REDIRECT+"/";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        Object user = request.getSession().getAttribute("admin");
        if (user != null) {
            return REDIRECT+"/manager/index";
        }
        return "login";
    }

    @RequestMapping("/loging")
    public String loging(String userName,String password,RedirectAttributes redirectAttributes,HttpServletRequest request){
        if (Validator.isEmpty(userName) || Validator.isEmpty(password)){
            redirectAttributes.addFlashAttribute("message","用户名密码不得为空!");
            return REDIRECT+"/login";
        }
        try {
            TAdmin admin = adminService.login(userName, password);
            if (Validator.isEmpty(admin)){
                redirectAttributes.addFlashAttribute("message","用户名不存在或密码错误!");
                return REDIRECT+"/login";
            }else{
                if (admin.getState() == 1) {
                    request.getSession().setAttribute("admin", admin);
                    return REDIRECT+"/manager/index";
                } else {
                    redirectAttributes.addFlashAttribute("message","账户已被停用!");
                    return REDIRECT+"/login";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return REDIRECT+"/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        Object user = request.getSession().getAttribute("admin");
        if (user != null) {
            request.getSession().removeAttribute("admin");
        }
        return "login";
    }
}
