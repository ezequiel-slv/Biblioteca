package com.ezequiel.biblioteca.service;
import com.ezequiel.biblioteca.connection.ConnectionDB;
import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.repository.LoginInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService implements LoginInterface {

    @Override
    public Estudante buscar(String email, String senha) {
        String sql = "SELECT * FROM tb_estudante WHERE email = ? AND senha = ?";

        try {
            PreparedStatement ps = ConnectionDB.connectionDB().prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Estudante estudante = new Estudante();

                estudante.setEmail(rs.getString(email));
                estudante.setSenha(rs.getString(senha));

                System.out.println(estudante);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
