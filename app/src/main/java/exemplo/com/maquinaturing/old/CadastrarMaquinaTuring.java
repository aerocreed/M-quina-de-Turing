package exemplo.com.maquinaturing.old;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import exemplo.com.maquinaturing.MaquinaTuring;

public class CadastrarMaquinaTuring extends AsyncTask<String, Integer, String> {
    private MaquinaTuring maquinaTuring;

    public CadastrarMaquinaTuring(MaquinaTuring maquinaTuring){
        this.maquinaTuring = maquinaTuring;
    }

    @Override
    protected String doInBackground(String... params) {
        /*MaquinaTuringDao maquinaTuringDao = Factory.createMaquinaTuringDao();
        return maquinaTuringDao.save(maquinaTuring);*/
        return "";
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