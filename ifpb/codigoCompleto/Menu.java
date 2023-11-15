import java.util.ArrayList;
import java.util.Scanner;

import main.java.br.edu.ifpb.codigoCompleto.Gerenciador;
import main.java.br.edu.ifpb.codigoCompleto.Questao;
import main.java.br.edu.ifpb.validators.validatorClosedQuestion;
import main.java.br.edu.ifpb.validators.ValidatorVFQuestion;
import main.java.br.edu.ifpb.validators.ValidationContext;
import main.java.br.edu.ifpb.validators.EmptyListValidator;

public class Menu {
    private Gerenciador gerenciador = new Gerenciador();
    private Scanner entrada = new Scanner(System.in);

    public int exibirMenuPrincipal() {
        System.out.println("\t\tMENU ");
        System.out.println("| 1- JOGAR            |");
        System.out.println("| 2- CRIAR PERGUNTA   |");
        System.out.println("| 3- EDITAR PERGUNTA  |");
        System.out.println("| 4- EXCLUIR PERGUNTA |");
        System.out.println("| 5- HISTÓRICO        |");
        System.out.println("| 6- SAIR             |");
        System.out.print("Escolha uma das opções acima: ");
        return entrada.nextInt();
    }

    public int exibirMenuCriacaoDeQuestao() {
        System.out.println("ESCOLHA O TIPO DE QUESTÃO QUE DESEJA CRIAR:");
        System.out.println("| 1- PERGUNTA ABERTA              |");
        System.out.println("| 2- PERGUNTA FECHADA             |");
        System.out.println("| 3- PERGUNTA VERDADEIRO OU FALSO |");
        System.out.print("Escolha uma das opções acima: ");
        return entrada.nextInt();
    }

    public void jogar() {
        gerenciador.criarQuiz();
    }

    public void criarQuestaoAberta() {
        System.out.print("Digite o enunciado da pergunta: ");
        entrada.nextLine();
        String pergunta = entrada.nextLine();
        System.out.print("Digite a resposta correta da pergunta: ");
        String resposta = entrada.nextLine();
        gerenciador.criarQuestaoAberta(pergunta, resposta);
    }

    public void criarQuestaoFechada() {
        ArrayList<String> alternativas = new ArrayList<>();
        String pergunta, resposta;
        boolean ehValido;
        entrada.nextLine();
        System.out.print("Digite o enunciado da pergunta de múltipla escolha: ");
        pergunta = entrada.nextLine();
        System.out.print("Digite a primeira alternativa: ");
        alternativas.add("A - " + entrada.nextLine());
        System.out.print("Digite a segunda alternativa: ");
        alternativas.add("B - " + entrada.nextLine());
        System.out.print("Digite a terceira alternativa: ");
        alternativas.add("C - " + entrada.nextLine());
        System.out.print("Digite a quarta alternativa: ");
        alternativas.add("D - " + entrada.nextLine());

        do {
        strValidationContext.setValidator(new QuestaoFechadaValidator(true));
        String questaoFechada = strValidationContext.getValidValue("Alternativa: ", "Alternativa inválida", String.class);
        } while (!ehValido);
        gerenciador.criarQuestaoFechada(pergunta, resposta, alternativas);
    }
    
    public void criarQuestaoVerdadeiroFalso() {
        String pergunta, resposta;
        boolean ehValido;
        entrada.nextLine();
        System.out.print("Digite o enunciado da pergunta de verdadeiro ou falso: ");
        pergunta = entrada.nextLine();

        do {
            System.out.print("Digite a resposta correta (V | F): ");
            resposta = entrada.nextLine();
            strValidationContext.setValidator(new QuestaoVFValidator(true));
            String questaoVF = strValidationContext.getValidValue("Alternativa: ", "ALternativa inválida", String.class);
        } while (!ehValido);
            gerenciador.criarQuestaoVerdadeiroFalso(pergunta, resposta);
    }

    public void mostrarQuestao(Questao questao) {
        System.out.println(questao);
    }

    public void editarQuestao() {
        if (questoes.isEmpty()) {
            System.out.println("Não há perguntas disponíveis.");
            return;
        }
        System.out.println("Escolha a pergunta que deseja editar: ");
    
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar a quebra de linha

        if (escolha > 0 && escolha <= perguntas.size()) {
            System.out.println("Digite o novo enunciado da pergunta:");
            String novoEnunciado = scanner.nextLine();
            perguntas.get(escolha - 1).setEnunciado(novoEnunciado);
            System.out.println("Pergunta editada com sucesso.");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public void excluirPergunta(List<Pergunta> perguntas, Scanner scanner) {
        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas disponíveis para excluir.");
            return;
        }

        System.out.println("Escolha a pergunta que deseja excluir:");

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println((i + 1) + "- " + perguntas.get(i).getEnunciado());
        }

        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= perguntas.size()) {
            perguntas.remove(escolha - 1);
            System.out.println("Pergunta excluída com sucesso.");
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public void historicoDePerguntas(List<Pergunta> perguntas) {
        if (perguntas.isEmpty()) {
            System.out.println("Não há perguntas disponiveis para exibir");
            return;
        }

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println((i + 1) + "- " + perguntas.get(i).getEnunciado());
        }
    }
}
