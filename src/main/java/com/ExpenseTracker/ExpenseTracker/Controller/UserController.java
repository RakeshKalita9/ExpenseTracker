package com.ExpenseTracker.ExpenseTracker.Controller;

import com.ExpenseTracker.ExpenseTracker.Model.Expense;
import com.ExpenseTracker.ExpenseTracker.Model.User;
import com.ExpenseTracker.ExpenseTracker.Model.dto.SignInInput;
import com.ExpenseTracker.ExpenseTracker.Model.dto.SignUpOutput;
import com.ExpenseTracker.ExpenseTracker.Service.AuthenticationService;
import com.ExpenseTracker.ExpenseTracker.Service.ExpenseService;
import com.ExpenseTracker.ExpenseTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    ExpenseService expenseService;
    @PostMapping("signUp/user")
    public SignUpOutput signUp(@RequestBody User user) throws NoSuchAlgorithmException {
        return userService.signUp(user);
    }
    @PostMapping("login/user")
    public String signIn(@RequestBody SignInInput signInInput) throws NoSuchAlgorithmException {
        return userService.signIn(signInInput);
    }
    @PostMapping("create/expense")
    public String createExpense(@RequestBody Expense expense, @RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
          expenseService.saveExpense(expense,email);
          return "Expense Posted to the Portal";
        }
        return "Authentication Failed";
    }
    @GetMapping("expenses/user")
    public List<Expense> getAllExpense(@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
          return   expenseService.getAllExpense(email);
        }
        return null;
    }
    @PutMapping("expense/description")
    public String updateExpense(@RequestParam Long id,@RequestParam String s,@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
            return expenseService.updateExpense(id,email,s);
        }
        return "Authentication Failed";
    }
    @DeleteMapping("expense")
    public String deleteExpense(@RequestParam Long id,@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
            return expenseService.deleteExpense(id,email);
        }
        return "Authentication Failed";
    }
    @DeleteMapping("user/logOut")
    public String logoutUser(@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
            return userService.logOut(email);
        }
        return "Authentication Failed";
    }
    @GetMapping("expense/month/year")
    public String getExpenses(@RequestParam String Month,@RequestParam int year,@RequestParam String email,@RequestParam String token){
        if(authenticationService.authenticate(email,token)){
            return expenseService.getAmount(email,Month,year);
        }
        return "Authentication Failed";
    }

}
