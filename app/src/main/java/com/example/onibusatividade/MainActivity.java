package com.example.onibusatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewBusao;
    EditText editMarca;
    EditText editModelo;
    Spinner editTipo;
    EditText editOrigemDestino;
    EditText editAssentos;

    List<Busao> busoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMarca = findViewById(R.id.editTextMarcaBusao);
        editModelo = findViewById(R.id.editTextModeloBusao);
        editOrigemDestino = findViewById(R.id.editTextOrigemDestinoBusao);
        editTipo = findViewById(R.id.editTextTipoBusao);
        editAssentos = findViewById(R.id.editTextAssentosBusao);

        listViewBusao = findViewById(R.id.listViewBusoes);
        busoes = new ArrayList<>();

        listViewBusao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Busao busao = (Busao) adapterView.getItemAtPosition(i);

                String info;
                if (verificaAssentos(busao)) {
                    atualizarListViewBusao(busao);
                    info = "Passageiro Adicionado";
                } else {
                    info = "Busão Lotado!";
                }

                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        preencherListViewBusoes();
    }

    private boolean verificaAssentos(Busao b) {
        if (b.getAssentos_ocupados() >= b.getAssentos()) {
            return false;
        }
        return true;
    }

    private void atualizarListViewBusao(Busao b) {
        b.setAssentos_ocupados(b.getAssentos_ocupados()+1);
        preencherListViewBusoes();
    }

    public void novoBusao(View view) {

        Busao busao = new Busao();
        busao.setMarca(editMarca.getText().toString());
        busao.setModelo(editModelo.getText().toString());
        busao.setOrigem_destino(editOrigemDestino.getText().toString());
        busao.setTipo(editTipo.getSelectedItem().toString());
        busao.setAssentos(Integer.parseInt(editAssentos.getText().toString()));

        busoes.add(0,busao);

        editMarca.setText("");
        editModelo.setText("");
        editOrigemDestino.setText("");
        editAssentos.setText("");

        preencherListViewBusoes();
    }

    private void preencherListViewBusoes() {
        int layout_id = R.layout.busao_list_item;

        BusaoAdapter adapter = new BusaoAdapter(this, layout_id, busoes);
        listViewBusao.setAdapter(adapter);
    }
}