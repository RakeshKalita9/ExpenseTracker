package com.ExpenseTracker.ExpenseTracker.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDate date;



    @ManyToOne
    @JoinColumn(name="fk_User_Id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_Expense_id")
    private List<Product> productList;

}
