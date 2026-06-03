import java.time.LocalDate;
import java.util.Locale;

public class Cliente {
    private int cod_cliente;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate data_cadastro;

    public void setCod_cliente(int cod_cliente){
        this.cod_cliente = cod_cliente;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getEmail (){
        return email;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public Cliente (String nome, String cpf, String email, LocalDate data_cadastro){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_cadastro = data_cadastro;
    }
}
