package com.example.travel.controller.manager;


import com.example.travel.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {
//
//    @Autowired
//    UserService userService;
//    @Resource
//    UserDao userDao;

    @RequestMapping("/index")
    public ModelAndView manager(HttpServletRequest request){
        ModelAndView mv = this.getModeAndView();
        Object admin = request.getSession().getAttribute("admin");
        if (admin == null){
            mv.setViewName("login");
            return mv;
        }
        mv.setViewName("index");
        return mv; }

    @RequestMapping("/main")
    public ModelAndView main() throws Exception {
        ModelAndView mv = this.getModeAndView();
//        mv.addObject("porvice",userService.countPorvice());
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/404")
    public ModelAndView notFound(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("404");
        return mv;
    }
    @RequestMapping("/systemParameter")
    public ModelAndView systemParameter(){
        ModelAndView mv = this.getModeAndView();
        mv.setViewName("systemParameter/systemParameter");
        return mv;
    }

    @RequestMapping("/test")
    public void test(@RequestBody String resmsg) throws IOException {
        System.out.println(resmsg);
    }

}
