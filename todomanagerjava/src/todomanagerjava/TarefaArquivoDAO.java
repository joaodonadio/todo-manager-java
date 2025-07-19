package todomanagerjava;

import java.io.*;
import java.util.*;

public class TarefaArquivoDAO {

    private static final String ARQUIVO = "tarefas.txt";

    public List<Tarefa> carregar() {
        List<Tarefa> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lista.add(Tarefa.fromString(linha));
            }
        } catch (IOException e) {
            System.out.println("Arquivo ainda não existe.");
        }
        return lista;
    }

    public void salvar(List<Tarefa> tarefas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Tarefa t : tarefas) {
                bw.write(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
