package quizgame.gerenciador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import quizgame.exception.ListaVaziaException;
import quizgame.menu.Alternativa;
import quizgame.menu.GeradorAleatorio;
import quizgame.menu.HistoricoDeJogadas;
import quizgame.menu.Pergunta;
import quizgame.menu.Timer;

public class GerenciadorPergunta {

    private String nomeJogador;
    private int placar;
    private Timer timerPergunta;
    private List<Integer> historicoPontuacoes = new ArrayList<>();
    private List<Pergunta> perguntas;

    public GerenciadorPergunta(String nomeJogador, List<Pergunta> perguntas) {
        this.nomeJogador = nomeJogador;
        this.placar = 0;
        this.timerPergunta = new Timer();
        this.perguntas = perguntas;
    }

    public void jogar() {
        Scanner li = new Scanner(System.in);

        try {
            for (int i = 0; i < 5; i++) {
                Pergunta pergunta = GeradorAleatorio.selecionarPerguntaAleatoria(perguntas);

                System.out.println("Pergunta " + (i + 1) + ": " + pergunta.getTitulo());
                System.out.println("Timer iniciado, você tem 60 segundos para responder!");
                System.out.println();

                List<Alternativa> alternativas = pergunta.getAlternativas();
                for (Alternativa alternativa : alternativas) {
                    System.out.println(alternativa.getOpcao() + ". " + alternativa.getAfirmativa());
                }

                timerPergunta.iniciarTimer(60, () -> {
                    System.out.println("Tempo esgotado! Pressione Enter para continuar ");
                });

                System.out.print("Escolha a opção correta: ");
                String respostaUsuario = li.nextLine();

                timerPergunta.cancelarTimer();

                if (timerPergunta.isTempoEsgotado()) {
                } else if (pergunta.verificarResposta(respostaUsuario)) {
                    System.out.println("Resposta correta!");
                    System.out.println();
                    placar++;
                } else {
                    System.out.println("Resposta incorreta. A resposta correta é: " + pergunta.obterRespostaCorreta());
                    System.out.println();
                }

                Thread.sleep(1500);
            }

            historicoPontuacoes.add(placar);

            HistoricoDeJogadas.exibirPontuacaoFinal(nomeJogador, placar);

        } catch (InterruptedException | ListaVaziaException e) {
            System.out.println("Não há perguntas disponíveis. Adicione perguntas antes de jogar.");
        }
    }

    public void exibirHistorico() {
        HistoricoDeJogadas.exibirHistorico(nomeJogador, historicoPontuacoes);
    }

    public List<Integer> getHistoricoPontuacoes() {
        return historicoPontuacoes;
    }

    public void criarPergunta() {
        System.out.println();
        System.out.println("Insira o título da pergunta: ");
        String titulo = System.console().readLine();
        System.out.println();

        Pergunta pergunta = new Pergunta(titulo, titulo);

        String opcao, afirmativa;
        boolean opcaoCorreta;

        for (int i = 1; i <= 4; i++) {
            System.out.println();
            System.out.println("Insira a opção da pergunta " + i + ": ");
            opcao = System.console().readLine();
            System.out.println("Insira a afirmativa para a opção " + i + ": ");
            afirmativa = System.console().readLine();
            System.out.print("Essa é a opção correta? (true/false): ");

            opcaoCorreta = Boolean.parseBoolean(System.console().readLine());

            Alternativa alternativa = new Alternativa(opcao, afirmativa, opcaoCorreta);
            pergunta.adicionarAlternativa(alternativa);
        }

        perguntas.add(pergunta);
    }

    public void listarPerguntas() throws ListaVaziaException {
        if (perguntas.isEmpty()) {
            throw new ListaVaziaException("Não há perguntas para listar.");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Digite o número da opção desejada: ");
        System.out.println();

        int escolha = sc.nextInt();

        if (escolha == 1) {
            listarPerguntasComRespostas();
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void listarPerguntasComRespostas() {
        System.out.println("Lista de Perguntas:");
        for (Pergunta pergunta : perguntas) {
            System.out.println("Título: " + pergunta.getTitulo());
            System.out.println("Alternativas:");
            for (Alternativa alternativa : pergunta.getAlternativas()) {
                System.out.println("Opção: " + alternativa.getOpcao());
                System.out.println("Afirmativa: " + alternativa.getAfirmativa());
                System.out.println("Opção Correta: " + alternativa.isOpcaoCorreta());
            }
            System.out.println();
        }
    }

    public void apagarPergunta() throws ListaVaziaException {

        if (perguntas.isEmpty()) {
            throw new ListaVaziaException("Não há perguntas para apagar.");
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Perguntas disponíveis para apagar:");
        System.out.println();

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(i + ". Título: " + perguntas.get(i).getTitulo());
        }

        System.out.println();
        System.out.println("Digite o número da pergunta que deseja apagar: ");
        int escolha = scanner.nextInt();

        if (escolha >= 0 && escolha < perguntas.size()) {
            perguntas.remove(escolha);
            System.out.println();
            System.out.println("Pergunta apagada com sucesso.");
            scanner.nextLine();
        } else {
            System.out.println();
            System.out.println("Escolha inválida. A pergunta não foi apagada.");
            scanner.nextLine();
        }
    }

    public void editarPergunta() throws ListaVaziaException {
        if (perguntas.isEmpty()) {
            throw new ListaVaziaException("Não há perguntas para editar.");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println();

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(i + ". Título: " + perguntas.get(i).getTitulo());
        }

        System.out.println();
        System.out.print("Digite o número da pergunta que deseja editar: ");
        int escolhaEdit = sc.nextInt();

        if (escolhaEdit >= 0 && escolhaEdit < perguntas.size()) {
            sc.nextLine();
            System.out.println();
            System.out.print("Digite o novo título (ou Enter para pular): ");
            String novoTitulo = sc.nextLine();

            if (!novoTitulo.trim().isEmpty()) {
                perguntas.get(escolhaEdit).setTitulo(novoTitulo);
            }

            List<Alternativa> alternativas = perguntas.get(escolhaEdit).getAlternativas();

            for (int i = 0; i < alternativas.size(); i++) {
                System.out.println();
                Alternativa alternativa = alternativas.get(i);
                System.out.println("Editar Alternativa " + (i + 1));

                System.out.print("Nova opção (ou Enter para pular): ");
                String novaOpcao = sc.nextLine();
                if (!novaOpcao.trim().isEmpty()) {
                    alternativa.setOpcao(novaOpcao);
                }

                System.out.print("Nova afirmativa (ou Enter para pular): ");
                String novaAfirmativa = sc.nextLine();
                if (!novaAfirmativa.trim().isEmpty()) {
                    alternativa.setAfirmativa(novaAfirmativa);
                }

                System.out.print("É a opção correta? (true/false) (ou Enter para pular): ");
                String respostaCorreta = sc.nextLine();
                if (!respostaCorreta.trim().isEmpty()) {
                    boolean novaOpcaoCorreta = Boolean.parseBoolean(respostaCorreta);
                    alternativa.setOpcaoCorreta(novaOpcaoCorreta);
                }
            }

            System.out.println("Pergunta editada com sucesso.");
        } else {
            System.out.println("Escolha inválida. A pergunta não foi editada.");
        }
    }
}
