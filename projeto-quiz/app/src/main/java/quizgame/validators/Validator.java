package quizgame.validators;

public interface Validator<T> {
    boolean validate(T data);    
}