package br.com.ricmrs.biblioteca.infra.exception;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem){ super(mensagem); }
}
