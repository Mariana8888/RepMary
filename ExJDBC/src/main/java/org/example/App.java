package org.example;
import java.sql.*;
public class App{
    public static void main(final String[] args ){
        Connection conexao =null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3306/ps2";
            String usuario="root";
            String senha="";
            conexao=DriverManager.getConnection(url,usuario,senha);

            String insere = "INSERT INTO controle_frequencia VALUES (1,'30536798','6:00','15:00')";
            PreparedStatement ps = conexao.prepareStatement(insere);
            ps.execute();
            System.out.println("Os dados foram inseridos!");

            String sql = "SELECT * FROM controle_frequencia";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                String pk = rs.getString("pk");
                String TIA = rs.getString("TIA");
                String hora_entrada = rs.getString("hora_entrada");
                String hora_saida = rs.getString("hora_saida");

                System.out.println("Registro #"+pk+" TIA: "+TIA+" - Entrou em:"+hora_entrada+" - Saiu em: "+hora_saida);
            }

            rs.close();
            conexao.close();

        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println("Erro!");
            e.printStackTrace();
        }
    }
}
