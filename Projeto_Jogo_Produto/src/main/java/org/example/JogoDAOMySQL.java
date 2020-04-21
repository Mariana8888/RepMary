package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAOMySQL implements JogoDAO{
    private String createSQL = "INSERT INTO jogo VALUES (?, ?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM jogo";
    private String updateSQL = "UPDATE jogo SET gols_time_a=?, gols_time_b=? WHERE id=?";
    private String deleteSQL = "DELETE FROM jogo WHERE id=?";
    private String readIdSQL= "SELECT * FROM jogo WHERE id LIKE BINARY ?  ";
    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Jogo jogo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, jogo.getId());
            stm.setString(2, jogo.getNomeTimeA());
            stm.setString(3, jogo.getNomeTimeB());
            stm.setInt(4, jogo.getGolsTimeA());
            stm.setInt(5, jogo.getGolsTimeB());

            int registros = stm.executeUpdate();
            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<Jogo> read() {
        Connection conexao = mysql.getConnection();
        List<Jogo> jogos = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getString("id"));
                jogo.setNomeTimeA(rs.getString("nome_time_a"));
                jogo.setNomeTimeB(rs.getString("nome_time_b"));
                jogo.setGolsTimeA(rs.getInt("gols_time_a"));
                jogo.setGolsTimeB(rs.getInt("gols_time_b"));
                jogos.add(jogo);
            }

            return jogos;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return jogos;
    }

    @Override
    public boolean update(Jogo jogo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setInt(1, jogo.getGolsTimeA());
            stm.setInt(2, jogo.getGolsTimeB());
            stm.setString(3, jogo.getId());

            int registros = stm.executeUpdate();
            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Jogo jogo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setString(1, jogo.getId());
            int registros = stm.executeUpdate();
            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean readId(Jogo jogo) {
        Connection conexao = mysql.getConnection();

        try {
            PreparedStatement stm = conexao.prepareStatement(readIdSQL);
            stm.setString(1, "%" +  jogo.getId() + "%");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                jogo.setId(rs.getString("id"));
                jogo.setNomeTimeA(rs.getString("nome_time_a"));
                jogo.setNomeTimeB(rs.getString("nome_time_a"));
                jogo.setGolsTimeA(rs.getInt("gols_time_a"));
                jogo.setGolsTimeB(rs.getInt("gols_time_b"));

                System.out.println(jogo);
            }

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
