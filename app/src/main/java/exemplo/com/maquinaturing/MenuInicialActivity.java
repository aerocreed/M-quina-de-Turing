package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import exemplo.com.maquinaturing.AdaptersListView.AdapterListViewApenasTexto;
import exemplo.com.maquinaturing.AdaptersListView.ItemListViewApenasTexto;

public class MenuInicialActivity extends Activity
{

    private Button btn_cadastrar_mt;
    private Button btn_listar_mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_menu_inicial);

        btn_cadastrar_mt = (Button)findViewById(R.id.btn_cadastrar_mt);
        btn_listar_mt = (Button)findViewById(R.id.btn_listar_mt);

        btn_cadastrar_mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CadastroMaquinaTuringActivity.class));
            }
        });

        btn_listar_mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ListMaquinaTuringActivity.class));
            }
        });
    }

}
