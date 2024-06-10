package dev.otthon.sistemaweb.core.exceptions;

public class ClientNotFoundException extends ModelNotFoundException {

    public ClientNotFoundException() {
        super("Cliente não encontrado");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}
