package exemplo.com.maquinaturing.old;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import exemplo.com.maquinaturing.Factory;
import exemplo.com.maquinaturing.FuncaoTransicao;
import exemplo.com.maquinaturing.FuncaoTransicaoDao;

public class CRUDFuncoesTransicao extends AsyncTask<String, Integer, List<FuncaoTransicao>> {
    private FuncaoTransicao funcaoTransicao;

    @Override
    protected List<FuncaoTransicao> doInBackground(String... params) {
        String operacao = params[0];
        FuncaoTransicaoDao funcaoTransicaoDao = Factory.createFuncaoTransicaoDao();
        if(operacao.toUpperCase().equals("LIST")) {
            String nomeMaq = params[1];
            //MaquinaTuringDao maquinaTuringDao = Factory.createMaquinaTuringDao();
            //MaquinaTuring maqTuring = maquinaTuringDao.find(nomeMaq);
            //return funcaoTransicaoDao.list(maqTuring);
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