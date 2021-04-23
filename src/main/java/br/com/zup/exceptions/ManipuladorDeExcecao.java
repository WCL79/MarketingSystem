package br.com.zup.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExcecao extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjetoDeErro> objetoDeErros = getErros(ex);
        RespostaDeErro respostaDeErro = new RespostaDeErro("Validação", status.value(),
                status.getReasonPhrase(), objetoDeErros);
        return ResponseEntity.status(status).body(respostaDeErro);
    }

    private List<ObjetoDeErro> getErros(MethodArgumentNotValidException ex) {
        List<ObjetoDeErro> objetosDeErro = ex.getBindingResult().getFieldErrors()
                .stream().map(error -> new ObjetoDeErro(error.getDefaultMessage(), error.getField()))
                .collect(Collectors.toList());
        return objetosDeErro;
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaDeErro manipularRuntimeException(RuntimeException ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                null
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(
                null,
                400,
                "BAD REQUEST",
                Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

    @ExceptionHandler({EmailDuplicadoExcecao.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro emailDuplicadoExcecao(EmailDuplicadoExcecao excecao) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                excecao.getMessage(),
                excecao.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(excecao.getTipoErro(),
                excecao.getStatus(),
                excecao.getRazao(),
                Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }
    @ExceptionHandler({ProdutoExistenteException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro produtoExistente(ProdutoExistenteException ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                ex.getCampo());

        RespostaDeErro respostaDeErro = new RespostaDeErro(
                ex.getTipoErro(),
                ex.getStatus(),
                ex.getRazao(),
                Arrays.asList(objetoDeErro));

        return respostaDeErro;
    }
}