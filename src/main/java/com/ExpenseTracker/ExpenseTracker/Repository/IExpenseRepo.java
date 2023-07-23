package com.ExpenseTracker.ExpenseTracker.Repository;

import com.ExpenseTracker.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.ExpenseTracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExpenseRepo extends JpaRepository<Expense,Long> {
    List<Expense> findByUser(User user);
}
