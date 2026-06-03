public class Pet {
    private int cod_pet;
    private String nome;
    private String porte;
    private String tipo_pelo;
    private double peso;
    private int cod_animal;
    private int cod_cliente;

    public void setCod_pet(int cod_pet){
        this.cod_pet = cod_pet;
    }

    public int getCod_pet() {
        return cod_pet;
    }

    public void setCod_animal(int cod_animal) {
        this.cod_animal = cod_animal;
    }

    public int getCod_animal(){
        return cod_animal;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_cliente(){
        return cod_cliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getPorte() {
        return porte;
    }

    public void setTipo_pelo(String tipo_pelo) {
        this.tipo_pelo = tipo_pelo;
    }

    public String getTipo_pelo() {
        return tipo_pelo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public Pet (String nome, String porte, String tipo_pelo, double peso, int cod_animal, int cod_cliente){
        this.nome = nome;
        this.porte = porte;
        this.tipo_pelo = tipo_pelo;
        this.peso = peso;
        this.cod_animal = cod_animal;
        this.cod_cliente = cod_cliente;
    }
}
