package br.com.pedroaragoni.inventario.exception;

public class RegistroInativoException extends RuntimeException {

    public RegistroInativoException(String mensagem) {
        super(mensagem);
    }
}