package br.senac.rj.banco.modelo;

public class Organizador {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String empresa;

    public Organizador() {}

    public Organizador(int id, String nome, String email, String telefone, String empresa) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.empresa = empresa;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
