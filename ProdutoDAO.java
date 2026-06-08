import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
    private ConectaPostgres banco;

    public ProdutoDAO(ConectaPostgres banco) {
        this.banco = banco;
    }

    public void inserir(Produto produto) {
        String sql;
        sql = "INSERT INTO Produto (nome_produto, ean, dun, descricao, marca, categoria)" +
                " VALUES ('" +  produto.getNome_produto() + "', '" +
                                produto.getEan() + "', '" +
                                produto.getDun() + "', '" +
                                produto.getDescricao() + "', '" +
                                produto.getMarca() + "', '" +
                                produto.getCategoria() +  "')";
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Produto> buscar() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql, nome_produto, ean, dun, descricao, marca, categoria;
        int cod_produto;
        sql = "SELECT * FROM Produto ORDER BY cod_produto";

        try {
            banco.rs = banco.stmt.executeQuery(sql);
            while (banco.rs.next()){
                nome_produto = banco.rs.getString("nome_produto");
                ean = banco.rs.getString("ean");
                dun = banco.rs.getString("dun");
                descricao = banco.rs.getString("descricao");
                marca = banco.rs.getString("marca");
                cod_produto = banco.rs.getInt("cod_produto");
                categoria = banco.rs.getString ("categoria");
                Produto produto = new Produto(nome_produto, ean, dun, descricao, marca, categoria );
                produto.setCod_produto(cod_produto);
                lista.add(produto);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public void atualizar (Produto produto){
        String sql;
        sql = "UPDATE Produto SET nome_produto = '" + produto.getNome_produto() +
                "', ean = '" + produto.getEan() +
                "', dun = '" + produto.getDun() +
                "', descricao ='" + produto.getDescricao() +
                "', marca = '" + produto.getMarca() +
                "', categoria = '" + produto.getCategoria() +
                "' WHERE cod_produto = " + produto.getCod_produto();
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deletar (Produto produto){
        String sql;
        sql = "DELETE FROM Produto WHERE cod_produto = " + produto.getCod_produto();
        try {
            banco.stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}