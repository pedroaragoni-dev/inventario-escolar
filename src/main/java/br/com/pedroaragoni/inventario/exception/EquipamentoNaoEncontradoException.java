package br.com.pedroaragoni.inventario.exception;

public class EquipamentoNaoEncontradoException extends RuntimeException {

    public EquipamentoNaoEncontradoException(Long id) {
        super("Equipamento não encontrado com o id: " + id);
    }

    public EquipamentoNaoEncontradoException(String codigo) {
        super("Equipamento não encontrado com o código: " + codigo);
    }
}