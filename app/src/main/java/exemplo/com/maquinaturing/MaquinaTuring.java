package exemplo.com.maquinaturing;

import java.util.List;

public class MaquinaTuring {
    String nome;
    Fita fita;
    String entrada;
    List<String> alfabetoSimbolos;
    List<String> alfabetoFita;
    String estadoInicial;
    String simboloInicioFita;
    String estadoAtual;
    List<String> conjuntoEstadosFinais;
    List<FuncaoTransicao> funcoesTransicao;

    public MaquinaTuring(){

    }

    public MaquinaTuring(String nome, String estadoInicial){
        this.nome = nome;
        this.estadoInicial = estadoInicial;
    }

    public MaquinaTuring(String nome, String estadoInicial, List<String> alfabetoSimbolos, List<String> conjuntoEstadosFinais){
        this.nome = nome;
        this.estadoInicial = estadoInicial;
        this.alfabetoSimbolos = alfabetoSimbolos;
        this.conjuntoEstadosFinais = conjuntoEstadosFinais;
    }

    public MaquinaTuring(String nome, Fita fita, String entrada,
                         List<String> alfabetoSimbolos, List<String> alfabetoFita,
                         String estadoInicial, String simboloInicioFita, List<String> conjuntoEstadosFinais,
                         String estadoAtual, List<FuncaoTransicao> funcoesTransicao) {
        this.nome = nome;
        this.fita = fita;
        this.entrada = entrada;
        this.alfabetoSimbolos = alfabetoSimbolos;
        this.alfabetoFita = alfabetoFita;
        this.estadoInicial = estadoInicial;
        this.simboloInicioFita = simboloInicioFita;
        this.conjuntoEstadosFinais = conjuntoEstadosFinais;
        this.estadoAtual = estadoAtual;
        this.funcoesTransicao = funcoesTransicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fita getFita() {
        return fita;
    }

    public void setFita(Fita fita) {
        this.fita = fita;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public List<String> getAlfabetoSimbolos() {
        return alfabetoSimbolos;
    }

    public void setAlfabetoSimbolos(List<String> alfabetoSimbolos) {
        this.alfabetoSimbolos = alfabetoSimbolos;
    }

    public List<String> getAlfabetoFita() {
        return alfabetoFita;
    }

    public void setAlfabetoFita(List<String> alfabetoFita) {
        this.alfabetoFita = alfabetoFita;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public String getSimboloInicioFita() {
        return simboloInicioFita;
    }

    public void setSimboloInicioFita(String simboloInicioFita) {
        this.simboloInicioFita = simboloInicioFita;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public List<String> getConjuntoEstadosFinais() {
        return conjuntoEstadosFinais;
    }

    public void setConjuntoEstadosFinais(List<String> conjuntoEstadosFinais) {
        this.conjuntoEstadosFinais = conjuntoEstadosFinais;
    }

    public List<FuncaoTransicao> getFuncoesTransicao() {
        return funcoesTransicao;
    }

    public void setFuncoesTransicao(List<FuncaoTransicao> funcoesTransicao) {
        this.funcoesTransicao = funcoesTransicao;
    }

    public void addFuncaoTransicao(FuncaoTransicao funcaoTransicao) {
        this.funcoesTransicao.add(funcaoTransicao);
    }
}
