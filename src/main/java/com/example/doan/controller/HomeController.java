package com.example.doan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
@Controller
public class HomeController {

    @GetMapping("/login")
    public String showLoginPage() throws IOException {
        return "login";
    }

    @GetMapping("/users")
    public String showUsers() throws IOException {
        return "user_manage";
    }
    @GetMapping("/noti")
    public String showNoti() throws IOException {
        return "noti_manage";
    }
    @GetMapping("/report")
    public String showReport() throws IOException {
        return "post_noti";
    }

    @GetMapping("/home")
    public String showHomePage() {
        // Thêm bất kỳ dữ liệu nào cần thiết vào model
        return "Home/home";
    }
}