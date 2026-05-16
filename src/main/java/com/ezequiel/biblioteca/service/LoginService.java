package com.ezequiel.biblioteca.service;

import com.ezequiel.biblioteca.connection.ConnectionDB;
import com.ezequiel.biblioteca.controller.LoginController;
import com.ezequiel.biblioteca.model.Estudante;
import com.ezequiel.biblioteca.repository.LoginInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginService implements LoginInterface {

    @Override
    public List<Estudante> buscar() {
        List<Estudante> estudantes = new ArrayList<>();

        String  sql = "SELECT email, nome, senha from tb_estudante";
        try {

            ResultSet rs = null;

            PreparedStatement ps = ConnectionDB.connectionDB().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Estudante estudante = new Estudante();

                estudante.setEmail(rs.getString("email"));
                estudante.setNome(rs.getString("nome"));
                estudante.setSenha(rs.getString("senha"));

                estudantes.add(estudante);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estudantes;
    }
}
