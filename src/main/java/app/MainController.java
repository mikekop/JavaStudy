package app;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.UserD;

@Controller
public class MainController {
    @GetMapping("index")
    public String login(){return "login";}

    @GetMapping("privatePage")
    public String messages(Model model, Authentication authentication){

        UserDetails userDetailsAdapter = (UserD) authentication.getPrincipal();
        model.addAttribute("privatePage", userDetailsAdapter.getUsername());
        return "privatePage";
    }
}