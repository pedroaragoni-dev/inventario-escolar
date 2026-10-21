package br.com.pedroaragoni.inventario.exception;

public class ModeloNaoEncontradoException extends RuntimeException {

    public ModeloNaoEncontradoException(Long id) {
        super("Modelo não encontrado com o id: " + id);
    }
}