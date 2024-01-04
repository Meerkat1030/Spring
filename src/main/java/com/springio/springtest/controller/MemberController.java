package com.springio.springtest.controller;

import com.springio.springtest.domain.Member;
import com.springio.springtest.domain.MemberForm;
import com.springio.springtest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
//    private final MemberService memberService = new MemberService();
    // 스프링 사용할때에는 굳이 여러개의 객체를 생성해서 사용할 필요가 없다.
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.printf("가입 회원 이름 : " + member.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> memberList = memberService.findMembers();
        model.addAttribute("members", memberList);

        return "/members/memberList";
    }
}
