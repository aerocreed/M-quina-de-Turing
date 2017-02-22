package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import exemplo.com.maquinaturing.old.CadastrarMaquinaTuring;

public class EditMaquinaTuringActivity extends Activity
{
    private EditText edt_nome, edt_estado_ini;
    private Button btn_editar;
    private Button btn_add_func_trans;
    private MaquinaTuring maquinaTuring;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_maquina_turing);

        edt_nome = (EditText) findViewById(R.id.edt_nome_maq_tur);
        edt_estado_ini = (EditText) findViewById(R.id.edt_estado_inicial);

        btn_editar = (Button) findViewById(R.id.btn_editar_maq_tur);
        btn_add_func_trans = (Button) findViewById(R.id.btn_add_func_trans_maq_tur);

        //Recebendo o nome clicado na lista
        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        final String nomeMaq = parametros.getString("nomeMaq");

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> conjEstados = new ArrayList<String>();
                maquinaTuring = new MaquinaTuring(edt_nome.getText().toString(),
                                                  edt_estado_ini.getText().toString());
                //Cadastra
                CadastrarMaquinaTuring cadastrarMaquinaTuring = new CadastrarMaquinaTuring(maquinaTuring);
                cadastrarMaquinaTuring.execute();
            }
        });

        btn_add_func_trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), AddFuncaoTransicaoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nomeMaq", nomeMaq);

                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });
    }

}
