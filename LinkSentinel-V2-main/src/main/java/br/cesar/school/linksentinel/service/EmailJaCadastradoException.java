package br.cesar.school.linksentinel.service; // Ou o pacote de exceções

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(String message) {
        super(message);
    }
}