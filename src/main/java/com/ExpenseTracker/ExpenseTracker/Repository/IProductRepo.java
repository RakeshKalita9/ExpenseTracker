package com.ExpenseTracker.ExpenseTracker.Repository;

import com.ExpenseTracker.ExpenseTracker.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Long> {
}
