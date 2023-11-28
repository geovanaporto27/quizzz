package quizgame.GUI;

import quizgame.menu.Pergunta;
import quizgame.repository.FileService;
import quizgame.repository.PerguntasRepository;
import quizgame.repository.ArmazenamentoDePerguntas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quiz Game Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.getContentPane().add(panel);
            placeComponents(panel);

            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Nome do jogador(a):");
        nameLabel.setBounds(10, 20, 150, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(160, 20, 150, 25);
        panel.add(nameText);

        JButton playButton = new JButton("JOGAR");
        playButton.setBounds(10, 60, 80, 25);
        panel.add(playButton);

        JButton createButton = new JButton("CRIAR PERGUNTA");
        createButton.setBounds(100, 60, 150, 25);
        panel.add(createButton);

        JButton exitButton = new JButton("SAIR");
        exitButton.setBounds(260, 60, 80, 25);
        panel.add(exitButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(10, 100, 330, 100);
        panel.add(outputArea);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = nameText.getText();
                outputArea.setText("Olá " + playerName + ", vamos começar!\n");
                // Adicione o código relevante para a opção "JOGAR"
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione o código relevante para a opção "CRIAR PERGUNTA"
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
