package exemplo.com.maquinaturing;

import java.util.List;

public interface FuncaoTransicaoDao {
    public String save(FuncaoTransicao funcaoTransicao);
    public void delete(FuncaoTransicao funcaoTransicao);
    public List list(MaquinaTuring maquinaTuring);
    public FuncaoTransicao find(String estadoAtual, String simbolo);
}
