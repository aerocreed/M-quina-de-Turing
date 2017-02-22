package exemplo.com.maquinaturing.old;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import exemplo.com.maquinaturing.Factory;
import exemplo.com.maquinaturing.FuncaoTransicao;
import exemplo.com.maquinaturing.FuncaoTransicaoDao;

public class AdicionarFuncaoTransicao extends AsyncTask<String, Integer, String> {
    private FuncaoTransicao funcaoTransicao;

    public AdicionarFuncaoTransicao(FuncaoTransicao funcaoTransicao){
        this.funcaoTransicao = funcaoTransicao;
    }

    @Override
    protected String doInBackground(String... params) {
        FuncaoTransicaoDao funcaoTransicaoDao = Factory.createFuncaoTransicaoDao();
        return funcaoTransicaoDao.save(funcaoTransicao);
    }

    @Override
    protected void onPostExecute(String result) {
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

    }
}