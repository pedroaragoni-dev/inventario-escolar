package br.com.pedroaragoni.inventario.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import br.com.pedroaragoni.inventario.dto.ErroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import br.com.pedroaragoni.inventario.model.StatusFuncionamento;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> tratarValidacao(
            MethodArgumentNotValidException exception) {

        String mensagem = exception.getBindingResult()
                .getFieldErrors()
                .getFirst()
                .getDefaultMessage();

        ErroResponse erro = new ErroResponse(mensagem);
        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(CategoriaJaCadastradaException.class)
    public ResponseEntity<ErroResponse> tratarCategoriaJaCadastrada(
            CategoriaJaCadastradaException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<ErroResponse> tratarCategoriaNaoEncontrada(
            CategoriaNaoEncontradaException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(FabricanteJaCadastradoException.class)
    public ResponseEntity<ErroResponse> tratarFabricanteJaCadastrado(
            FabricanteJaCadastradoException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(FabricanteNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarFabricanteNaoEncontrado(
            FabricanteNaoEncontradoException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(LocalizacaoJaCadastradaException.class)
    public ResponseEntity<ErroResponse> tratarLocalizacaoJaCadastrada(
            LocalizacaoJaCadastradaException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(LocalizacaoNaoEncontradaException.class)
    public ResponseEntity<ErroResponse> tratarLocalizacaoNaoEncontrada(
            LocalizacaoNaoEncontradaException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ModeloJaCadastradoException.class)
    public ResponseEntity<ErroResponse> tratarModeloJaCadastrado(
            ModeloJaCadastradoException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(ModeloNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarModeloNaoEncontrado(
            ModeloNaoEncontradoException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(EquipamentoJaCadastradoException.class)
    public ResponseEntity<ErroResponse> tratarEquipamentoJaCadastrado(
            EquipamentoJaCadastradoException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(EquipamentoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarEquipamentoNaoEncontrado(
            EquipamentoNaoEncontradoException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(RegistroInativoException.class)
    public ResponseEntity<ErroResponse> tratarRegistroInativo(
            RegistroInativoException exception) {

        ErroResponse erro = new ErroResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> tratarCorpoInvalido(
            HttpMessageNotReadableException exception) {

        ErroResponse erro = new ErroResponse(
                "JSON inválido ou campo com valor incompatível com o tipo esperado");

        return ResponseEntity.badRequest().body(erro);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroResponse> tratarParametroInvalido(
            MethodArgumentTypeMismatchException exception) {

        String mensagem;

        if (exception.getRequiredType() == StatusFuncionamento.class) {
            mensagem = "Estado de funcionamento inválido. Use OK, ATENCAO ou CRITICO";
        } else {
            mensagem = "Valor inválido para o parâmetro: " + exception.getName();
        }

        return ResponseEntity.badRequest()
                .body(new ErroResponse(mensagem));
    }
}
