package br.com.pedroaragoni.inventario.exception;

public class FabricanteJaCadastradoException extends RuntimeException {

    public FabricanteJaCadastradoException() {
        super("Já existe um fabricante com esse nome");
    }
}