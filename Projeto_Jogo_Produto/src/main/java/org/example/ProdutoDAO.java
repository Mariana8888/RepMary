package org.example;

import java.util.List;

public interface ProdutoDAO {
    boolean create (Produto produto);
    List <Produto> read ();
    boolean readMarca(Produto produto);
    boolean readNome (Produto produto);
    boolean update(Produto produto);
    boolean delete(Produto produto);
}
