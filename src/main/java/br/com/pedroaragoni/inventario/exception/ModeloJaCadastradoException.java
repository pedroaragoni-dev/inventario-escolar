package br.com.pedroaragoni.inventario.exception;

public class ModeloJaCadastradoException extends RuntimeException {

    public ModeloJaCadastradoException() {
        super("Já existe um modelo com esse nome, fabricante e categoria");
    }
}