package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuMaquinaTuringActivity extends Activity
{

    private Button btn_editar_mt;
    private Button btn_executar_mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_menu_maquina_turing);

        btn_editar_mt = (Button)findViewById(R.id.btn_editar_mt);
        btn_executar_mt = (Button)findViewById(R.id.btn_executar_mt);

        final Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        final String nomeMaq = parametros.getString("nomeMaq");

        btn_editar_mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), EditMaquinaTuringActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nomeMaq", nomeMaq);

                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });

        btn_executar_mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(v.getContext(), MaquinaTuringActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nomeMaq", nomeMaq);

                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });
    }

}
