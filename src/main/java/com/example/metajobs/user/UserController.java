package com.example.metajobs.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원목록 출력
    @GetMapping("/users")
    public List<UserVO> findAllUsers() {
        //@RestController 어노테이션으로 알아서 JSON 형태로 리턴
        return userService.findAllUsers();
    }

    //해당 회원정보 출력
    @GetMapping("/users/{mem_id}")
    public EntityModel<UserVO> findUser(@PathVariable String mem_id) {
        UserVO user = userService.findUser(mem_id);

        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", mem_id));
        }

        //user와 link를 함께 리턴
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).findAllUsers()).withRel("all-users"));
    }

    //회원가입
    @PostMapping("/users")
    public void createUser(@RequestBody UserVO user) {
        //JSON 형태를 자바 객체 형태로 바꿔주기 위해 @RequestBody
        userService.insertMember(user);
    }

    //회원탈퇴
    @DeleteMapping("/users/{mem_id}")
    public void deleteUser(@PathVariable String mem_id) {
        UserVO user = userService.findUser(mem_id);

        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", mem_id));
        } userService.deleteMember(mem_id);
    }

    //회원수정
    @PostMapping("/users/{mem_id}")
    public void updateUser(@PathVariable String mem_id, @RequestBody UserVO user) {
        userService.updateMember(mem_id, user);
    }

    //로그인
    @PostMapping("/users/login")
    public String loginUser(HttpServletRequest request, UserVO user, RedirectAttributes rttr) {
        HttpSession session = request.getSession();
        UserVO login = userService.loginMember(user);

        if (login == null) {
            int result = 0;
            rttr.addFlashAttribute("result", result);
            session.setAttribute("member", null);
            String message = "";
            message="<script>alert('LogIn Failed :('); location.href='/'; </script>";
            return message;
        } else{
            int result = 1;
            rttr.addFlashAttribute("result", result);
            session.setAttribute("member", login);
            String message = "";
            message="<script>alert('LogIn Success :)'); location.href='/'; </script>";
            return message;
        }
    }

    //로그아웃
    @GetMapping("/users/logout")
    public String logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.invalidate();
        String message = "";
        message="<script>alert('LogOut Successs :)'); location.href='/'; </script>";
        return message;
    }

}
