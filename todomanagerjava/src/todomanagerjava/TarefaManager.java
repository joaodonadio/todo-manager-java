package todomanagerjava;

import java.util.*;

public class TarefaManager implements ITarefaManager {

    private List<Tarefa> tarefas;
    private TarefaArquivoDAO dao;
    private int proximoId = 1;

    public TarefaManager() {
        dao = new TarefaArquivoDAO();
        tarefas = dao.carregar();
        if (!tarefas.isEmpty()) {
            proximoId = tarefas.get(tarefas.size() - 1).getId() + 1;
        }
    }

    @Override
    public void adicionar(String descricao) {
        Tarefa t = new Tarefa(proximoId++, descricao);
        tarefas.add(t);
        dao.salvar(tarefas);
    }

    @Override
    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa t : tarefas) {
                String status = (t.getStatus() == StatusTarefa.CONCLUIDA) ? "✔" : " ";
                System.out.printf("%d - %s [%s]%n", t.getId(), t.getDescricao(), status);
            }
        }
    }

    @Override
    public void concluir(int id) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                t.setStatus(StatusTarefa.CONCLUIDA);
                dao.salvar(tarefas);
                System.out.println("Tarefa concluída!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada.");
    }

    @Override
    public void remover(int id) {
        boolean removido = tarefas.removeIf(t -> t.getId() == id);
        if (removido) {
            dao.salvar(tarefas);
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }
}
