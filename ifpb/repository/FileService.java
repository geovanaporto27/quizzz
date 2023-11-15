package main.java.br.edu.ifpb.repository;
import br.edu.ifpb.Quiz;
import main.java.br.edu.ifpb.codigoCompleto.Questao;

import java.io.*;
import java.util.List;

public class FileService implements DataService {
    public FileService() {
        File data = new File("data.bin");
        if(data.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
                pacientes = (List<Paciente>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Questao q) {
        super.add(q);
        write();
    }

    @Override
    public Questao get(int indice) {
        return questoes.get(indice);

    }

    @Override
    public int getTamanho() {
        return questoes.size();    
    }

    private void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(getAll());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

