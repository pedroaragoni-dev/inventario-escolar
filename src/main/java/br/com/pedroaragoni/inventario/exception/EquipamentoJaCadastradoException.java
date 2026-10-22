package br.com.pedroaragoni.inventario.exception;

public class EquipamentoJaCadastradoException extends RuntimeException {

    public EquipamentoJaCadastradoException() {
        super("Já existe um equipamento com esse número de série");
    }
}