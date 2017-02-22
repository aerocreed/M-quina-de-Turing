package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import exemplo.com.maquinaturing.AdaptersListView.AdapterListViewApenasTexto;
import exemplo.com.maquinaturing.AdaptersListView.ItemListViewApenasTexto;

public class ListMaquinaTuringActivity extends Activity implements AdapterView.OnItemClickListener
{

    private ListView listView;
    private AdapterListViewApenasTexto adapterListView;
    private ArrayList<ItemListViewApenasTexto> itens;
    private int resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.lista_maquina_turing);
        resource = R.layout.item_list_apenas_texto;
        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
        SqliteMaquinaTuringDao sqliteMaquinaTuringDao = new SqliteMaquinaTuringDao(this);
        List<MaquinaTuring> maquinasCadastradas = sqliteMaquinaTuringDao.list();

        Class<?> classe = MaquinaTuringActivity.class;

        createListView(maquinasCadastradas, classe);
    }

    private void createListView(List<MaquinaTuring> maquinas, Class<?> classe)
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListViewApenasTexto>();

        Log.i("tamanho", maquinas.size()+"");

        ItemListViewApenasTexto itemList[] = new ItemListViewApenasTexto[maquinas.size()];
        int i = 0;
        for(MaquinaTuring maquinaTuring : maquinas){
            itemList[i] = new ItemListViewApenasTexto(maquinaTuring.getNome(), classe);
            itens.add(itemList[i]);
            i++;
        }
        //Cria o adapter
        adapterListView = new AdapterListViewApenasTexto(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }


    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        //Pega o item que foi selecionado.
        ItemListViewApenasTexto item = adapterListView.getItem(arg2);

        //Passando para MaquinaTuringActivity
        Intent intent = new Intent(ListMaquinaTuringActivity.this, MenuMaquinaTuringActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("nomeMaq", item.getNome().toString());

        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
