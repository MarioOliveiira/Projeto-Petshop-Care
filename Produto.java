public class Produto {
    private int cod_produto;
    private String nome_produto;
    private String ean;
    private String dun;
    private String descricao;
    private String marca;
    private String categoria;

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setNome_produto(String nome_produto){
        this.nome_produto = nome_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getEan(){
        return ean;
    }

    public void setDun(String dun) {
        this.dun = dun;
    }

    public String getDun() {
        return dun;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public Produto(String nome_produto, String ean, String dun, String descricao, String marca, String categoria){
        this.nome_produto = nome_produto;
        this.ean = ean;
        this.dun = dun;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
    }
}
