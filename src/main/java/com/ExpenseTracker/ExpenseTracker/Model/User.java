package com.ExpenseTracker.ExpenseTracker.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[A-Z].*",message = "First letter Should Be Capital")
    private String userFirstName;

    @NotBlank
    @Pattern(regexp = "^[A-Z].*",message = "First letter Should Be Capital")
    private String userLastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String userEmail;

    @NotBlank
    @Size(min = 8,message = "min password length should be 8")
    private String userPassword;
}
