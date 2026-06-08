import java.time.LocalDate;
import java.util.ArrayList;

public class TestePet {
    public static void main(String[] args) {
        ConectaPostgres banco = new ConectaPostgres();
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String password = "postgres";
        String url      = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);

        Pet pet = new Pet(
                "Juninho",
                "Pequeno",
                "Longos",
                4,
                4,
                4
        );

        PetDAO petDAO = new PetDAO(banco);

        petDAO.inserir(pet);

        ArrayList<Pet> pets = petDAO.buscar();
        for (Pet a : pets){
            System.out.println(a.getCod_pet() + " - " +
                    a.getNome_pet() + " - " +
                    a.getPorte() + " - " +
                    a.getTipo_pelo() + " - " +
                    a.getPeso() + " - " +
                    a.getCod_animal() + " - " +
                    a.getCod_cliente());
        }

        Pet petAtualizado = new Pet(
                "Juninho",
                "Pequeno",
                "Longo ",
                4,
                2,
                4
        );
        petAtualizado.setCod_pet(4);
        petDAO.atualizar(petAtualizado);

        Pet petDeletar = new Pet("","","",0,0,0);
        petDeletar.setCod_pet(3);
        petDAO.deletar(petDeletar);
    }
}