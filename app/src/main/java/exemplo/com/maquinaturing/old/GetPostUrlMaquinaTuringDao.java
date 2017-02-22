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
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import exemplo.com.maquinaturing.FuncaoTransicao;
import exemplo.com.maquinaturing.MaquinaTuring;
import exemplo.com.maquinaturing.MaquinaTuringDao;

public class GetPostUrlMaquinaTuringDao implements MaquinaTuringDao {
    private static final String URLSAVE = "http://maquinaturinglingformais.comuf.com/createMaquinaTuring.php";
    private static final String URLLISTA = "http://maquinaturinglingformais.comuf.com/listarMaquinasTuring.php";
    private static final String URLBUSCA = "http://maquinaturinglingformais.comuf.com/findMaquinaTuring.php";
    public static final HttpClient client = new DefaultHttpClient();
    @Override
    public void save(MaquinaTuring maquinaTuring) {
        String result = null;
        try {
            List<NameValuePair> postData = new ArrayList<NameValuePair>(2);
            postData.add(new BasicNameValuePair("nome", maquinaTuring.getNome()));
            //postData.add(new BasicNameValuePair("qtd_est", maquinaTuring.getConjEstados().size()+""));
            postData.add(new BasicNameValuePair("est_ini", maquinaTuring.getEstadoAtual()));
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
        //return result;
    }

    @Override
    public void delete(MaquinaTuring maquinaTuring) {

    }

    @Override
    public List list() {
        ArrayList<String> nomes = null;
        try {
            JSONArray jsonArray = new JSONArray(GetPostUrl.GETURL(URLLISTA));
            nomes = new ArrayList<>(jsonArray.length());
            for(int i=0; i<jsonArray.length(); i++){
                nomes.add(jsonArray.getString(i));
            }
        } catch (JSONException je){
            Log.i("ERRO JSON", je.getMessage());
        }
        return nomes;
    }

    @Override
    public MaquinaTuring find(String nome) {
        Log.i("página", GetPostUrl.GET(URLBUSCA+"?nome="+nome));
        MaquinaTuring mt = null;
        try {
            JSONObject jsonObject = new JSONObject(GetPostUrl.GET(URLBUSCA + "?nome=" + nome));
            String nomeMaq = jsonObject.getString("nome");
            int qtdEstados = jsonObject.getInt(("qtdEstados"));
            List<String> conjEstados = new ArrayList<String>();
            for(int i=0; i<qtdEstados; i++){
                conjEstados.add(i+"");
            }
            String estadoInicial = jsonObject.getString("EstadoIni");
            List<FuncaoTransicao> funcoesT = new ArrayList<FuncaoTransicao>();
            JSONArray funcoesTJSON = jsonObject.getJSONArray("funcoesTransicao");
            mt = new MaquinaTuring(nomeMaq, /*conjEstados,*/ estadoInicial);
            for(int i = 0 ; i < funcoesTJSON.length() ; i++){
                String estAtual = funcoesTJSON.getJSONObject(i).getString("estAtual");
                String simbAtual = funcoesTJSON.getJSONObject(i).getString("simbAtual");
                String novoEstado = funcoesTJSON.getJSONObject(i).getString("novoEstado");
                String novoSimbolo = funcoesTJSON.getJSONObject(i).getString("novoSimbolo");
                String movCabecote = funcoesTJSON.getJSONObject(i).getString("movCabecote");
                FuncaoTransicao ft = new FuncaoTransicao(nomeMaq, estAtual, simbAtual, novoEstado, novoSimbolo, movCabecote);
                funcoesT.add(ft);
            }
            mt.setFuncoesTransicao(funcoesT);
        } catch (JSONException je){
            Log.i("ERRO JSON", je.getMessage());
        }

        return mt;
    }
}
