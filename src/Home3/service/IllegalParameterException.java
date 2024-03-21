package Home3.service;

public class IllegalParameterException extends IllegalArgumentException{
    public IllegalParameterException(String expression) {
        super(String.format("Неверно указано %s", expression));
    }
}
