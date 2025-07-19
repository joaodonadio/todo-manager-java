package todomanagerjava;

public class Tarefa {
    private int id;
    private String descricao;
    private StatusTarefa status;

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + status;
    }

    public static Tarefa fromString(String linha) {
        String[] partes = linha.split(";");
        Tarefa t = new Tarefa(Integer.parseInt(partes[0]), partes[1]);
        t.setStatus(StatusTarefa.valueOf(partes[2]));
        return t;
    }
}
