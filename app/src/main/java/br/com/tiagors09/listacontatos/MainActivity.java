package br.com.tiagors09.listacontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import br.com.tiagors09.dao.ContatoDAO;
import br.com.tiagors09.model.Contato;

public class MainActivity extends AppCompatActivity {
    Button buttonAdicionar;
    EditText editTextNome, editTextTelefone, editTextEndereco;
    ListView listViewContatos;

    ContatoDAO contatoDAO = ContatoDAO.getInstance();
    ArrayAdapter<Contato> adapterContatos;

    int posSelection;
    Contato c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posSelection = -1;

        buttonAdicionar = findViewById(R.id.adicionarBtn);

        editTextNome = findViewById(R.id.editTextNome);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        listViewContatos = findViewById(R.id.listViewContatos);

        contatoDAO.create(new Contato("João", "123456789", "Rua A"));
        contatoDAO.create(new Contato("Maria", "987654321", "Rua B"));
        contatoDAO.create(new Contato("Carlos", "555555555", "Rua C"));

        adapterContatos = new ArrayAdapter<Contato>(
                this,
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,
                contatoDAO.getAll()
        );

        listViewContatos.setAdapter(adapterContatos);
        listViewContatos.setOnItemClickListener((adapterView, view, position, id) -> {
            buttonAdicionar.setEnabled(false);

            posSelection = position;

            c = contatoDAO.read(position);

            editTextNome.setText(c.getNome());
            editTextEndereco.setText(c.getEndereco());
            editTextTelefone.setText(c.getTelefone());
        });
    }

    private void limparCampos() {
        editTextNome.setText("");
        editTextEndereco.setText("");
        editTextTelefone.setText("");
    }

    public void adicionarContato(View v) {
        Contato c = new Contato(
                editTextNome.getText().toString(),
                editTextTelefone.getText().toString(),
                editTextEndereco.getText().toString()
        );

        limparCampos();

        contatoDAO.create(c);
    }

    public void editarContato(View v) {
        if (posSelection != -1) {
            contatoDAO.update(posSelection, c);
            posSelection = -1;
            limparCampos();
            buttonAdicionar.setEnabled(true);
        } else {
            Toast
                    .makeText(
                            getApplicationContext(),
                            "Selecione um contato válido",
                            Toast.LENGTH_SHORT
                    )
                    .show();
        }
    }

    public void removerContato(View v) {
        if(posSelection != -1) {
            contatoDAO.delete(posSelection);
            posSelection = -1;
            limparCampos();
            buttonAdicionar.setEnabled(true);
        } else {
            Toast
                    .makeText(
                            getApplicationContext(),
                            "Selecione um contato válido",
                            Toast.LENGTH_SHORT
                    )
                    .show();
        }
    }
}