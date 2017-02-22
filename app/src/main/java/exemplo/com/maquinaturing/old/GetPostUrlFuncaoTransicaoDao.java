package exemplo.com.maquinaturing.old;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import exemplo.com.maquinaturing.FuncaoTransicao;
import exemplo.com.maquinaturing.FuncaoTransicaoDao;
import exemplo.com.maquinaturing.MaquinaTuring;

public class GetPostUrlFuncaoTransicaoDao implements FuncaoTransicaoDao {
    private static final String URLSAVE = "http://maquinaturinglingformais.comuf.com/createFuncaoTransicao.php";
    private static final String URLLISTA = "http://maquinaturinglingformais.comuf.com/listarFuncoesTransicao.php";
    public static final HttpClient client = new DefaultHttpClient();
    @Override
    public String save(FuncaoTransicao funcaoTransicao) {
        String result = null;
        try {
            List<NameValuePair> postData = new ArrayList<NameValuePair>(2);
            postData.add(new BasicNameValuePair("nome", funcaoTransicao.getNomeMaq()));
            postData.add(new BasicNameValuePair("est_atual", funcaoTransicao.getEstadoAtual()));
            postData.add(new BasicNameValuePair("simb_atual", funcaoTransicao.getSimboloASerLido()));
            postData.add(new BasicNameValuePair("novo_est", funcaoTransicao.getNovoEstado()));
            postData.add(new BasicNameValuePair("novo_simb", funcaoTransicao.getNovoSimbolo()));
            postData.add(new BasicNameValuePair("mov_cab", funcaoTransicao.getMovimento()));
            //...
            HttpPost httppost = new HttpPost(URLSAVE);
            httppost.setEntity(new UrlEncodedFormEntity(postData));
            HttpResponse response = client.execute(httppost);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(responseEntity.getContent(),
                                "UTF-8"));
                result = reader.readLine().toString();
            } else {

            }
        } catch (IllegalArgumentException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(FuncaoTransicao empresa) {

    }

    @Override
    public List list(MaquinaTuring maquinaTuring) {
        ArrayList<FuncaoTransicao> funcoes = null;
        FuncaoTransicao func = null;
        try {
            JSONArray jsonArray = new JSONArray(GetPostUrl.GETURL(URLLISTA+"?nome="+maquinaTuring.getNome()));
            funcoes = new ArrayList<>(jsonArray.length());
            for(int i=0; i<jsonArray.length(); i++){
                JSONArray funcTransicao = jsonArray.getJSONArray(i);
                String estAtual, simbAtual, estNovo, simbNovo, mov;
                estAtual = funcTransicao.getString(0);
                simbAtual = funcTransicao.getString(1);
                estNovo = funcTransicao.getString(2);
                simbNovo = funcTransicao.getString(3);
                mov = funcTransicao.getString(4);
                func = new FuncaoTransicao(maquinaTuring.getNome(), estAtual, simbAtual, estNovo, simbNovo, mov);
                funcoes.add(func);
            }
        } catch (JSONException je){
            Log.i("ERRO JSON", je.getMessage());
        }
        return funcoes;
    }

    @Override
    public FuncaoTransicao find(String estadoAtual, String simbolo) {
        return null;
    }
}
