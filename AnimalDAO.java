import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalDAO {
    private ConectaPostgres banco;

    public AnimalDAO(ConectaPostgres banco){
        this.banco = banco;
    }
    public void inserir (Animal animal){
        String sql;
        sql = "Insert into Animal (nome)" + " VALUES ('" + animal.getNome() + "')";
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Animal> buscar() {
        ArrayList<Animal> lista = new ArrayList<>();
        String sql, nome;
        sql = "SELECT * FROM Animal";

        try{
            banco.rs = banco.stmt.executeQuery(sql);
            while (banco.rs.next()){
                nome = banco.rs.getString("nome");
                Animal animal = new Animal(nome);
                lista.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void atualizar (Animal animal){
        String sql;
        sql = "UPDATE Animal SET nome = '" + animal.getNome() + "' WHERE cod_animal = " + animal.getCod_animal();
        try{
            banco.stmt.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deletar (Animal animal){
        String sql;
        sql = "DELETE FROM Animal WHERE cod_animal = " + animal.getCod_animal();
        try{
            banco.stmt.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
