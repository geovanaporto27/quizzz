package main.java.br.edu.ifpb.validators;

public interface Validator<T> {
    boolean validate(T data);    
}
