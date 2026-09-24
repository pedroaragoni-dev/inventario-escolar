package br.com.pedroaragoni.inventario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fabricante")
    private Long id;

    @Column(name = "nome", nullable = false, unique = true,
    length = 100)
    private String nome;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    protected Fabricante() {
    }

    public Fabricante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
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
