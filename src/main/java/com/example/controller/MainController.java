package com.example.controller;

import java.util.List;
import java.util.Scanner;

import com.example.Autor;
import com.example.dao.AutorDao;
import com.example.dao.DbSetup;
import com.example.dao.OrientadorDao;
import com.example.model.Orientador;

public class MainController {

    private static Scanner scanner = new Scanner(System.in);
    private static AutorDao autorDAO = new AutorDao();
    private static OrientadorDao orientadorDAO = new OrientadorDao();

    public static void main(String[] args) {
        // Criar tabelas no banco de dados
        DbSetup.criarTabelas();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Gerenciar Autores");
            System.out.println("2. Gerenciar Orientadores");
            System.out.println("3. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    gerenciarAutores();
                    break;
                case 2:
                    gerenciarOrientadores();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void gerenciarAutores() {
        System.out.println("Gerenciar Autores:");
        System.out.println("1. Inserir Autor");
        System.out.println("2. Atualizar Autor");
        System.out.println("3. Remover Autor");
        System.out.println("4. Listar Autores");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                inserirAutor();
                break;
            case 2:
                atualizarAutor();
                break;
            case 3:
                removerAutor();
                break;
            case 4:
                listarAutores();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void inserirAutor() {
        System.out.println("Inserir Autor:");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Autor autor = new Autor(cpf, nome, email, curso);
        autorDAO.inserir(autor);
        System.out.println("Autor inserido com sucesso.");
    }

    private static void atualizarAutor() {
        System.out.println("Atualizar Autor:");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Autor autor = autorDAO.buscarPorCpf(cpf);
        if (autor == null) {
            System.out.println("Autor não encontrado.");
            return;
        }

        System.out.print("Nome: ");
        autor.setNome(scanner.nextLine());
        System.out.print("Email: ");
        autor.setEmail(scanner.nextLine());
        System.out.print("Curso: ");
        autor.setCurso(scanner.nextLine());

        autorDAO.atualizar(autor);
        System.out.println("Autor atualizado com sucesso.");
    }

    private static void removerAutor() {
        System.out.println("Remover Autor:");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        autorDAO.remover(cpf);
        System.out.println("Autor removido com sucesso.");
    }

    private static void listarAutores() {
        System.out.println("Lista de Autores:");
        List<Autor> autores = autorDAO.listar();
        for (Autor autor : autores) {
            System.out.println(autor.getCpf() + " - " + autor.getNome() + " - " + autor.getEmail() + " - " + autor.getCurso());
        }
    }

    private static void gerenciarOrientadores() {
        System.out.println("Gerenciar Orientadores:");
        System.out.println("1. Inserir Orientador");
        System.out.println("2. Atualizar Orientador");
        System.out.println("3. Remover Orientador");
        System.out.println("4. Listar Orientadores");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                inserirOrientador();
                break;
            case 2:
                atualizarOrientador();
                break;
            case 3:
                removerOrientador();
                break;
            case 4:
                listarOrientadores();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void inserirOrientador() {
        System.out.println("Inserir Orientador:");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Titulação: ");
        String titulacao = scanner.nextLine();

        Orientador orientador = new Orientador(cpf, nome, email, titulacao);
        orientadorDAO.inserir(orientador);
        System.out.println("Orientador inserido com sucesso.");
    }

    private static void atualizarOrientador() {
        System.out.println("Atualizar Orientador:");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Orientador orientador = orientadorDAO.buscarPorCpf(cpf);
        if (orientador == null) {
            System.out.println("Orientador não encontrado.");
            return;
        }

        System.out.print("Nome: ");
        orientador.setNome(scanner.nextLine());
        System.out.print("Email: ");
        orientador.setEmail(scanner.nextLine());
        System.out.print("Titulação: ");
        orientador.setTitulacao(scanner.nextLine());

        orientadorDAO.atualizar(orientador);
        System.out.println("Orientador atualizado com sucesso.");
    }

    private static void removerOrientador() {
        System.out.println("Remover Orientador:");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        orientadorDAO.remover(cpf);
        System.out.println("Orientador removido com sucesso.");
    }

    private static void listarOrientadores() {
        System.out.println("Lista de Orientadores:");
        List<Orientador> orientadores = orientadorDAO.listar();
        for (Orientador orientador : orientadores) {
            System.out.println(orientador.getCpf() + " - " + orientador.getNome() + " - " + orientador.getEmail() + " - " + orientador.getTitulacao());
        }
    }
}
