import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VwAtendimentoDAO {

    private ConectaPostgres banco;

    public VwAtendimentoDAO(ConectaPostgres banco) {
        this.banco = banco;
    }

    public static void main(String[] args) {
        ConectaPostgres banco = new ConectaPostgres();
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String password = "postgres";
        String url      = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);

        VwAtendimentoDAO vwAtendimentoDAO = new VwAtendimentoDAO(banco);

        ArrayList<VwAtendimento> atendimentos = vwAtendimentoDAO.buscar();
        for (VwAtendimento a : atendimentos){
            System.out.println(a.getNome_cliente() + " - " +
                               a.getNome_pet() + " - " +
                               a.getNome_servico() + " - " +
                               a.getValor_servico());
        }
    }

    public ArrayList<VwAtendimento> buscar() {
        ArrayList<VwAtendimento> lista = new ArrayList<>();
        String sql, nome_pet, nome_cliente, nome_servico;
        double valor_servico;
        sql = "SELECT * FROM Vw_Atendimentos";

        try {
            banco.rs = banco.stmt.executeQuery(sql);
            while (banco.rs.next()) {
                nome_cliente = banco.rs.getString("nome_cliente");
                nome_pet = banco.rs.getString("nome_pet");
                nome_servico = banco.rs.getString("nome_servico");
                valor_servico = banco.rs.getDouble("valor_servico");
                VwAtendimento vwAtendimento = new VwAtendimento(nome_cliente, nome_pet, nome_servico, valor_servico);
                lista.add(vwAtendimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}