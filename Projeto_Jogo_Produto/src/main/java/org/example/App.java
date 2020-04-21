package org.example;
//Beatriz Novais - Tia: 31951155
//Mariana Gonçalves - Tia: 31912362
public class App {
    public static void main(final String[] args) {
        ProdutoDAOMySQL mysqlDAO = new ProdutoDAOMySQL();
        JogoDAOMySQL mysqlDAO1 = new JogoDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO, mysqlDAO1);
        interfaceUsuario.iniciar();
    }
}
