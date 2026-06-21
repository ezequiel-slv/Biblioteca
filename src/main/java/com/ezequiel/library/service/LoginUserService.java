package com.ezequiel.library.service;
import com.ezequiel.library.connection.ConnectionDB;
import com.ezequiel.library.model.User;
import com.ezequiel.library.repository.LoginInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserService implements LoginInterface {

    @Override
    public boolean buscar(User user) {
        String sql = "SELECT 1 FROM tb_estudante WHERE email = ? AND senha = ?";

        try {
            PreparedStatement ps = ConnectionDB.connectionDB().prepareStatement(sql);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getSenha());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
