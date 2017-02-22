package layout.AdaptersListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import exemplo.com.bilhetagemtopicos.R;

public class AdapterListView extends BaseAdapter
{
    private LayoutInflater mInflater;
    private ArrayList<ItemListView> itens;
    private int resource;
    private int idTextViewNome, idTextViewQtd, idTextViewFormaPgto, idTextViewData;

    /**
     * Construtor se quiser usar o item_list padrão para imagem e texto
     * @param context
     * @param itens
     */
    public AdapterListView(Context context, ArrayList<ItemListView> itens)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        this.resource = R.layout.item_list; //layout padrão para os itens
        this.idTextViewNome = R.id.txv_nome;
        this.idTextViewQtd = R.id.txv_qtde;
        this.idTextViewFormaPgto = R.id.txv_forma_pgto;
        this.idTextViewData = R.id.txv_data;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Construtor se quiser usar um item_list personalizado para imagem e texto
     * @param context
     * @param itens
     * @param resource
     */
    public AdapterListView(Context context, ArrayList<ItemListView> itens, int resource)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        this.resource = resource; //layout padrão para os itens
        this.idTextViewNome = R.id.txv_nome;
        this.idTextViewQtd = R.id.txv_qtde;
        this.idTextViewFormaPgto = R.id.txv_forma_pgto;
        this.idTextViewData = R.id.txv_data;
        //responsavel por pegar o Layout do item.
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Construtor se quiser usar item_list e os ids da textView e ImageView forem diferentes do padrão
     * @param context
     * @param itens
     * @param resource
     * @param idTextViewNome
     * @param idTextViewQtd
     * @param idTextViewFormaPgto
     * @param idTextViewData
     */
    public AdapterListView(Context context, ArrayList<ItemListView> itens, int resource, int idTextViewNome, int idTextViewQtd,
                           int idTextViewFormaPgto, int idTextViewData)
    {
        //Itens que preencheram o listview
        this.itens = itens;
        this.resource = resource; //layout padrão para os itens
        this.idTextViewNome = idTextViewNome;
        this.idTextViewQtd = idTextViewQtd;
        this.idTextViewFormaPgto = idTextViewFormaPgto;
        this.idTextViewData = idTextViewData;
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
    public ItemListView getItem(int position)
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
        ItemListView item = itens.get(position);
        //infla o layout para podermos preencher os dados

        view = mInflater.inflate(resource, null);

        //através do layout pego pelo LayoutInflater, pegamos cada id relacionado
        //ao item e definimos as informações.
        ((TextView) view.findViewById(idTextViewNome)).setText(item.getNome());
        ((TextView) view.findViewById(idTextViewQtd)).setText(""+item.getQtde());
        ((TextView) view.findViewById(idTextViewFormaPgto)).setText(item.getFormaPagamento());
        ((TextView) view.findViewById(idTextViewData)).setText(item.getData());

        return view;
    }
}