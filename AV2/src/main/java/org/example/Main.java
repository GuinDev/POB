package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//arraylist
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                inserirCliente();
            } else if (opcao == 2) {
                listarClientes();
            } else if (opcao == 3) {
                atualizarCliente();
            } else if (opcao == 4) {
                deletarCliente();
            } else if (opcao == 5) {
                importCliente();
            }
            else if (opcao == 6) {
                break;
            }
        }
    }
    public static void menu() {
        System.out.println("1 - Inserir cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Atualizar cliente");
        System.out.println("4 - Deletar cliente");
        System.out.println("5 - Importar do txt");
        System.out.println("6 - Sair");
    }
    public static void inserirCliente() {
        Cliente cliente = Cliente.createCliente();
        dbSocket.insert(cliente);
    }
    public static void listarClientes() {
        ArrayList<Cliente> listagemClientes = dbSocket.listagemClientes();
        for (Cliente cliente : listagemClientes) {
            System.out.println("===================================");
            System.out.println("Posição: " + listagemClientes.indexOf(cliente));
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Endereco: " + cliente.getEndereco());
            System.out.println("CEP: " + cliente.getCep());
            System.out.println("===================================");
        }
    }
    public static void atualizarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a posição do cliente que deseja atualizar: ");
        int posicao = scanner.nextInt();
        ArrayList<Cliente> listagemClientes = dbSocket.listagemClientes();
        Cliente cliente = listagemClientes.get(posicao);
        System.out.println("Digite o novo nome do cliente: ");
        String nome = scanner.next();
        cliente.setNome(nome);
        System.out.println("Digite o novo cpf do cliente: ");
        String cpf = scanner.next();
        cliente.setCpf(cpf);
        System.out.println("Digite o novo email do cliente: ");
        String email = scanner.next();
        cliente.setEmail(email);
        System.out.println("Digite o novo endereco do cliente: ");
        String endereco = scanner.next();
        cliente.setEndereco(endereco);
        System.out.println("Digite o novo cep do cliente: ");
        String cep = scanner.next();
        cliente.setCep(cep);
        dbSocket.atualizar(cliente);
    }
    public static void deletarCliente() {
        Scanner scanner = new Scanner(System.in);
        // exibe a lista de clientes
        listarClientes();
        System.out.println("Digite a posição do cliente que deseja deletar: ");
        int posicao = scanner.nextInt();
        ArrayList<Cliente> listagemClientes = dbSocket.listagemClientes();
        Cliente cliente = listagemClientes.get(posicao);
        dbSocket.deletar(cliente.getCpf());
    }
    public  static  void importCliente() {
        try {
            //get existing file
            File file = new File("./clientes.txt");
            //se não existir, cancela
            if (!file.exists()) {
                System.out.println("Arquivo não encontrado");
                return;
            }
            //cria um scanner para ler o arquivo
            Scanner scanner = new Scanner(file);
            //enquanto houver linhas no arquivo
            while (scanner.hasNextLine()) {
                //lê a linha
                String line = scanner.nextLine();
                //se a linha começar com nome, pula para a próxima linha
                if (line.startsWith("nome")) {
                    continue;
                }
                //separa os campos
                String[] fields = line.split(";");
                //cria um cliente com os campos
                Cliente cliente = new Cliente(fields[0], fields[1], fields[2], fields[3], fields[4]);
                //insere o cliente no banco
                dbSocket.insert(cliente);
            }
            //fecha o scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}