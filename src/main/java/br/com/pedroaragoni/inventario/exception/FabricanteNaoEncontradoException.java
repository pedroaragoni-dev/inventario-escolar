package br.com.pedroaragoni.inventario.exception;

public class FabricanteNaoEncontradoException extends RuntimeException {

    public FabricanteNaoEncontradoException(Long id) {
        super("Fabricante não encontrado com o id: " + id);
    }
}