package com.ExpenseTracker.ExpenseTracker.Repository;

import com.ExpenseTracker.ExpenseTracker.Model.AuthenticationToken;
import com.ExpenseTracker.ExpenseTracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthUser extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByToken(String token);


    AuthenticationToken findFirstByUser(User user);
}