package br.com.tiagors09.listacontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.tiagors09.model.Contato;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome, editTextTelefone, editTextEndereco;
    ListView listViewContatos;

    ArrayAdapter<Contato> adapterContatos;
    ArrayList<Contato> listaContatos;

    int posSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        listViewContatos = (ListView) findViewById(R.id.listViewContatos);

        listaContatos = new ArrayList<Contato>();

        adapterContatos = new ArrayAdapter<Contato>(
                this,
                android.R.layout.simple_list_item_activated_1,
                listaContatos
        );

        listViewContatos.setAdapter(adapterContatos);

        listViewContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                listViewContatos.setItemChecked(position, false);

                if (position == posSelection) {
                    posSelection = -1;
                } else  {
                    posSelection = position;
                }
            }
        });
    }

    public void adicionarContato(View v) {
        Contato c = new Contato(
                editTextNome.getText().toString(),
                editTextTelefone.getText().toString(),
                editTextEndereco.getText().toString()
        );

        listaContatos.add(c);
    }

    public void editarContato(View v) {

    }

    public void removerContato(View v) {

    }
}