package br.com.pedroaragoni.inventario.exception;

public class LocalizacaoJaCadastradaException extends RuntimeException {

    public LocalizacaoJaCadastradaException() {
        super("Já existe uma localização com esse código");
    }
}