import java.util.Scanner;

public class Usuario {

    private int identificacao;
    private String nome;
    private String tipo;
    private String senha;
    private String code;
    private String email;
    private String recursoAssociado = "nenhum";
    private String[] recursosAlocados = new String[100];
    private String[] atividadesRealizadas = new String[100];

    Scanner input = new Scanner(System.in);

    public Usuario(int identificacao,String nome,String tipo,String email, String senha){

        if(tipo.intern() == "Administrador"){
            System.out.print("Digite o codigo de administrador: ");
            String code_aux = input.nextLine();
            if(code_aux.intern() != "1234")
                System.out.println("Codigo inválido!");
            else{
                this.identificacao = identificacao;
                this.nome = nome;
                this.tipo = tipo;
                this.senha = senha;
                this.email = email;
            }
        }
        else{
            this.identificacao = identificacao;
            this.nome = nome;
            this.tipo = tipo;
            this.senha = senha;
            this.email = email;
        }

        System.out.println("It's Done!");


    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAtividadesRealizadas(String atividadesRealizadas) {

        for(int i = 0; i < this.atividadesRealizadas.length; ++i)
            if(this.atividadesRealizadas[i] == null){
                this.atividadesRealizadas[i] = atividadesRealizadas;
                break;
            }

    }

    public void setRecursosAlocados(String[] recursosAlocados) {
        this.recursosAlocados = recursosAlocados;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public String getSenha(){
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void getRecursosAlocados(Usuario atual) {
        for(int i = 0; i < atual.recursosAlocados.length; ++i)
            if(atual.recursosAlocados[i] != null)
                System.out.println(atual.recursosAlocados[i]);
            else break;


    }

    public String[] getAtividadesRealizadas() {
        return atividadesRealizadas;
    }

    public void addRecursosHistorico(Usuario usuarioAtual,String recurso){

        for(int i = 0; i < usuarioAtual.recursosAlocados.length; ++i){
            if(usuarioAtual.recursosAlocados[i] == null){
                usuarioAtual.recursosAlocados[i] = recurso;
                break;
            }
        }

    }

    public String getRecursoAssociado() {
        return recursoAssociado;
    }

    public void setRecursoAssociado(String recursoAssociado) {
        this.recursoAssociado = recursoAssociado;
    }
}
