package exemplo.com.maquinaturing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BDCore extends SQLiteOpenHelper {
    private static final String NOME_DB = "maquina_turing";
    private static final int VERSAO_DB = 2;

    public BDCore(Context context){
        super(context, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table maquinas_turing(_id integer primary key autoincrement, nome text not null);");

        db.execSQL("create table funcoes_transicao(_id integer primary key autoincrement, nomemaq text not null," +
                   "estado_lido text not null, simbolo_lido text not null, estado_novo text not null, " +
                   "simbolo_novo text not null, movimento text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table maquinas_turing;");
        onCreate(db);
    }
}
