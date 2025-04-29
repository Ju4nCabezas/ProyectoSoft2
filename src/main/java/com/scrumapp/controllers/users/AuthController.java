package com.scrumapp.controllers.users;

import com.scrumapp.models.User;
import com.scrumapp.services.AuthService;

public class AuthController {

    public User login(String username, String password){
        if(username == null || password == null){
            System.out.println("Error de credenciales");
            return null;
        }
        User user = AuthService.login(username, password);
        return user;
    }
    
}
