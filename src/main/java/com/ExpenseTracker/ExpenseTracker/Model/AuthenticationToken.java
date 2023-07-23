package com.ExpenseTracker.ExpenseTracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private LocalDateTime creationTime;
    @OneToOne
    private User user;
    public AuthenticationToken(User user1){
        this.token= UUID.randomUUID().toString();
        this.creationTime =LocalDateTime.now();
        this.user=user1;
    }
}
