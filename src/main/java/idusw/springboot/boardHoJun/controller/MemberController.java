package idusw.springboot.boardHoJun.controller;

import idusw.springboot.boardHoJun.domain.Member;
import idusw.springboot.boardHoJun.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    // 생성자 주입
    MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/login")
    public String getLoginForm() {
        //memberService.toString();
        return "/members/login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        // Member 형의 객체를 생성하고,
        model.addAttribute("member", Member.builder().build());

        return "/members/register"; // templates/members/register.html : view resolving
    }
    @PostMapping("/register")
    public String registerMember(@ModelAttribute("member") Member m , Model model) {
        if(memberService.create(m) > 0)
            return "redirect:members/login"; // 홈으로 재지정함 : 홈 컨트롤러에게 재지정 /members/login.html *18
        else
            return "redirect:members/register";
    }

    @GetMapping("/forgot")
    public String getForgotForm() {
        //memberService.toString();
        return "/members/forgot-password";
    }


}
