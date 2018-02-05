import java.util.ArrayList;

public class Solicitacoes {


    private String recurso;
    private String usuario;
    private String atividade;
    private Date inicio,fim;

    public Solicitacoes(String recurso,String usuario,String atividade, Date inicio, Date fim){
        this.usuario = usuario;
        this.atividade = atividade;
        this.inicio = inicio;
        this.fim = fim;
        this.recurso = recurso;
    }
    public Solicitacoes(){

    }

    public String getAtividade() {
        return atividade;
    }

    public String getRecurso() {
        return recurso;
    }

    public String getUsuario() {
        return usuario;
    }

    public Date getFim() {
        return fim;
    }

    public Date getInicio() {
        return inicio;
    }
}
