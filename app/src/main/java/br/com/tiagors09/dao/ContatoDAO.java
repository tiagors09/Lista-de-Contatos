package br.com.tiagors09.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.model.Contato;

public class ContatoDAO {
    private  static ContatoDAO instance;
    private List<Contato> listaContatos;

    private ContatoDAO() {
        this.listaContatos = new ArrayList<Contato>();
    }

    public static  ContatoDAO getInstance() {
        if(instance == null) {
            instance = new ContatoDAO();
        }

        return instance;
    }

    public boolean create(Contato c) {
        return listaContatos.add(c);
    }

    public Contato read(int id) {
        return listaContatos.get(id);
    }

    public List<Contato> getAll() {
        return listaContatos;
    }

    public Contato update(int id, Contato c) {
        return listaContatos.set(id, c);
    }

    public Contato delete(int id) {
        return listaContatos.remove(id);
    }
}
