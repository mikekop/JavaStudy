package ru.logrocon.app.web;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.logrocon.app.security.AuthUser;

@Controller
public class AppController {
    @GetMapping("/")
    public String home(){return "home";}

    @GetMapping("login")
    public String login(){return "login";}

    // Защищенная
    @GetMapping("messages")
    public String messages(Model model, Authentication authentication){
        AuthUser userDetailsAdapter = (AuthUser) authentication.getPrincipal();
        model.addAttribute("messages", userDetailsAdapter.getBaseUser().getMessages());
        return "messages";
    }
}
