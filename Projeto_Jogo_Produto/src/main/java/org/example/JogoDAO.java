package org.example;

import java.util.List;

public interface JogoDAO {
    boolean create (Jogo jogo);
    List <Jogo> read ();
    boolean update(Jogo jogo);
    boolean delete(Jogo jogo);
    boolean readId(Jogo jogo);
}
