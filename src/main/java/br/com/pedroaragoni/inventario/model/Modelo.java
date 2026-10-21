package br.com.pedroaragoni.inventario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_fabricante", nullable = false)
    private Fabricante fabricante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    protected Modelo() {
    }

    public Modelo(String nome, Fabricante fabricante, Categoria categoria) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void alterarNome(String nome) {
        this.nome = nome;
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}