package main.java.br.edu.ifpb;

import br.edu.ifpb.repository.FileDataService;
import br.edu.ifpb.repository.QuestaoRepository;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Gerenciador gerenciador = new Gerenciador();
        int opSelecionada = 0;

        while (opSelecionada != 6) {
            opSelecionada = menu.exibirMenuPrincipal();
            switch (opSelecionada) {
                case 1:
                    menu.mostrarQuestao(gerenciador.getQuestaoAleatoria());
                    break;
                case 2:
                    switch (menu.exibirMenuCriacaoDeQuestao()) {
                        case 1:
                            menu.criarQuestaoAberta();
                            break;
                        case 2:
                            menu.criarQuestaoFechada();
                            break;
                        case 3:
                            menu.criarQuestaoVerdadeiroFalso();
                            break;
                    }
                    break;
                case 3:
                    menu.editarQuestao();
                    break;
                case 4:
                    menu.excluirPergunta();
                    break;
                case 5:
                    System.exit(0);
                    default:
                    System.out.println("Escolha inválida!");
                    break;
            }
        }

    }
}
