import java.time.LocalDate;
import java.util.ArrayList;

public class TesteProduto {
    public static void main(String[] args) {
        ConectaPostgres banco = new ConectaPostgres();
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String password = "postgres";
        String url      = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);

        Produto produto = new Produto(
          "Bebedouro automatico para cães e gatos",
                "789964322287",
                "1789964322287",
                "Elaborado com material atóxico, possibilitando que a ração fique por mais dias no reservatório sem perder a qualidade, além de mantê-la limpa e livre da umidade.",
                "Pets do bem",
                "Bebedouros"
        );

        ProdutoDAO produtoDAO = new ProdutoDAO(banco);

        produtoDAO.inserir(produto);

        ArrayList<Produto> produtos = produtoDAO.buscar();
        for (Produto a : produtos){
            System.out.println(a.getCod_produto() + " - " +
                    a.getNome_produto() + " - " +
                    a.getEan() + " - " +
                    a.getDun() + " - " +
                    a.getDescricao() + " - " +
                    a.getMarca() + " - " +
                    a.getCategoria());
        }

        Produto produtoAtualizado = new Produto(
                "Bebedouro automatico para cães e gatos",
                "7899643232287",
                "17899643322287",
                "Elaborado com material atóxico, possibilitando que a ração fique por mais dias no reservatório sem perder a qualidade.",
                "Pets do bem",
                "Bebedouros"
        );
        produtoAtualizado.setCod_produto(2);
        produtoDAO.atualizar(produtoAtualizado);

        Produto produtoDeletar = new Produto("","","","","","");
        produtoDeletar.setCod_produto(7);
        produtoDAO.deletar(produtoDeletar);
    }
}

