package quizgame.menu;

import java.util.Scanner;

import quizgame.exception.ListaVaziaException;
import quizgame.gerenciador.GerenciadorPergunta;
import quizgame.repository.ArmazenamentoDePerguntas;

public class Menu {

    public static void main(String[] args) throws InterruptedException {
        Scanner name = new Scanner(System.in);
        System.out.print("Nome do jogador(a): ");
        String nomeJogador = name.nextLine();

        GerenciadorPergunta gerenciador = new GerenciadorPergunta(nomeJogador, ArmazenamentoDePerguntas.getPerguntas());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println(" MENU ");
            System.out.println();
            System.out.println("1- JOGAR");
            System.out.println("2- CRIAR PERGUNTA");
            System.out.println("3- EXCLUIR PERGUNTA");
            System.out.println("4- EDITAR PERGUNTA");
            System.out.println("5- EXIBIR PERGUNTA");
            System.out.println("6- SAIR");
            System.out.println("7- HISTÓRICO DE JOGOS");
            System.out.println();

            try {
                int escolha = scanner.nextInt();
                scanner.nextLine();

                if (escolha < 1 || escolha > 7) {
                    System.out.println();
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }

                switch (escolha) {
                    case 1:
                        System.out.println();
                        System.out.println("Olá" + nomeJogador + ", vamos começar!");
                        System.out.println();
                        gerenciador.jogar();
                        break;
                    case 2:
                        gerenciador.criarPergunta();
                        break;
                    case 3:
                        try {
                            gerenciador.apagarPergunta();
                        } catch (ListaVaziaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            gerenciador.editarPergunta();
                        } catch (ListaVaziaException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            gerenciador.listarPerguntas();
                        } catch (ListaVaziaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("Encerrando o programa.");
                        System.out.println();
                        System.exit(0);
                        break;
                    case 7:
                        HistoricoDeJogadas.exibirHistorico(nomeJogador, gerenciador.getHistoricoPontuacoes());
                        break;
                
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println();
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
    }
}