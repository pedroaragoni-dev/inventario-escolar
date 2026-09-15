package br.com.pedroaragoni.inventario.exception;

public class CategoriaNaoEncontradaException extends RuntimeException {

    public CategoriaNaoEncontradaException(Long id) {
        super("Categoria não encontrada com o id: " + id);
    }
}
