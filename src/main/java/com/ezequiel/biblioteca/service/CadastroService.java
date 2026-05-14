package com.ezequiel.biblioteca.service;

import com.ezequiel.biblioteca.connection.ConnectionDB;
import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.repository.CadastroInterface;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroService implements CadastroInterface {
    @Override
    public void inserir(Estudante estudante) {
        String sql = "INSERT INTO tb_estudante(nome, sexo, data_nascimento, email, senha) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = ConnectionDB.connectionDB().prepareStatement(sql);
            ps.setString(1, estudante.getNome());
            ps.setString(2, estudante.getSexo());
            ps.setDate(3, Date.valueOf(estudante.getDataNascimento()));
            ps.setString(4, estudante.getEmail());
            ps.setString(5, estudante.getSenha());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
