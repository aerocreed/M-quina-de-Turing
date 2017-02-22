package exemplo.com.maquinaturing;

public class FuncaoTransicao {
    String nomeMaq,
           estadoAtual,
           simboloASerLido,
           novoEstado,
           novoSimbolo,
           movimento;

    public FuncaoTransicao(String nomeMaq, String estadoAtual, String simboloASerLido, String novoEstado, String novoSimbolo, String movimento) {
        this.nomeMaq = nomeMaq;
        this.estadoAtual = estadoAtual;
        this.simboloASerLido = simboloASerLido;
        this.novoEstado = novoEstado;
        this.novoSimbolo = novoSimbolo;
        this.movimento = movimento;
    }

    public String getNomeMaq() {
        return nomeMaq;
    }

    public void setNomeMaq(String nomeMaq) {
        this.nomeMaq = nomeMaq;
    }

    public String getSimboloASerLido() {
        return simboloASerLido;
    }

    public void setSimboloASerLido(String simboloASerLido) {
        this.simboloASerLido = simboloASerLido;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public String getNovoEstado() {
        return novoEstado;
    }

    public void setNovoEstado(String novoEstado) {
        this.novoEstado = novoEstado;
    }

    public String getNovoSimbolo() {
        return novoSimbolo;
    }

    public void setNovoSimbolo(String novoSimbolo) {
        this.novoSimbolo = novoSimbolo;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }
}
