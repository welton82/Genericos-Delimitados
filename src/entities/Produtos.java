package entities;

import java.util.ArrayList;
import java.util.List;

public class Produtos implements Comparable <Produtos> {
    private String nome;
    private Double preco;


    private List<Produtos> lista = new ArrayList<>();

    public Produtos() {
    }

    public Produtos(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void adicionaLista(Produtos p){
        lista.add(p);
    }


    public List<Produtos> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Produtos p:lista){
            s.append(p.nome);
            s.append(", ");
            s.append(p.preco);
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public int compareTo(Produtos o) {
        return preco.compareTo(o.getPreco());
    }
}
