package exemplo.com.maquinaturing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class SqliteMaquinaTuringDao implements MaquinaTuringDao{
    private SQLiteDatabase db;

    public SqliteMaquinaTuringDao(Context context){
        BDCore bdCore = new BDCore(context);
        db = bdCore.getWritableDatabase();
    }

    @Override
    public void save(MaquinaTuring maquinaTuring) {
        ContentValues values = new ContentValues();
        values.put("nome", maquinaTuring.getNome());
        db.insert("maquinas_turing", null, values);
    }

    @Override
    public void delete(MaquinaTuring maquinaTuring) {
        ContentValues values = new ContentValues();
        values.put("nome", maquinaTuring.getNome());
        db.delete("maquinas_turing", "nome = " + maquinaTuring.getNome(), null);
    }

    @Override
    public List<MaquinaTuring> list() {
        List<MaquinaTuring> maquinasTuring = new ArrayList<MaquinaTuring>();
        String[] colunas = new String[]{"nome"};

        Cursor cursor = db.query("maquinas_turing", colunas, null, null, null, null, "nome ASC");
        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                MaquinaTuring mt = new MaquinaTuring();
                mt.setNome(cursor.getString(0));
                maquinasTuring.add(mt);
            }while(cursor.moveToNext());
        }
        return maquinasTuring;
    }

    @Override
    public MaquinaTuring find(String nome) {
        String[] colunas = new String[]{"nome"};
        String[] colunasFuncao = new String[]{"nomemaq", "estado_lido", "simbolo_lido", "estado_novo", "simbolo_novo", "movimento"};

        Cursor cursor = db.query("maquinas_turing", colunas, "nome=?", new String[]{nome}, null, null, null, null);
        cursor.moveToFirst();
        MaquinaTuring mt = new MaquinaTuring();
        mt.setNome(cursor.getString(0));

        List<FuncaoTransicao> funcoesTransicao = new ArrayList<FuncaoTransicao>();
        Cursor cursorFuncoes = db.query("funcoes_transicao", colunasFuncao, "nomemaq=?", new String[]{nome}, null, null, null, null);
        if(cursorFuncoes.getCount() > 0){
            cursorFuncoes.moveToFirst();
            do{
                FuncaoTransicao funcaoTransicao = new FuncaoTransicao(cursorFuncoes.getString(0), cursorFuncoes.getString(1),
                                                                      cursorFuncoes.getString(2), cursorFuncoes.getString(3),
                                                                      cursorFuncoes.getString(4), cursorFuncoes.getString(5));
                funcoesTransicao.add(funcaoTransicao);
            }while(cursorFuncoes.moveToNext());
        }
        mt.setFuncoesTransicao(funcoesTransicao);
        return mt;
    }

}
