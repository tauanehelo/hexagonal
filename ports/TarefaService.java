package ports;

import core.GerenciadorTarefas;
public class TarefaService extends GerenciadorTarefas{
     public TarefaService(TarefaRepository repository){
        super(repository);
     }

}