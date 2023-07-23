package com.ExpenseTracker.ExpenseTracker.Repository;

import com.ExpenseTracker.ExpenseTracker.Model.User;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String userEmail);
}
