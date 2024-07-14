package org.example;
// import scanner
import java.util.Scanner;
// import regex
import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class Cliente {

    //nome,cpf,email,endereço,cep
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;

    public Cliente(String nome, String cpf, String email, String endereco, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // Recebe os dados no console e retorna o objeto cliente
    public static Cliente createCliente() {
        // cpf must match the pattern 000.000.000-00
        Pattern pattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o cpf do cliente: ");
        String cpf = scanner.nextLine();
        matcher = pattern.matcher(cpf);
        while (!matcher.matches()) {
            System.out.println("CPF inválido, digite novamente: ");
            cpf = scanner.nextLine();
            matcher = pattern.matcher(cpf);
        }
        System.out.println("Digite o email do cliente: ");
        // email must match the pattern email@domain
        pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        String email = scanner.nextLine();
        matcher = pattern.matcher(email);
        while (!matcher.matches()) {
            System.out.println("Email inválido, digite novamente: ");
            email = scanner.nextLine();
            matcher = pattern.matcher(email);
        }
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o cep do cliente: ");
        // cep must match the pattern 00000-000
        pattern = Pattern.compile("\\d{5}-\\d{3}");
        String cep = scanner.nextLine();
        matcher = pattern.matcher(cep);
        while (!matcher.matches()) {
            System.out.println("CEP inválido, digite novamente: ");
            cep = scanner.nextLine();
            matcher = pattern.matcher(cep);
        }
        return new Cliente(nome, cpf, email, endereco, cep);
    }


}
