package quizgame.repository;

import java.io.*;
import java.util.List;

import quizgame.menu.Pergunta;

public class FileService extends InMemory {
    private List<Pergunta> perguntas;

    public FileService() {
        File data = new File("data.bin");
        if(data.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
                perguntas = (List<Pergunta>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    @Override
    public void add(Pergunta q) {
        super.add(q);
        write();
    }

    // @Override
    // public Pergunta get(int indice) {
    //     return perguntas.get(indice);

    // }

    // @Override
    // public int getTamanho() {
    //     return perguntas.size();    
    // }

    private void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(getPerguntas());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
