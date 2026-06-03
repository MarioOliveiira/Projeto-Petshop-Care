public class Animal {
    private String nome;
    private int cod_animal;

    public void setCod_animal(int cod_animal){
        this.cod_animal = cod_animal;
    }

    public int getCod_animal(){
        return cod_animal;
    }

    public Animal (String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
