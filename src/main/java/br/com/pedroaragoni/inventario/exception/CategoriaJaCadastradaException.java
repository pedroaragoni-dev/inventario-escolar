package br.com.pedroaragoni.inventario.exception;

public class CategoriaJaCadastradaException extends RuntimeException {

    public CategoriaJaCadastradaException() {
        super("Já existe uma categoria com esse nome");
    }
}
