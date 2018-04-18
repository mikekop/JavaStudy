package ru.logrocon.lesson9;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.logrocon.lesson9.security.AuthUser;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){return "index";}

    @GetMapping("incidents")
    public String incidents(Model model, Authentication authentication){
        AuthUser userDetailsAdapter = (AuthUser) authentication.getPrincipal();
        model.addAttribute("userIncidents", userDetailsAdapter.getUser().getIncidents());
        return "incidents";
    }
}