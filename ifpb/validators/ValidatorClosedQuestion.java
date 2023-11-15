package main.java.br.edu.ifpb.validators;

import main.java.br.edu.ifpb.codigoCompleto.Menu;
import main.java.br.edu.ifpb.repository.RepositoryQuestion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validatorClosedQuestion implements Validator<String> {
    private final ClosdQuestion closedQuestion = new closedQuestion(RepositoryQuestion.getInstance());      
    private final boolean checkIfExists;

    public QuestaoValidator(boolean checkIfExists) {
        this.checkIfExists = checkIfExists;
    }

    @Override
    public boolean validate(String alternativa) {
        String questaoPattern = "[a-d]";
        Pattern pattern = Pattern.compile(questaoPattern);
        Matcher matcer = pattern.matcher(alternativa);

        return matcher.matches() && (!checkIfExists || !closedQuestion(alternativa));
    }

}
