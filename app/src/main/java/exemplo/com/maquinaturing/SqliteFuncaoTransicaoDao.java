package exemplo.com.maquinaturing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SqliteFuncaoTransicaoDao implements FuncaoTransicaoDao{
    private SQLiteDatabase db;

    public SqliteFuncaoTransicaoDao(Context context){
        BDCore bdCore = new BDCore(context);
        db = bdCore.getWritableDatabase();
    }

    @Override
    public String save(FuncaoTransicao funcaoTransicao) {
        ContentValues values = new ContentValues();
        values.put("nomemaq", funcaoTransicao.getNomeMaq());
        values.put("estado_lido", funcaoTransicao.getEstadoAtual());
        values.put("simbolo_lido", funcaoTransicao.getSimboloASerLido());
        values.put("estado_novo", funcaoTransicao.getNovoEstado());
        values.put("simbolo_novo", funcaoTransicao.getNovoSimbolo());
        values.put("movimento", funcaoTransicao.getMovimento());
        db.insert("funcoes_transicao", null, values);
        return "Função inserida com sucesso";
    }

    @Override
    public void delete(FuncaoTransicao funcaoTransicao) {
        //
    }

    @Override
    public List<FuncaoTransicao> list(MaquinaTuring maquinaTuring) {
        List<FuncaoTransicao> funcoesTransicao = new ArrayList<FuncaoTransicao>();
        String[] colunas = new String[]{"nomemaq", "estado_lido", "simbolo_lido", "estado_novo", "simbolo_novo", "movimento"};

        Cursor cursor = db.query("funcoes_transicao", colunas, "nomemaq=?", new String[]{maquinaTuring.getNome()}, null, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                FuncaoTransicao funcaoTransicao = new FuncaoTransicao(cursor.getString(0), cursor.getString(1),
                                                                      cursor.getString(2), cursor.getString(3),
                                                                      cursor.getString(4), cursor.getString(5));
                funcoesTransicao.add(funcaoTransicao);
            }while(cursor.moveToNext());
        }
        return funcoesTransicao;
    }

    @Override
    public FuncaoTransicao find(String estadoAtual, String simbolo) {
        List<FuncaoTransicao> funcoesTransicao = new ArrayList<FuncaoTransicao>();
        String[] colunas = new String[]{"nomemaq", "estado_lido", "simbolo_lido", "estado_novo", "simbolo_novo", "movimento"};
        FuncaoTransicao funcaoTransicao = new FuncaoTransicao("", "", "", "", "", "");
        Cursor cursor = db.query("funcoes_transicao", colunas, "estado_lido=?", new String[]{estadoAtual}, null, null, null, null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                 funcaoTransicao = new FuncaoTransicao(cursor.getString(0), cursor.getString(1),
                                                       cursor.getString(2), cursor.getString(3),
                                                       cursor.getString(4), cursor.getString(5));
                funcoesTransicao.add(funcaoTransicao);
            }while(cursor.moveToNext());
        }
        return funcaoTransicao;
    }

}
