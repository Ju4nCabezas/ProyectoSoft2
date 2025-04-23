package com.scrumapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.scrumapp.DatabaseConnection;
import com.scrumapp.models.User;
import com.scrumapp.utils.EncryptUtils;

public class RegisterService {

    public static Boolean register(User user){
        String query = "INSERT INTO usuarios (id, nombre_completo, correo, username, rol, password) values (?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

                if(userExist(user)){
                    String hashedPassword = EncryptUtils.hashPassword(user.getPassword());

                    stmt.setString(1, user.getId());
                    stmt.setString(2, user.getName());
                    stmt.setString(3, user.getMail());
                    stmt.setString(4, user.getUsername());
                    stmt.setString(5, user.getRole());
                    stmt.setString(6, hashedPassword);
                    stmt.executeUpdate();
                    return true;

                }else{
                    System.out.println("Contraseña incorrecta");
                    return false;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Boolean userExist(User user){
        String query = "SELECT * FROM usuarios WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getId());

            ResultSet rs = stmt.executeQuery();

            if (rs.wasNull()) {
                return true;
                
            }else{
                System.out.println("Usuario existente");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
