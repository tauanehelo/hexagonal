package core;

public class Tarefa {
    private String id;
    private String descricao;
    private boolean concluida;

    public Tarefa(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getId() { return id; }
    public String getDescricao() { return descricao; }
    public boolean isConcluida() { return concluida; }
    public void marcarComoConcluida() { this.concluida = true; }
}