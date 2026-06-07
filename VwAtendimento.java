public class VwAtendimento {
    private String nome_cliente;
    private String nome_pet;
    private String nome_servico;
    private double valor_servico;

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setValor_servico(double valor_servico) {
        this.valor_servico = valor_servico;
    }

    public double getValor_servico() {
        return valor_servico;
    }

    public VwAtendimento (String nome_cliente, String nome_pet, String nome_servico, double valor_servico){
        this.nome_cliente = nome_cliente;
        this.nome_pet = nome_pet;
        this.nome_servico = nome_servico;
        this.valor_servico = valor_servico;
    }
}
