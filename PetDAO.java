import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PetDAO {
    private ConectaPostgres banco;

    public PetDAO(ConectaPostgres banco) {
        this.banco = banco;
    }

    public void inserir(Pet pet) {
        String sql;
        sql = "INSERT INTO Pet (nome_pet, porte, tipo_pelo, peso, cod_animal, cod_cliente)" +
                " VALUES ('" + pet.getNome_pet() + "', '" + pet.getPorte() + "', '" + pet.getTipo_pelo() + "', '" + pet.getPeso() + "', '" + pet.getCod_animal() + "', '" + pet.getCod_cliente() + "')";
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Pet> buscar() {
        ArrayList<Pet> lista = new ArrayList<>();
        String sql, nome_pet, porte, tipo_pelo;
        double peso;
        int cod_cliente, cod_animal, cod_pet;
        sql = "SELECT * FROM Pet ORDER BY cod_pet";

        try {
            banco.rs = banco.stmt.executeQuery(sql);
            while (banco.rs.next()){
                nome_pet = banco.rs.getString("nome_pet");
                porte = banco.rs.getString("porte");
                tipo_pelo = banco.rs.getString("tipo_pelo");
                peso = banco.rs.getDouble("peso");
                cod_animal = banco.rs.getInt("cod_animal");
                cod_cliente = banco.rs.getInt("cod_cliente");
                cod_pet = banco.rs.getInt("cod_pet");
                Pet pet = new Pet(nome_pet, porte, tipo_pelo, peso, cod_animal, cod_cliente);
                pet.setCod_pet(cod_pet);
                lista.add(pet);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public void atualizar (Pet pet){
        String sql;
        sql = "UPDATE Pet SET nome_pet = '" + pet.getNome_pet() +
                "', porte = '" + pet.getPorte() +
                "', tipo_pelo = '" + pet.getTipo_pelo() +
                "', peso = '" + pet.getPeso() +
                "', cod_animal = '" + pet.getCod_animal() +
                "', cod_cliente = '" + pet.getCod_cliente() +
                "' WHERE cod_pet = " + pet.getCod_pet();
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deletar (Pet pet){
        String sql;
        sql = "DELETE FROM Pet WHERE cod_pet = " + pet.getCod_pet();
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}