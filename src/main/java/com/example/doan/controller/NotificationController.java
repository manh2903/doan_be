package com.example.doan.controller;



import com.example.doan.model.Notice;
import com.example.doan.service.NotificationService;
import com.google.firebase.messaging.BatchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/firebase")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping("/send-notification")
    public BatchResponse sendNotification(@RequestBody Notice notice){
        return notificationService.sendNotification(notice);
    }
}