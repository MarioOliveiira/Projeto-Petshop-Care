import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class testeConexaoBD {

    public static void main(String[] args) {
		
     	/*	String driver = "org.postgresql.Driver";
	        String user   = "postgres";
	        String senha = "postgres";
			String url      = "jdbc:postgresql://localhost:5432/petshop";

	      try {
	        Class.forName(driver);
            Connection con = null;
            con = (Connection) DriverManager.getConnection(url, user, senha);
    		System.out.println("Conexão realizada com sucesso.");

			}catch(Exception e)
			{
				 System.err.print(e.getMessage());

			}*/
        ConectaPostgres banco = new ConectaPostgres();
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String password = "postgres";
        String url      = "jdbc:postgresql://localhost:5432/petshop";
        banco.Conectar(url, user, password);

    }

}