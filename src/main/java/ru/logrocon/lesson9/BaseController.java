package ru.logrocon.lesson9;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping("/")
    public String home(){return "index";}

    @GetMapping("login")
    public String login(){return "login";}

    // Защищенная
    @GetMapping("goods")
    public String messages(Model model, Authentication authentication){
        AuthUser userDetailsAdapter = (AuthUser) authentication.getPrincipal();
        model.addAttribute("goods", userDetailsAdapter.getUser().getGoodsById());
        return "messages";
    }
}
