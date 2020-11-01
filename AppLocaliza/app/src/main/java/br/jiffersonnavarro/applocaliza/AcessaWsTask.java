package br.jiffersonnavarro.applocaliza;

import android.os.AsyncTask;

public class AcessaWsTask extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {
        return AcessaWS.consumir(strings[0]);
    }
}
