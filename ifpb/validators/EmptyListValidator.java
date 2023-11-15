package main.java.br.edu.ifpb.validators;

public class EmptyListValidator implements Validator<String> {
    @Override
    public boolean validate(String data) {
        return !data.equals("");
    }
}