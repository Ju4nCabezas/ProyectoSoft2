package com.scrumapp.controllers.users;

import com.scrumapp.models.User;
import com.scrumapp.services.RegisterService;

public class RegisterController {

    public Boolean register(User user){
        if (user == null) {
            System.out.println("Error de credenciales");
            return false;
        } else {
            return RegisterService.register(user);
        }
    }
    
}
