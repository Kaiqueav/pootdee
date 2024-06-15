package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Orientador;

public class OrientadorDao {
public void inserir(Orientador orientador) {
        String sql = "INSERT INTO Orientador (cpf, nome, email, titulacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, orientador.getCpf());
            stmt.setString(2, orientador.getNome());
            stmt.setString(3, orientador.getEmail());
            stmt.setString(4, orientador.getTitulacao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Orientador orientador) {
        String sql = "UPDATE Orientador SET nome = ?, email = ?, titulacao = ? WHERE cpf = ?";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, orientador.getNome());
            stmt.setString(2, orientador.getEmail());
            stmt.setString(3, orientador.getTitulacao());
            stmt.setString(4, orientador.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(String cpf) {
        String sql = "DELETE FROM Orientador WHERE cpf = ?";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Orientador buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM Orientador WHERE cpf = ?";
        try (Connection conn = DataBaseConn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Orientador(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("titulacao")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Orientador> listar() {
        List<Orientador> orientadores = new ArrayList<>();
        String sql = "SELECT * FROM Orientador";
        try (Connection conn = DataBaseConn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orientadores.add(new Orientador(
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("titulacao")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orientadores;
    }
}
