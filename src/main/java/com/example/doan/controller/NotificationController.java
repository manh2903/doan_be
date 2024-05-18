package com.example.doan.controller;



import com.example.doan.model.Notice;
import com.example.doan.model.NotificationRequest;
import com.example.doan.service.NotificationService;
import com.google.firebase.messaging.BatchResponse;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/firebase")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping("/send-notification-v1")
    public BatchResponse sendNotification(@RequestBody Notice notice){
        return notificationService.sendNotification(notice);
    }

    @PostMapping("/send-notification-v2")
    public BatchResponse sendNotification2(@RequestBody NotificationRequest notice){
        return notificationService.sendNotification(notice);
    }

    @PostMapping("/send-notification-admin-v1")
    public BatchResponse sendNotification3(@RequestBody NotificationRequest notice){
        return notificationService.sendNotification_admin_v1(notice);
    }
    @PostMapping("/send-notification-admin-v2")
    public BatchResponse sendNotification4(@RequestBody NotificationRequest notice){
        return notificationService.sendNotification_admin_v2(notice);
    }


}