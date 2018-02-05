
public class Auditorio {

	private int identificacao;
	private String responsavel = "empty";
	private Date dateInicio;
	private Date dateFim;
	private String status = "Livre";
	private String atividade = "nenhuma";
	

	public Auditorio(){

	}

	public Auditorio(int identificacao, String responsavel,
			Date dateInicio, Date dateFim,String status,String atividade) {

	    this.atividade = atividade;
		this.identificacao = identificacao;
		this.responsavel = responsavel;
		this.dateInicio = dateInicio;
		this.dateFim = dateFim;
		this.status = status;
	
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getAtividade() {
        return atividade;
    }

    public String getResponsavel() {
        return responsavel;
    }
}
