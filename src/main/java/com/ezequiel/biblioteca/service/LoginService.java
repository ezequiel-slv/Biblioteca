package com.ezequiel.biblioteca.service;
import com.ezequiel.biblioteca.connection.ConnectionDB;
import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.repository.LoginInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService implements LoginInterface {

    @Override
    public boolean buscar(Estudante estudante) {
        String sql = "SELECT 1 FROM tb_estudante WHERE email = ? AND senha = ?";

        try {
            PreparedStatement ps = ConnectionDB.connectionDB().prepareStatement(sql);

            ps.setString(1, estudante.getEmail());
            ps.setString(2, estudante.getSenha());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
