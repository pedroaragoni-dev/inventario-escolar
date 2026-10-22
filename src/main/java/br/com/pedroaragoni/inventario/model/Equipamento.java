package br.com.pedroaragoni.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamento")
    private Long id;

    @Column(name = "identificador_interno", nullable = false, unique = true, length = 20)
    private String identificadorInterno;

    @Column(name = "numero_serie", nullable = false, unique = true, length = 100)
    private String numeroSerie;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_localizacao", nullable = false)
    private Localizacao localizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_funcionamento", nullable = false, length = 30)
    private StatusFuncionamento statusFuncionamento;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDate dataAtualizacao;

    @Column(name = "observacoes", columnDefinition = "TEXT")
    private String observacoes;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    protected Equipamento() {
    }

    public Equipamento(
            String identificadorInterno,
            String numeroSerie,
            Modelo modelo,
            Localizacao localizacao,
            StatusFuncionamento statusFuncionamento,
            String observacoes) {

        this.identificadorInterno = identificadorInterno;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.localizacao = localizacao;
        this.statusFuncionamento = statusFuncionamento;
        this.observacoes = observacoes;
    }

    @PrePersist
    private void preencherDatasCadastro() {
        LocalDate hoje = LocalDate.now();
        this.dataCadastro = hoje;
        this.dataAtualizacao = hoje;
    }

    @PreUpdate
    private void atualizarData() {
        this.dataAtualizacao = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getIdentificadorInterno() {
        return identificadorInterno;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public StatusFuncionamento getStatusFuncionamento() {
        return statusFuncionamento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void alterarLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public void alterarStatusFuncionamento(StatusFuncionamento statusFuncionamento) {
        this.statusFuncionamento = statusFuncionamento;
    }

    public void alterarObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}