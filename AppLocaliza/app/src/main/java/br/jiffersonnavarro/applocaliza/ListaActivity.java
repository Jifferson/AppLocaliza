package br.jiffersonnavarro.applocaliza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListaActivity extends AppCompatActivity {
private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lista=findViewById(R.id.lista);
        carregarListView();
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Aqui eu vou chamar outra API e abrir o maps
                abrirMapa();
            }
        });
    }

    private void abrirMapa() {
        //Aqui eu abro o mapa e nele vou marcar a localização
        Intent intent=new Intent(this,MapaActivity.class);
        intent.putExtra("latitude",1);
        intent.putExtra("longitude",1);
        //Aqui tem que mandar o json
        startActivity(intent);
    }

    private void carregarListView() {
        ItemAdapter adapter;
        //Aqui eu pego o json e coloco na lista
        adapter=new ItemAdapter(this,R.layout.item_lista,);
        lista.setAdapter(adapter);
    }
}
