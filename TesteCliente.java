import java.time.LocalDate;
import java.util.ArrayList;

public class TesteCliente {
    public static void main(String[] args) {
        ConectaPostgres banco = new ConectaPostgres();
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String password = "postgres";
        String url      = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);

        Cliente cliente = new Cliente(
                "Mario",
                "111.111.111-11",
                "mario@gmail.com",
                LocalDate.of(2026, 06,03)
        );

        ClienteDAO clienteDAO = new ClienteDAO(banco);

        clienteDAO.inserir(cliente);

        ArrayList<Cliente> clientes = clienteDAO.buscar();
        for (Cliente a : clientes){
            System.out.println(a.getCod_cliente() + " - " +
                    a.getNome_cliente() + " - " +
                    a.getEmail() + " - " +
                    a.getCpf() + " - " +
                    a.getData_cadastro());
        }

        Cliente clienteAtualizado = new Cliente(
                "Rodrigo Santos",
                "000.000.002-02",
                "rodrigo123@gmail.com",
                LocalDate.of(2026, 05, 15)
        );
        clienteAtualizado.setCod_cliente(3);
        clienteDAO.atualizar(clienteAtualizado);

        Cliente clienteDeletar = new Cliente("","","",LocalDate.of(2026,05,15));
        clienteDeletar.setCod_cliente(1);
        clienteDAO.deletar(clienteDeletar);
    }
}
