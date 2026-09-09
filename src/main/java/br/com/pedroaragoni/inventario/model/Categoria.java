package br.com.pedroaragoni.inventario.model;

import jakarta.persistence.*;

/**
 * Representa uma categoria de equipamento,
 * como Notebook, Chromebook, Desktop ou Tablet.
 */
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    // Construtor vazio necessário para o JPA conseguir
    // criar objetos vindos do banco.
    protected Categoria() {
    }

    // Será usado pelo sistema para criar uma categoria
    public Categoria(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // Para atributos booleanos é comum usar "is"e não get
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
