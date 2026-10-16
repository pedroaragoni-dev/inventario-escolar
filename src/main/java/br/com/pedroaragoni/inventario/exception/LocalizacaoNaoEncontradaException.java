package br.com.pedroaragoni.inventario.exception;

public class LocalizacaoNaoEncontradaException extends RuntimeException {

    public LocalizacaoNaoEncontradaException(Long id) {
        super("Localização não encontrada com o id: " + id);
    }
}