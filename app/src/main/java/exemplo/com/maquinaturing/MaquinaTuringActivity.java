package exemplo.com.maquinaturing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MaquinaTuringActivity extends Activity
{
    private EditText entrada;
    private ImageView celula[];
    private TextView maquina_selecionada;
    private Button iniciar;
    private Button proximoPasso;
    private Button celulaAnterior;
    private Button celulaSeguinte;
    private int indiceInicioExibicao;
    private int tamanhoFita;
    private MaquinaTuring mt;
    private List<FuncaoTransicao> funcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_maquina_turing);

        //Recebendo o nome clicado na lista
        Intent intent = getIntent();
        Bundle parametros = intent.getExtras();

        final String nomeMaq = parametros.getString("nomeMaq");

        indiceInicioExibicao = 0;
        tamanhoFita = 100;

        celula = new ImageView[6];
        celula[0] = (ImageView) findViewById(R.id.celula1);
        celula[1] = (ImageView) findViewById(R.id.celula2);
        celula[2] = (ImageView) findViewById(R.id.celula3);
        celula[3] = (ImageView) findViewById(R.id.celula4);
        celula[4] = (ImageView) findViewById(R.id.celula5);
        celula[5] = (ImageView) findViewById(R.id.celula6);

        entrada = (EditText) findViewById(R.id.txv_entrada);
        iniciar = (Button) findViewById(R.id.btn_iniciar);
        proximoPasso = (Button) findViewById(R.id.btn_prox_passo);
        celulaAnterior = (Button) findViewById(R.id.indice_anterior);
        celulaSeguinte = (Button) findViewById(R.id.indice_prox);
        maquina_selecionada = (TextView) findViewById(R.id.txv_maq_selecionada);

        maquina_selecionada.setText(nomeMaq);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(entrada.getText().toString().isEmpty())) {
                    SqliteMaquinaTuringDao sqliteMaquinaTuringDao = new SqliteMaquinaTuringDao(v.getContext());
                    mt = sqliteMaquinaTuringDao.find(nomeMaq);
                    mt.setFita(new Fita(tamanhoFita, entrada.getText().toString(), "1", "-1", 0, "1"));
                    //Exibe uma parte da entrada na tela
                    for (int i = 0; i < celula.length; i++) {
                        Log.i(i + ":", mt.getFita().leSimboloFita(mt.getFita().getIndiceCabecote() + i));
                        if (mt.getFita().leSimboloFita(i).equals("0")) {
                            celula[i].setImageResource(R.drawable.ic_0);
                        } else if (mt.getFita().leSimboloFita(i).equals("1")) {
                            celula[i].setImageResource(R.drawable.ic_1);
                        } else if (mt.getFita().leSimboloFita(i).equals("_")) {
                            celula[i].setImageResource(R.drawable.ic_branco);
                        }
                    }
                    funcoes = mt.getFuncoesTransicao();
                }
                else{
                    Toast.makeText(v.getContext(), "A ENTRADA NÃO PODE SER VAZIA", Toast.LENGTH_SHORT).show();
                }
            }
        });

        proximoPasso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean aceita = false;
                boolean rejeita = true;
                for (FuncaoTransicao f : funcoes) {
                    rejeita = true;
                    //Se existe alguma função de transição para o símbolo e estado atual, não rejeite
                    if(mt.getFita().getEstadoAtual().equals(f.getEstadoAtual()) && mt.getFita().getSimboloAtual().equals(f.getSimboloASerLido())) {
                        aceita = mt.getFita().processaFuncaoTransicao(f);
                        ExibeSimbolos();
                        rejeita = false;
                        break;
                    }
                }
                entrada.setText("FITA:" + mt.getFita().getStringFita());
                if(aceita){
                    entrada.setText("");
                    Toast.makeText(v.getContext(), "ENTRADA ACEITA", Toast.LENGTH_SHORT).show();
                }
                else if(rejeita){
                    entrada.setText("");
                    Toast.makeText(v.getContext(), "ENTRADA REJEITADA", Toast.LENGTH_SHORT).show();
                }
            }
        });

        celulaAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indiceInicioExibicao>0){
                    indiceInicioExibicao--;
                    ExibeSimbolos();
                }
            }
        });

        celulaSeguinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indiceInicioExibicao<tamanhoFita-celula.length){
                    indiceInicioExibicao++;
                    ExibeSimbolos();
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ExibeSimbolos(){
        for (int i = 0; i < celula.length; i++) {
            Log.i(i + ":", mt.getFita().leSimboloFita(mt.getFita().getIndiceCabecote() + i));
            if (mt.getFita().leSimboloFita(indiceInicioExibicao + i).equals("0")) {
                celula[i].setImageResource(R.drawable.ic_0);
            } else if (mt.getFita().leSimboloFita(indiceInicioExibicao + i).equals("1")) {
                celula[i].setImageResource(R.drawable.ic_1);
            } else if (mt.getFita().leSimboloFita(indiceInicioExibicao + i).equals("_")) {
                celula[i].setImageResource(R.drawable.ic_branco);
            }
        }
    }
}
