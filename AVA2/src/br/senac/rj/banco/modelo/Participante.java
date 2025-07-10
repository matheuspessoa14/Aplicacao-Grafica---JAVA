package br.senac.rj.banco.modelo;

public class Participante {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String tipoIngresso;

    public Participante() {}

    public Participante(int id, String nome, String email, String telefone, String tipoIngresso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipoIngresso = tipoIngresso;
    }

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

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(String tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }
}
