package main.java.br.edu.ifpb.codigoCompleto;

import java.util.TimerTask;

public class Timer {
    private int tempoLimite;
    private boolean tempoEsgotado;

    public Timer(int tempoLimite) {
        this.tempoLimite = tempoLimite;
        tempoEsgotado = false;
    }

    public void iniciarTemporizador() {
        Timer timer = new Timer(tempoLimite);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tempoEsgotado = true;
                System.out.println("Tempo esgotado! Sua resposta não foi registrada.");
                timer.cancel();
            }
        }, tempoLimite * 1000); // Converte segundos para milissegundos
    }

    private void schedule(TimerTask timerTask, int i) {
    }

    protected void cancel() {
    }

    public boolean tempoEsgotado() {
        return tempoEsgotado;
    }
}