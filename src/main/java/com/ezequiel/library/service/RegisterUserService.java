package com.ezequiel.library.service;

import com.ezequiel.library.connection.ConnectionDB;
import com.ezequiel.library.model.User;
import com.ezequiel.library.repository.RegisterInterface;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserService implements RegisterInterface {
    @Override
    public void inserir(User user) {
        String sql = "INSERT INTO tb_estudante(nome, sexo, data_nascimento, email, senha) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = ConnectionDB.connectionDB().prepareStatement(sql);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getSexo());
            ps.setDate(3, Date.valueOf(user.getDataNascimento()));
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getSenha());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
