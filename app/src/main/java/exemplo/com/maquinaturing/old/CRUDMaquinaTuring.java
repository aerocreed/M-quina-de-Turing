package exemplo.com.maquinaturing.old;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import exemplo.com.maquinaturing.MaquinaTuring;

public class CRUDMaquinaTuring extends AsyncTask<String, Integer, List<MaquinaTuring>> {
    private MaquinaTuring maquinaTuring;

    @Override
    protected List<MaquinaTuring> doInBackground(String... params) {
        String operacao = params[0];
        //MaquinaTuringDao maquinaTuringDao = Factory.createMaquinaTuringDao();
        if(operacao.toUpperCase().equals("FIND")) {
            String nomeMaq = params[1];
            //MaquinaTuring maqTuring = maquinaTuringDao.find(nomeMaq);
            List<MaquinaTuring> mts = new ArrayList<MaquinaTuring>();
            //mts.add(maqTuring);
            return mts;
        }
        else if(operacao.toUpperCase().equals("SAVE")){
            //...
        }
        return null;
    }

    //@Override
    protected void onPostExecute(String result) {
        String sucesso = null;
        try {
            JSONObject jsonObject = new JSONObject(result);
            Log.i("ok", jsonObject.toString());
        } catch (JSONException je) {
            Log.i("erro", je.getMessage());
        }
        Log.i("result", result);
    }

    @Override
    protected void onProgressUpdate(Integer... values)
    {
        /*
        progressBar.setProgress(values[0]);
        status.setText("Autenticando... " + values[0]+" % ");
        if(values[0] == 100){
            status.setText("Entrando... " + values[0]+" % " + client.getConnectionManager());
        }
        */
    }
}