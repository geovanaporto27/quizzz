package quizgame.menu;

import java.util.TimerTask;

public class Timer {
    private Timer timer; // Objeto da classe Timer para controlar o tempo
    private boolean tempoEsgotado; // Indica se o tempo do timer foi esgotado

    // Método para iniciar o timer com a duração especificada em segundos
    public void iniciarTimer(int segundos, Runnable onTempoEsgotado) {
        tempoEsgotado = false; // Reinicia o indicador de tempo esgotado
        timer = new Timer(); // Cria uma nova instância de Timer

        // Agendamento da tarefa a ser executada quando o tempo se esgotar
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tempoEsgotado = true; // Marca o tempo como esgotado
                onTempoEsgotado.run(); // Executa a ação definida quando o tempo se esgota
                cancelarTimer(); // Cancela o timer após a execução da ação
            }
        }, segundos * 1000); // Converte segundos para milissegundos e define o atraso
    }

    private void schedule(TimerTask timerTask, int i) {
    }

    public boolean isTempoEsgotado() {
        return tempoEsgotado;
    }

    // Método para cancelar o timer
    public void cancelarTimer() {
        if (timer != null) {
            timer.cancel(); // Cancela o timer
            timer.purge(); // Limpa a fila de tarefas do timer
        }
    }

    private void purge() {
    }

    private void cancel() {
    }
}
