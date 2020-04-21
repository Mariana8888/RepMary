package org.example;

public class Jogo {
    private String id;
    private String nomeTimeA;
    private String nomeTimeB;
    private int golsTimeA;
    private int golsTimeB;

    public Jogo(){}

    public Jogo (String id, String nomeTimeA, String nomeTimeB, int golsTimeA, int golsTimeB){
        this.setId(id);
        this.setNomeTimeA(nomeTimeA);
        this.setNomeTimeB(nomeTimeB);
        this.setGolsTimeA(golsTimeA);
        this.setGolsTimeB(golsTimeB);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeTimeA() {
        return nomeTimeA;
    }

    public void setNomeTimeA(String nomeTimeA) {
        this.nomeTimeA = nomeTimeA;
    }

    public String getNomeTimeB() {
        return nomeTimeB;
    }

    public void setNomeTimeB(String nomeTimeB) {
        this.nomeTimeB = nomeTimeB;
    }

    public int getGolsTimeA() {
        return golsTimeA;
    }

    public void setGolsTimeA(int golsTimeA) {
        this.golsTimeA = golsTimeA;
    }

    public int getGolsTimeB() {
        return golsTimeB;
    }

    public void setGolsTimeB(int golsTimeB) {
        this.golsTimeB = golsTimeB;
    }

    @Override
    public String toString() {
        return "Jogo: " + id +
                " \nNome do time A: " + nomeTimeA +
                " \nNome do time B: " + nomeTimeB + " \nGols do time A: " + golsTimeA + "\nGols do time B: " + golsTimeB +
        " \n----------------------------------";
    }

}
