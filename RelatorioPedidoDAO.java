import java.sql.SQLException;
import java.util.ArrayList;

public class RelatorioPedidoDAO {
    private ConectaPostgres banco;

    public RelatorioPedidoDAO (ConectaPostgres banco){
        this.banco = banco;
    }

    public static void main(String[] args) {
        ConectaPostgres banco = new ConectaPostgres();
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String password = "postgres";
        String url      = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);

        RelatorioPedidoDAO relatorioPedidoDAO = new RelatorioPedidoDAO((banco));

        ArrayList<RelatorioPedido> pedidos = relatorioPedidoDAO.buscar();

        for (RelatorioPedido a : pedidos){
            System.out.println(a.getNome_cliente() + " - " +
                               a.getNome_produto() + " - " +
                               a.getValor_total());
        }
    }

    public ArrayList<RelatorioPedido> buscar() {
        ArrayList<RelatorioPedido> lista = new ArrayList<>();
        String sql, nome_produto, nome_cliente;
        double valor_total;
        sql = "SELECT nome_produto, nome_cliente, ped.valor_total " +
                "FROM produto_pedido pp " +
                " INNER JOIN produto p ON p.cod_produto = pp.cod_produto" +
                " INNER JOIN pedido ped ON ped.cod_pedido = pp.cod_pedido" +
                " INNER JOIN cliente c ON c.cod_cliente = ped.cod_cliente";
        try {
            banco.rs = banco.stmt.executeQuery(sql);
            while (banco.rs.next()) {
                nome_produto = banco.rs.getString("nome_produto");
                nome_cliente = banco.rs.getString("nome_cliente");
                valor_total = banco.rs.getDouble("valor_total");
                RelatorioPedido relatorioPedido = new RelatorioPedido(nome_produto, nome_cliente, valor_total);
                lista.add(relatorioPedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
