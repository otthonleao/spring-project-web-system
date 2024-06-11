package dev.otthon.sistemaweb.core.exceptions;

public class EmployeeNotFoundException extends ModelNotFoundException {
    // Mensagem padrão
    public EmployeeNotFoundException() {
        super("Funcionário não encontrado");
    }

    // Para receber mensagem personalizada
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
