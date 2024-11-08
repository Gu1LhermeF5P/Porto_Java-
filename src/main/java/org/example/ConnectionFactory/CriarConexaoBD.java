package org.example.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class CriarConexaoBD {
    public static Connection conn; // Consigo criar apenas uma conexão ativa
    private static final String server = "oracle.fiap.com.br";
    private static final  String port = "1521";// Porta TCP padrão do Oracle
    private static final String sid = "ORCL";//SID do banco
    private static String url = "jdbc:oracle:thin:@" + server + ":" + port + ":" + sid;
    private static final String user = "RM557648";
    private static final String passwd = "fiap24";

    public static Connection pegarConexao(){
        if (conn==null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url, user, passwd);
            }catch (Exception e){
                System.out.println("Driver ou conexão falhou" + e.getMessage());
            }
        }
        return conn;
    }
}
