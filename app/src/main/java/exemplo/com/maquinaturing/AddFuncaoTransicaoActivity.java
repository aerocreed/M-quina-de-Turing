package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddFuncaoTransicaoActivity extends Activity
{
    private EditText edt_estado_atual, edt_simbolo_a_ser_lido, edt_novo_estado, edt_novo_simbolo, edt_movimento;
    private Button btn_add;
    private FuncaoTransicao funcaoTransicao;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_funcao_transicao);

        edt_estado_atual = (EditText) findViewById(R.id.edt_estado_ini_func_trans);
        edt_simbolo_a_ser_lido = (EditText) findViewById(R.id.edt_simbolo_lido_func_trans);
        edt_novo_estado = (EditText) findViewById(R.id.edt_estado_novo_func_trans);
        edt_novo_simbolo = (EditText) findViewById(R.id.edt_simbolo_novo_func_trans);
        edt_movimento = (EditText) findViewById(R.id.edt_movimento_func_trans);

        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        final String nomeMaq = parametros.getString("nomeMaq");

        btn_add = (Button) findViewById(R.id.btn_add_func_trans);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcaoTransicao = new FuncaoTransicao(nomeMaq,
                                                      edt_estado_atual.getText().toString(),
                                                      edt_simbolo_a_ser_lido.getText().toString(),
                                                      edt_novo_estado.getText().toString(),
                                                      edt_novo_simbolo.getText().toString(),
                                                      edt_movimento.getText().toString()
                                                      );
                //Cadastra
                SqliteFuncaoTransicaoDao sqliteFuncaoTransicaoDao = new SqliteFuncaoTransicaoDao(v.getContext());
                sqliteFuncaoTransicaoDao.save(funcaoTransicao);
            }
        });
    }

}
