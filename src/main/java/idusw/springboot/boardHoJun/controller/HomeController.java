package idusw.springboot.boardHoJun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHome() {
        return "redirect:/admin";
    }
    @GetMapping("admin")
    public String getAdmin() {
        System.out.println("getAdmin");
        return "/admin/index";
    }
    @GetMapping("buttons") // 자원을 접근하는 개념 , /admin/buttons
    public String getButtons() {
        return "/admin/buttons";
    }

    @GetMapping("cards") // 자원을 접근하는 개념
    public String getCards() {
        return "/admin/cards";
    }
}
