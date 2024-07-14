package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import arraylist
import java.util.ArrayList;
public class dbSocket {
    // connection to mysql database
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientela", "root", "");
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // metodo para fechar a conexao
    public static void close(Connection conn) {
        try {
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // metodo para inserir cliente
    public static void insert(Cliente cliente) {
        Connection conn = connect();
        try {
            String sql = "INSERT INTO clientes (nome, cpf, email, endereco, cep) VALUES (?, ?, ?, ?, ?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCep());
            stmt.execute();
            System.out.println("Cliente inserido com sucesso");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }
    public static void listar() {
        Connection conn = connect();
        try {
            String sql = "SELECT * FROM clientes";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Endereco: " + rs.getString("endereco"));
                System.out.println("CEP: " + rs.getString("cep"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }

    public static ArrayList<Cliente> listagemClientes() {
        Connection conn = connect();
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM clientes";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("endereco"), rs.getString("cep"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
        return clientes;
    }
    public static void atualizar(Cliente cliente) {
        Connection conn = connect();
        try {
            String sql = "UPDATE clientes SET nome = ?, email = ?, endereco = ?, cep = ? WHERE cpf = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCep());
            stmt.setString(5, cliente.getCpf());
            stmt.execute();
            System.out.println("Cliente atualizado com sucesso");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }
    // buscar por cpf
    public static void buscarCPF(String cpf) {
        Connection conn = connect();
        try {
            String sql = "SELECT * FROM clientes WHERE cpf = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Endereco: " + rs.getString("endereco"));
                System.out.println("CEP: " + rs.getString("cep"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }
    public static void deletar(String cpf) {
        Connection conn = connect();
        try {
            String sql = "DELETE FROM clientes WHERE cpf = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
            System.out.println("Cliente deletado com sucesso");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close(conn);
        }
    }
}
