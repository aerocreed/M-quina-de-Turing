package layout.AdaptersListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import exemplo.com.bilhetagemtopicos.R;

public class AdapterListViewApenasTexto extends BaseAdapter
{
    private LayoutInflater mInflater;
    private ArrayList<ItemListViewApenasTexto> itens;
    private int resource;
    private int idTextViewNome;

    /**
     * Construtor se quiser usar o item_list padrão para imagem e texto
     * @param context
     * @param itens
     */
    public AdapterListViewApenasTexto(Context context, ArrayList<ItemListViewApenasTexto> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        this.resource = R.layout.item_list_apenas_texto; //layout padrão para os itens
        this.idTextViewNome = R.id.txv_nome;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Construtor se quiser usar um item_list personalizado para imagem e texto
     * @param context
     * @param itens
     * @param resource
     */
    public AdapterListViewApenasTexto(Context context, ArrayList<ItemListViewApenasTexto> itens, int resource)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        this.resource = resource; //layout padrão para os itens
        this.idTextViewNome = R.id.txv_nome;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }
 
    /**
     * Retorna a quantidade de itens
     *
     * @return
     */
    public int getCount()
    {
        return itens.size();
    }
 
    /**
     * Retorna o item de acordo com a posicao dele na tela.
     *
     * @param position
     * @return
     */
    public ItemListViewApenasTexto getItem(int position)
    {
        return itens.get(position);
    }
 
    /**
     * Sem implementação
     *
     * @param position
     * @return
     */
    public long getItemId(int position)
    {
        return position;
    }
 
    public View getView(int position, View view, ViewGroup parent)
    {
        //Pega o item de acordo com a posição.
        ItemListViewApenasTexto item = itens.get(position);
        //infla o layout para podermos preencher os dados

        view = mInflater.inflate(resource, null);

        //através do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(idTextViewNome)).setText(item.getNome());

        return view;
    }
}