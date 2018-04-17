package ru.logrocon.app.web;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.logrocon.app.entity.Good;
//import ru.logrocon.app.security.AuthUser;
import ru.logrocon.app.security.AuthUser;
import ru.logrocon.app.service.GoodService;

import java.util.Set;
import java.util.logging.Logger;

@Controller
public class AppController {

    private static Logger log = Logger.getLogger(AppController.class.getName());

    @Autowired
    private GoodService goodService;

    @GetMapping("/")
    public String home(){return "home";}
    @GetMapping("/login")
    public String login(){return "login";}
    @GetMapping("/messages")
    public String messages(Model model, Authentication authentication){
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        model.addAttribute("messages", authUser.getBaseUser().getMessages());
        return "messages";
    }
    @GetMapping("/goods")
    public String goods(Model model, Authentication authentication){
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
//        model.addAttribute("goods", authUser.getBaseUser().getGoods());
        model.addAttribute("goods", goodService.getByUserLogin(authUser.getUsername()));

        return "goods";
    }
}
