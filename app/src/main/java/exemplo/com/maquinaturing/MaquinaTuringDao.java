package exemplo.com.maquinaturing;

import java.util.List;

public interface MaquinaTuringDao {
    public void save(MaquinaTuring maquinaTuring);
    public void delete(MaquinaTuring funcaoTransicao);
    public List list();
    public MaquinaTuring find(String nome);
}
