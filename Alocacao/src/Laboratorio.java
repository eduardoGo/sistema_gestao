
public class Laboratorio {

	private int identificacao;
	private String responsavel = "empty";
	private Date dateInicio;
	private Date dateFim;
	private String status = "Livre";
    private String atividade = "nenhuma";

	public Laboratorio(){

	}


	public Laboratorio(int identificacao, String responsavel,
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

    public String getResponsavel() {
        return responsavel;
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
}
