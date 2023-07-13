package buysellprojoect.buysell.contollers;

import buysellprojoect.buysell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class AdminController {
    private final UserService userService;


    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("users", userService.listUser());
        return "admin";
    }

    @PostMapping("/admin/user/ban/{id}")
    public String userBanning(@PathVariable("id") Long id){
        userService.userBan(id);
        return "redirect: /admin";
    }



}
