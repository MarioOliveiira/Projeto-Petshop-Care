import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

public class testeConexaoBD {
    public static void main(String[] args) {
        ConectaPostgres banco = new ConectaPostgres();
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String password = "postgres";
        String url      = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);

        //Animal animal = new Animal("Cachorro");

        //AnimalDAO animalDAO = new AnimalDAO(banco);

        //animalDAO.inserir(animal);

        //ArrayList<Animal> animais = animalDAO.buscar();
        //for (Animal a : animais){
        //    System.out.println(a.getCod_animal() + " - " + a.getNome());
        //}
        //Animal animalAtualizado = new Animal("CachorroAtualizado");
        //animalAtualizado.setCod_animal(1);
        //animalDAO.atualizar(animalAtualizado);

        //Animal animaldeletar = new Animal("");
        //animaldeletar.setCod_animal(9);
        //animalDAO.deletar(animaldeletar);
    }
}