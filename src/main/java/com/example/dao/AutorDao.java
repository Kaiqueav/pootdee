package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Autor;

public class AutorDao {
 public void inserir(Autor autor) {
        String sql = "INSERT INTO Autor (cpf, nome, email, curso_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getCpf());
            stmt.setString(2, autor.getNome());
            stmt.setString(3, autor.getEmail());
            stmt.setString(4, autor.getCurso());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Autor autor) {
        String sql = "UPDATE Autor SET nome = ?, email = ?, curso_id = ? WHERE cpf = ?";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getEmail());
            stmt.setString(3, autor.getCurso());
            stmt.setString(4, autor.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(String cpf) {
        String sql = "DELETE FROM Autor WHERE cpf = ?";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Autor buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM Autor WHERE cpf = ?";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Autor(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("curso_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Autor> listar() {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        try (Connection conn = DataBaseConn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                autores.add(new Autor(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("curso_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autores;
    }
}
