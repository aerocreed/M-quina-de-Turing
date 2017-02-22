package exemplo.com.maquinaturing;

import java.util.Arrays;
import java.util.List;

public class Fita {
    private int tamanhoMaxFita, indiceCabecote;

    private String simboloInicio,
                   simbolos[],
                   estadoAtual,
                   simboloBranco,
                   estadoAceitacao;
    public final String ESQUERDA = "ESQUERDA";
    public final String DIREITA = "DIREITA";

    public Fita(int tamanhoMaxFita, String entrada, String estadoAtual, String estadoAceitacao, int posInicialCabecote, String simboloInicio){
        this.tamanhoMaxFita = tamanhoMaxFita;
        this.simboloInicio = simboloInicio;
        this.simboloBranco = "_";
        this.indiceCabecote = posInicialCabecote;
        this.simbolos = new String[tamanhoMaxFita];
        this.estadoAtual = estadoAtual;
        this.estadoAceitacao = estadoAceitacao;
        String[] input = entrada.split(",");
        //Insere o símbolo inicial na fita
        this.simbolos[0] = simboloInicio;
        int i;
        for(i=0; i<input.length; i++) {
            this.simbolos[i] = input[i];
        }
        //Preenche a fira com espaço em branco
        for(int j=i; j<tamanhoMaxFita; j++) {
            this.simbolos[j] = "_";
        }
    }

    public String getStringFita(){
        return Arrays.toString(simbolos);
    }

    public int getIndiceCabecote() {
        return indiceCabecote;
    }

    public void setIndiceCabecote(int indiceCabecote) {
        this.indiceCabecote = indiceCabecote;
    }

    boolean processaFuncaoTransicao(FuncaoTransicao funcaoTransicao){

        //Atualiza o símbolo e estado atual
        setEstadoAtual(funcaoTransicao.getNovoEstado());
        setSimboloAtual(funcaoTransicao.getNovoSimbolo());
        escreveSimboloFita(getSimboloAtual());
        if (funcaoTransicao.getMovimento().toUpperCase().equals(ESQUERDA)) {
            moveEsquerda();
        } else if (funcaoTransicao.getMovimento().toUpperCase().equals(DIREITA)) {
            moveDireita();
        }
        return (getEstadoAtual().equals(this.estadoAceitacao));
    }

    public String getSimboloAtual() {
        return simbolos[indiceCabecote];
    }

    public void setSimboloAtual(String novoSimbolo) {
        this.simbolos[indiceCabecote] = novoSimbolo;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String novoEstado) {
        this.estadoAtual = novoEstado;
    }

    void moveEsquerda(){
        indiceCabecote--;
    }

    void moveDireita(){
        indiceCabecote++;
    }

    //Lê o símbolo da posição em que o cabeçote está posicionado
    String leSimboloFita(int indice){
        return simbolos[indice];
    }

    void escreveSimboloFita(String simbolo){
        this.simbolos[indiceCabecote] = simbolo;
    }
}
