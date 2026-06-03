import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteDAO {
    private ConectaPostgres banco;

    public ClienteDAO(ConectaPostgres banco) {
        this.banco = banco;
    }

    public void inserir(Cliente cliente) {
        String sql;
        sql = "INSERT INTO Cliente (nome, cpf, email, data_cadastro)" +
                " VALUES ('" + cliente.getNome() + "', '" + cliente.getCpf() + "', '" + cliente.getEmail() + "', '" + cliente.getData_cadastro() + "')";
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Cliente> buscar() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql, nome, cpf, email;
        LocalDate data_cadastro;
        int cod_cliente;
        sql = "SELECT * FROM Cliente";

        try {
            banco.rs = banco.stmt.executeQuery(sql);
            while (banco.rs.next()){
                nome = banco.rs.getString("nome");
                cpf = banco.rs.getString("cpf");
                email = banco.rs.getString("email");
                data_cadastro = banco.rs.getDate("data_cadastro").toLocalDate();
                cod_cliente = banco.rs.getInt("cod_cliente");
                Cliente cliente = new Cliente(nome, cpf, email, data_cadastro);
                cliente.setCod_cliente(cod_cliente);
                lista.add(cliente);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public void atualizar (Cliente cliente){
        String sql;
        sql = "UPDATE Cliente SET nome = '" + cliente.getNome() +
                "', cpf = '" + cliente.getCpf() +
                "', email = '" + cliente.getEmail() +
                "', data_cadastro ='" + cliente.getData_cadastro() +
                "' WHERE cod_cliente = " + cliente.getCod_cliente();
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deletar (Cliente cliente){
        String sql;
        sql = "DELETE FROM Cliente WHERE cod_cliente = " + cliente.getCod_cliente();
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
