public class RelatorioPedido {
    private String nome_produto;
    private String nome_cliente;
    private double valor_total;

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getValor_total() {
        return valor_total;
    }

    public RelatorioPedido(String nome_produto, String nome_cliente, double valor_total){
        this.nome_produto = nome_produto;
        this.nome_cliente = nome_cliente;
        this.valor_total = valor_total;
    }
}
