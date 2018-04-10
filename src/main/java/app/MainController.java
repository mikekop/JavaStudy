package app;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.logrocon.app.security.AuthUser;
import spring.UserD;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(){return "home";}

    @GetMapping("login")
    public String login(){return "login";}

    @GetMapping("messages")
    public String messages(Model model, Authentication authentication){

        UserDetails userDetailsAdapter = (UserD) authentication.getPrincipal();
        model.addAttribute("messages", userDetailsAdapter.getBaseUser().getMessages());
        return "messages";
    }
}