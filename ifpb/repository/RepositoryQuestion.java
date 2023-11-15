package main.java.br.edu.ifpb.repository;

import br.edu.ifpb.Quiz;
import br.edu.ifpb.repository.DataService;

import java.util.List;

public class RepositoryQuestion {
    private DataService dataService;
    private static RepositoryQuestion instance;

    private RepositoryQuestion(DataService dataService) {
        this.dataService = dataService;
    }

    public static RepositoryQuestion getInstance() {
        if(instance == null) {
            instance = new RepositoryQuestion(new InMemoryDataService());
        }

        return instance;
    }

    public void setRepository(DataService dataService) {
        this.dataService = dataService;
    }

    public void add(Questao q) {
        dataService.add(q);
    }

    public List<Questao> getAll() {
        return dataService.getAll();
    }

    public List<Questao> search(String termo) {
        return dataService.search(termo);
    }

    public boolean existis(String questao) {
        return dataService.existis(questao);
    }

    public void remove(Questao q) {
        dataService.remove(q);
    }
}
