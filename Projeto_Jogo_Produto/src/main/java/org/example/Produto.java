package org.example;

public class Produto {
    private String id;
    private String descricao;
    private String marca;
    private float preco;

    public Produto(){}

    public Produto(String id, String descricao, String marca, float preco){
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Nome do Produto: "+descricao +
                " \nCodigo: " + id +
                " \nMarca: " + marca + " \nPreço: " + preco+" \n----------------------------------";
    }
}
