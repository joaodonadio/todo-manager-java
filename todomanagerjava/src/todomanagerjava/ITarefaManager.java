package todomanagerjava;

public interface ITarefaManager {
    void adicionar(String descricao);
    void listar();
    void concluir(int id);
    void remover(int id);
}
