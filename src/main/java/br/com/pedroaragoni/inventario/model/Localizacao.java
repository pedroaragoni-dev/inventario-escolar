package br.com.pedroaragoni.inventario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "localizacao")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacao")
    private Long id;

    @Column(name = "codigo", nullable = false, unique = true, length = 20)
    private String codigo;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    protected Localizacao() {
    }

    public Localizacao(String codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void alterarDados(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}
