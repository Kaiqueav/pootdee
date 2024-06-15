package com.example.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DbSetup {
public static void criarTabelas() {
        try (Connection conn = DataBaseConn.getConnection(); Statement stmt = conn.createStatement()) {

            String sqlCreateAutorTable = "CREATE TABLE IF NOT EXISTS Autor ("
                + "cpf VARCHAR(11) PRIMARY KEY, "
                + "nome VARCHAR(100) NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "curso_id VARCHAR(50) NOT NULL"
                + ")";

            String sqlCreateOrientadorTable = "CREATE TABLE IF NOT EXISTS Orientador ("
                + "cpf VARCHAR(11) PRIMARY KEY, "
                + "nome VARCHAR(100) NOT NULL, "
                + "email VARCHAR(100) NOT NULL, "
                + "titulacao VARCHAR(100) NOT NULL"
                + ")";

            String sqlCreateCursoTable = "CREATE TABLE IF NOT EXISTS Curso ("
                + "id VARCHAR(50) PRIMARY KEY, "
                + "nome VARCHAR(100) NOT NULL, "
                + "descricao VARCHAR(255) NOT NULL"
                + ")";

            String sqlCreateTrabalhoAcademicoTable = "CREATE TABLE IF NOT EXISTS TrabalhoAcademico ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "titulo VARCHAR(255) NOT NULL, "
                + "descricao TEXT NOT NULL, "
                + "resumo TEXT NOT NULL, "
                + "data_entrega DATE NOT NULL, "
                + "orientador_cpf VARCHAR(11), "
                + "FOREIGN KEY (orientador_cpf) REFERENCES Orientador(cpf)"
                + ")";

            String sqlCreateAutorTrabalhoTable = "CREATE TABLE IF NOT EXISTS AutorTrabalho ("
                + "trabalho_id INT, "
                + "autor_cpf VARCHAR(11), "
                + "PRIMARY KEY (trabalho_id, autor_cpf), "
                + "FOREIGN KEY (trabalho_id) REFERENCES TrabalhoAcademico(id), "
                + "FOREIGN KEY (autor_cpf) REFERENCES Autor(cpf)"
                + ")";

            String sqlCreatePalavrasChaveTable = "CREATE TABLE IF NOT EXISTS PalavrasChave ("
                + "trabalho_id INT, "
                + "palavra_chave VARCHAR(50), "
                + "PRIMARY KEY (trabalho_id, palavra_chave), "
                + "FOREIGN KEY (trabalho_id) REFERENCES TrabalhoAcademico(id)"
                + ")";

            stmt.execute(sqlCreateAutorTable);
            stmt.execute(sqlCreateOrientadorTable);
            stmt.execute(sqlCreateCursoTable);
            stmt.execute(sqlCreateTrabalhoAcademicoTable);
            stmt.execute(sqlCreateAutorTrabalhoTable);
            stmt.execute(sqlCreatePalavrasChaveTable);

            System.out.println("Tabelas criadas com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
