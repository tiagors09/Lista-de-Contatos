package br.com.tiagors09.model;

public class Contato {
    static int contadosIds = 0;

    int id;
    String nome;
    String telefone;
    String endereco;

    public Contato(String nome, String telefone, String endereco) {
        this.id = contadosIds;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public static int getContadosIds() {
        return contadosIds;
    }

    public static void setContadosIds(int contadosIds) {
        Contato.contadosIds = contadosIds;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome;
    }
}