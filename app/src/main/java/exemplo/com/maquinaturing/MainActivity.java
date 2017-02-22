package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import exemplo.com.maquinaturing.AdaptersListView.AdapterListViewApenasTexto;
import exemplo.com.maquinaturing.AdaptersListView.ItemListViewApenasTexto;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener
{

    private ListView listView;
    private EditText funcaoTransicao;
    private AdapterListViewApenasTexto adapterListView;
    private ArrayList<ItemListViewApenasTexto> itens;
    private int resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_main);
        resource = R.layout.item_list_apenas_texto;
        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list);
        funcaoTransicao = (EditText) findViewById(R.id.txtv_func_transicao);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);


        String nome[] = {"nome1", "nome2", "nome3"};
        Class<?> classe[] = {MainActivity.class, MainActivity.class, MainActivity.class};

        createListView(nome, classe);

    }

    private void createListView(String[] arrNome, Class<?>[] classe)
    {
        itens = new ArrayList<ItemListViewApenasTexto>();

        ItemListViewApenasTexto itemList[] = new ItemListViewApenasTexto[arrNome.length];
        for(int i=0; i<arrNome.length; i++){
            itemList[i] = new ItemListViewApenasTexto(arrNome[i], classe[i]);
            itens.add(itemList[i]);
        }
        adapterListView = new AdapterListViewApenasTexto(this, itens);

        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        //Pega o item que foi selecionado.
        ItemListViewApenasTexto item = adapterListView.getItem(arg2);
        startActivity(new Intent(arg1.getContext(), item.getCls()));
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
