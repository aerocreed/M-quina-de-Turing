package layout.AdaptersListView;

public class ItemListView
{
    private String nome;
    private Class<?> cls; //A classe da activity que deve ser aberta ao clicar em um item

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public ItemListView()
    {
    }

    public ItemListView(String nome)
    {
        this.nome           = nome;
    }

    public ItemListView(String nome, Class<?> cls)
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

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}