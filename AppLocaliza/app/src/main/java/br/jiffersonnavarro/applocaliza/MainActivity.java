package br.jiffersonnavarro.applocaliza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText etCidade, etLogradouro;
    private Button btnBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuscar=findViewById(R.id.btnBuscar);
        etCidade=findViewById(R.id.etCidade);
        etLogradouro=findViewById(R.id.etLogradouro);
        spinner=findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.UF)));
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vou chamar a API e mandar par a lista
                chamaAPI();
            }
        });
    }

    private void chamaAPI() {
        AcessaWsTask task=new AcessaWsTask();
        String sjson="";
        try
        {
            sjson = task.execute("viacep.com.br/ws/"+spinner.getSelectedItem().toString()+"/"+etCidade.getText().toString()+"/" +etLogradouro.getText().toString()+"/json/").get();
            try
            {
                JSONObject json = new JSONObject(sjson);
                sjson="Cidade: "+json.getString("localidade");
                sjson+="-"+json.getString("uf");
                sjson+="\n"+json.getString("logradouro");
            }
            catch(Exception e)
            {sjson="Endereço não encontrado ou inexistente";}
        }
        catch(Exception e)
        {sjson="Erro ao conectar-se com o Servidor.";}

        //Mandar para a outra tela.
        Intent intent=new Intent(this,ListaActivity.class);
        //Aqui tem que mandar o json
        startActivity(intent);
    }
}
