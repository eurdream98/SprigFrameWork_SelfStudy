package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
public class FirstController {
@GetMapping("regist")
    public void regist(){

}
@PostMapping("regist")
    public String registMenu(Model model, WebRequest request)
{String name = request.getParameter("name");
    int price = Integer.parseInt(request.getParameter("price"));
    int categoryCode=Integer.parseInt(request.getParameter("categoryCode"));
    String message = name+"을 신규 메뉴 목록의"+categoryCode+"번 카테고리에"+price+"원으로 등록하셨습니다!";
    System.out.println(message);
    model.addAttribute("message",message);
    return "first/messagePrinter";
}

@GetMapping("/modify")
    public void modify(){

}
//@PostMapping("/modify")
//    public String modifyMenu(Model model,WebRequest request){
//    String name = request.getParameter("modifyName");
//    int price = Integer.parseInt(request.getParameter("modifyPrice"));
//    String message = name+"음식의 가격이"+price+"원으로 변경되었습니다!";
//    System.out.println(message);
//    model.addAttribute("message",message);
//    return "first/messagePrinter";
//}

    @PostMapping("/modify")
    public String modifyMenu(Model model, @RequestParam(required = false)String modifyName,@RequestParam(required = false)int modifyPrice){
    String message = modifyName+"라는 음식이"+modifyPrice+"원으로 변경됩니다";
        System.out.println(message);
        model.addAttribute("message",message);
    return "/first/messagePrinter";


    }
@PostMapping("/modifyAll")
    public String modifyMenu2(Model model,@RequestParam(required=false)String modifyName2,@RequestParam(required = false)int modifyPrice2){
    String message = modifyName2+"라는 식사가"+modifyPrice2+"원으로 변경될거에요!";
    System.out.println(message);
    model.addAttribute("message",message);

    return "/first/messagePrinter";
}

@GetMapping("/search")
    public void search(){

}

@PostMapping("/search")
    public String search(@ModelAttribute("menu")MemberDTO menu){
    System.out.println(menu);
    return "first/searchResult";
}

@GetMapping("/login")
    public void login(){

}
@PostMapping("/login")
    public String login2(HttpSession session,@RequestParam String id){
    session.setAttribute("id",id);
    return"first/loginResult";
}
@GetMapping("/logout1")
    public String logout1(HttpSession session){
session.invalidate();
return "first/loginResult";
}
//@GetMapping("/logout1")
//public String logout1(HttpSession session,@RequestParam(name="id",required = false) String id,Model model){
//    session.setAttribute("id",id);
//    model.addAttribute("user",id);
//    session.invalidate();
//
//    return "first/logout1";
//}
@PostMapping("login2")
    public String login2(Model model,@RequestParam String id){
    model.addAttribute("id",id);
    return"first/loginResult";
}
@GetMapping("logout2")
    public String logout2(SessionStatus sessionStatus){
    sessionStatus.setComplete();
    return "first/loginResult";
}

@GetMapping("body")
    public void body(){}




}
