package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOMySQL implements ProdutoDAO {
    private String createSQL = "INSERT INTO produto VALUES (?, ?, ?,?)";
    private String readSQL = "SELECT * FROM produto";
    private String updateSQL = "UPDATE produto SET descricao=?, marca=?, preco=? WHERE id=?";
    private String deleteSQL = "DELETE FROM produto WHERE id=?";
    private String readMarcaSQL = "SELECT * FROM produto WHERE marca=?";
    private String readNomeSQL = "SELECT * FROM produto WHERE descricao LIKE BINARY ? ";


    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Produto produto) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, produto.getId());
            stm.setString(2, produto.getDescricao());
            stm.setString(3,produto.getMarca());
            stm.setDouble(4,produto.getPreco());

            int registros = stm.executeUpdate();
            return  registros > 0 ? true : false;

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
    public List<Produto> read() {
        Connection conexao = mysql.getConnection();
        List<Produto> produtos = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getString("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getFloat("preco"));
                produtos.add(produto);
            }

            return produtos;

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
        return produtos;
    }

    @Override
    public boolean update(Produto produto) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(1,produto.getDescricao());
            stm.setString(2,produto.getMarca());
            stm.setDouble(3,produto.getPreco());
            stm.setString(4,produto.getId());

            int registros = stm.executeUpdate();
            return  registros > 0 ? true : false;

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
    public boolean delete(Produto produto) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setString(1, produto.getId());

            int registros = stm.executeUpdate();

            return  registros > 0 ? true : false;

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
    public boolean readMarca(Produto produto) {
        Connection conexao = mysql.getConnection();

        try {
            PreparedStatement stm = conexao.prepareStatement(readMarcaSQL);
            stm.setString(1, produto.getMarca());
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                produto.setId(rs.getString("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getFloat("preco"));

                System.out.println(produto);
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

    @Override
    public boolean readNome(Produto produto) {
        Connection conexao = mysql.getConnection();

        try {
            PreparedStatement stm = conexao.prepareStatement(readNomeSQL);
            stm.setString(1, "%" +  produto.getDescricao() + "%");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                produto.setId(rs.getString("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getFloat("preco"));

                System.out.println(produto);
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
