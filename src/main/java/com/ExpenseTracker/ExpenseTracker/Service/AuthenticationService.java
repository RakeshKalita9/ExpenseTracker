package com.ExpenseTracker.ExpenseTracker.Service;

import com.ExpenseTracker.ExpenseTracker.Model.AuthenticationToken;
import com.ExpenseTracker.ExpenseTracker.Model.User;
import com.ExpenseTracker.ExpenseTracker.Repository.IAuthUser;
import com.ExpenseTracker.ExpenseTracker.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthUser authUser;
    @Autowired
    IUserRepo userRepo;


    public boolean authenticate(String userEmail, String token) {
        AuthenticationToken authenticationToken = authUser.findFirstByToken(token);
        User user = authenticationToken.getUser();
        User user1 = userRepo.findFirstByUserEmail(userEmail);
        return user.equals(user1);
    }
}
