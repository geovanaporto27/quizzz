package quizgame.GUI;

import javax.swing.*;

import quizgame.menu.Alternativa;
import quizgame.menu.Pergunta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PerguntaGUI {
    private JFrame frame;
    private JTextField tituloField;
    private JTextField areaConhecimentoField;
    private JTextArea alternativasArea;

    private List<Alternativa> alternativasList;

    public PerguntaGUI() {
        alternativasList = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Cadastro de Pergunta");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblTitulo = new JLabel("Título da Pergunta:");
        panel.add(lblTitulo);

        tituloField = new JTextField();
        panel.add(tituloField);

        JLabel lblAreaConhecimento = new JLabel("Área do Conhecimento:");
        panel.add(lblAreaConhecimento);

        areaConhecimentoField = new JTextField();
        panel.add(areaConhecimentoField);

        JLabel lblAlternativas = new JLabel("Alternativas:");
        panel.add(lblAlternativas);

        alternativasArea = new JTextArea();
        panel.add(alternativasArea);

        JButton btnAdicionarAlternativa = new JButton("Adicionar Alternativa");
        btnAdicionarAlternativa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarAlternativa();
            }
        });
        panel.add(btnAdicionarAlternativa);

        JButton btnSalvar = new JButton("Salvar Pergunta");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarPergunta();
            }
        });
        panel.add(btnSalvar);

        frame.setVisible(true);
    }

    private void adicionarAlternativa() {
        String alternativa = JOptionPane.showInputDialog(frame, "Digite a alternativa:");
        if (alternativa != null) {
            Alternativa novaAlternativa = new Alternativa(alternativa, false);
            alternativasList.add(novaAlternativa);
            alternativasArea.append(novaAlternativa.getOpcao() + ". " + novaAlternativa.getAfirmativa() + "\n");
        }
    }

    private void salvarPergunta() {
        String titulo = tituloField.getText();
        String areaConhecimento = areaConhecimentoField.getText();

        if (titulo.isEmpty() || areaConhecimento.isEmpty() || alternativasList.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Preencha todos os campos antes de salvar.");
        } else {
            Pergunta pergunta = new Pergunta(titulo, areaConhecimento);
            pergunta.setAlternativas(alternativasList);
            // Adicione o código para salvar a pergunta no repositório ou realizar outras ações necessárias.
            JOptionPane.showMessageDialog(frame, "Pergunta salva com sucesso!");
            limparCampos();
        }
    }

    private void limparCampos() {
        tituloField.setText("");
        areaConhecimentoField.setText("");
        alternativasArea.setText("");
        alternativasList.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PerguntaGUI();
        });
    }
}

