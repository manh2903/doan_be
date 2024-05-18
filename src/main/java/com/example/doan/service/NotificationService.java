package com.example.doan.service;




import com.example.doan.model.Data;
import com.example.doan.model.Notice;
import com.example.doan.model.NotificationRequest;
import com.google.firebase.messaging.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final FirebaseMessaging firebaseMessaging;

    public BatchResponse sendNotification(Notice notice) {
        List<String> registrationTokens=notice.getToken();

        Notification notification = Notification.builder()
                .setTitle(notice.getTitle())
                .setBody(notice.getBody())
                .build();

        Map<String, String> data = new HashMap<>();
        data.put("longitude", String.valueOf(notice.getLongitude()));
        data.put("latitude", String.valueOf(notice.getLatitude()));

        MulticastMessage message = MulticastMessage.builder()
                .addAllTokens(registrationTokens)
                .setNotification(notification)
                .putAllData(data)
                .build();

        BatchResponse batchResponse = null;
        try {
            batchResponse = firebaseMessaging.sendMulticast(message);
        } catch (FirebaseMessagingException e) {
            log.info("Firebase error {}", e.getMessage());
        }
        if (batchResponse.getFailureCount() > 0) {
            List<SendResponse> responses = batchResponse.getResponses();
            List<String> failedTokens = new ArrayList<>();
            for (int i = 0; i < responses.size(); i++) {
                if (!responses.get(i).isSuccessful()) {
                    failedTokens.add(registrationTokens.get(i));
                }
            }
            log.info("List of tokens that caused failures: " + failedTokens);
        }
        return batchResponse;
    }

    public BatchResponse sendNotification(NotificationRequest request) {

        List<String> registrationTokens = request.getToken();

        Data data = request.getData();
        String time = request.getTime();

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("type", data.getType());
        dataMap.put("title", data.getTitle());
        dataMap.put("body", data.getBody());
        dataMap.put("longitude", String.valueOf(data.getLongitude()));
        dataMap.put("latitude", String.valueOf(data.getLatitude()));
       // dataMap.put("source",data.getSource());
      //  dataMap.put("list_question",data.getList_question());
        dataMap.put("time",time);

        MulticastMessage multicastMessage = MulticastMessage.builder()
                .addAllTokens(registrationTokens)
                .setNotification(null)
                .putAllData(dataMap)
                .build();

        BatchResponse batchResponse = null;
        try {
            batchResponse = firebaseMessaging.sendMulticast(multicastMessage);
        } catch (Exception e) {
            log.error("Error sending notification: {}", e.getMessage());
        }

        if (batchResponse != null && batchResponse.getFailureCount() > 0) {
            log.warn("Notification failed for some devices");
        }

        return batchResponse;
    }

    public BatchResponse sendNotification_admin_v1(NotificationRequest request) {

        List<String> registrationTokens = request.getToken();

        Data data = request.getData();
        String time = request.getTime();

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("type", data.getType());
        dataMap.put("title", data.getTitle());
        dataMap.put("body", data.getBody());
        dataMap.put("source",data.getSource());
        dataMap.put("time",time);

        MulticastMessage multicastMessage = MulticastMessage.builder()
                .addAllTokens(registrationTokens)
                .setNotification(null)
                .putAllData(dataMap)
                .build();

        BatchResponse batchResponse = null;
        try {
            batchResponse = firebaseMessaging.sendMulticast(multicastMessage);
        } catch (Exception e) {
            log.error("Error sending notification: {}", e.getMessage());
        }

        if (batchResponse != null && batchResponse.getFailureCount() > 0) {
            log.warn("Notification failed for some devices");
        }

        return batchResponse;
    }
    public BatchResponse sendNotification_admin_v2(NotificationRequest request) {

        List<String> registrationTokens = request.getToken();

        Data data = request.getData();
        String time = request.getTime();

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("type", data.getType());
        dataMap.put("title", data.getTitle());
        dataMap.put("body", data.getBody());
        dataMap.put("list_question",data.getList_question());
        dataMap.put("time",time);

        MulticastMessage multicastMessage = MulticastMessage.builder()
                .addAllTokens(registrationTokens)
                .setNotification(null)
                .putAllData(dataMap)
                .build();

        BatchResponse batchResponse = null;
        try {
            batchResponse = firebaseMessaging.sendMulticast(multicastMessage);
        } catch (Exception e) {
            log.error("Error sending notification: {}", e.getMessage());
        }

        if (batchResponse != null && batchResponse.getFailureCount() > 0) {
            log.warn("Notification failed for some devices");
        }

        return batchResponse;
    }



}