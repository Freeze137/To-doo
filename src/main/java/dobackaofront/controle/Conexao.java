package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // ⚙️ Ajuste 1: Certifique-se que o nome do banco e porta estão corretos
    private static final String URL = "jdbc:mysql://localhost:3306/matricula_escolar?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "#Mae22150"; // troque pela senha real do MySQL

    public static Connection getConnection() throws SQLException {
        try {
            // ⚙️ Ajuste 2: Garante que o driver do MySQL seja carregado
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC do MySQL não encontrado!", e);
        }
    }
} // <