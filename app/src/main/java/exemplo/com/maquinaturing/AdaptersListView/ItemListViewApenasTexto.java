package exemplo.com.maquinaturing.AdaptersListView;

public class ItemListViewApenasTexto
{
    private String nome;
    private Class<?> cls; //A classe da activity que deve ser aberta ao clicar em um item

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public ItemListViewApenasTexto()
    {
    }

    public ItemListViewApenasTexto(String nome)
    {
        this.nome = nome;
    }

    public ItemListViewApenasTexto(String nome, Class<?> cls)
    {
        this.nome           = nome;
        this.cls            = cls;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}