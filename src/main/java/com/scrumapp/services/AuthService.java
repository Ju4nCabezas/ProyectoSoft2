package com.scrumapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.scrumapp.DatabaseConnection;
import com.scrumapp.models.User;
import com.scrumapp.utils.EncryptUtils;

public class AuthService {

    public static User login(String username, String password){
        String query = "SELECT * FROM usuarios WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                if (EncryptUtils.verifyPassword(password, hashedPassword)) {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("nombre_completo"));
                    user.setMail(rs.getString("correo"));
                    user.setUsername(rs.getString("username"));
                    user.setRole(rs.getString("rol"));
                    return user;
                }else{
                    System.out.println("Contraseña incorrecta");
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
