package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CadastroMaquinaTuringActivity extends Activity
{
    private EditText edt_nome, edt_estado_ini;
    private Button btn_cadastrar;
    private MaquinaTuring maquinaTuring;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_maquina_turing);

        edt_nome = (EditText) findViewById(R.id.edt_nome_maq_tur);
        edt_estado_ini = (EditText) findViewById(R.id.edt_estado_inicial);

        btn_cadastrar = (Button) findViewById(R.id.btn_cadastrar_maq_tur);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> conjEstados = new ArrayList<String>();
                maquinaTuring = new MaquinaTuring(edt_nome.getText().toString(),
                                                  edt_estado_ini.getText().toString());
                //Cadastra
                SqliteMaquinaTuringDao sqliteMaquinaTuringDao = new SqliteMaquinaTuringDao(v.getContext());
                sqliteMaquinaTuringDao.save(maquinaTuring);
                Intent intent = new Intent(v.getContext(), ListMaquinaTuringActivity.class);
                startActivity(intent);
            }
        });
    }

}
