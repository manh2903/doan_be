package com.example.doan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final FirebaseAuth firebaseAuth;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        try {
            logger.info("Attempting to delete user with ID: {}", userId);
            firebaseAuth.deleteUser(userId);
            logger.info("User with ID: {} deleted successfully", userId);
            return ResponseEntity.ok("User deleted successfully");
        } catch (FirebaseAuthException e) {
            logger.error("Error deleting user with ID: {}: {}", userId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting user: " + e.getMessage());
        }
    }
}
