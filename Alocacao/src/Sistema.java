
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class Sistema {





    public static void menu(ArrayList<Usuario> usuarios,boolean verificaLogin, Usuario usuarioLogado){

        int opcao;
        int opcaoAtividade;
        int opcaoAlocar;
        ArrayList<Solicitacoes> solicitacoes = new ArrayList<Solicitacoes>();
        Auditorio auditorio1 = new Auditorio(),auditorio2 = new Auditorio();
        Laboratorio laboratorio1 = new Laboratorio(),laboratorio2 = new Laboratorio();
        Projetor projetor1 = new Projetor(),projetor2 = new Projetor();
        Sala sala1 = new Sala(),sala2 = new Sala(),sala3 = new Sala();

        Scanner input = new Scanner(System.in);


        System.out.printf("Olá =)%n");

        while(true) {

            System.out.println("=============================");
            System.out.println("Selecione a opção que deseja:");
            System.out.printf("[1] Usuarios cadastrados%n[2] Cadastrar usuario%n" +
                    "[3] Solicitar alocação de recurso%n[4] Encerrar sistema%n[5] Fazer login%n[6] Encerrar seção%n" +
                    "[7] Consultar usuario%n[8] Consultar recurso%n" +
                    "[9] Relatório academico%n[10] Ver solicitações%n");
            System.out.println("=============================");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    for (Usuario auxiliar : usuarios)
                        System.out.printf("%s - %s%n", auxiliar.getNome(), auxiliar.getTipo());
                    break;
                case 2:
                    if (verificaLogin)
                        System.out.println("Você está logado! Encerre sua seção antes de cadastrar!");
                    else{
                        System.out.printf("Digite:%n[Identificação] (Numero inteiro)%n[Nome]%n[Tipo]%n[Email]%n[Senha]%n");
                        int identificacao = input.nextInt();
                        String nome = input.next();
                        String tipo = input.next();
                        String email = input.next();
                        String senha = input.next();

                        Usuario novoUsuario = new Usuario(identificacao,nome,tipo,email,senha);

                        usuarios.add(novoUsuario);

                    }
                    break;
                case 3:
                    if(verificaLogin){
                        if(usuarioLogado.getTipo().intern() == "Professor" &&
                                usuarioLogado.getRecursoAssociado().intern() == "nenhum"){


                            System.out.println("Selecione qual tipo de atividade deseja realizar:");
                            System.out.printf("[1] Aula tradicional%n[2] Apresentação%n[3] Laboratorio%n");
                            opcaoAtividade = input.nextInt();
                            String atividade;
                            if(opcaoAtividade == 1)
                                atividade = "Aula tradicional";
                            else if(opcaoAtividade == 2)
                                atividade = "Apresentacao";
                            else if(opcaoAtividade == 3)
                                atividade = "Laboratorio";
                            else{
                                System.out.println("Opção inválida!");
                                break;
                            }

                            System.out.println("Selecione o recurso que deseja alocar:");
                            if(auditorio1.getStatus().intern() == "Livre" || auditorio2.getStatus().intern() == "Livre")
                                System.out.println("[1] Auditório");
                            if(laboratorio1.getStatus().intern() == "Livre" || laboratorio2.getStatus().intern() == "Livre")
                                System.out.println("[2] Laboratorio");
                            if(projetor1.getStatus().intern() == "Livre" || projetor2.getStatus().intern() == "Livre")
                                System.out.println("[3] Projetor");
                            if(sala1.getStatus().intern() == "Livre" || sala2.getStatus().intern() == "Livre" ||
                                    sala3.getStatus().intern() == "Livre")
                                System.out.println("[4] Sala de aula");

                            opcaoAlocar = input.nextInt();
                            System.out.println("Digite a data que deseja alocar o recurso:");
                            System.out.print("[MÊS] [DIA] [ANO] inicio:");
                            Date inicioData = new Date(input.nextInt(),input.nextInt(),input.nextInt());
                            System.out.print("[MÊS] [DIA] [ANO] fim:");
                            Date fimData = new Date(input.nextInt(),input.nextInt(),input.nextInt());
                            Solicitacoes novaSolicitacao = new Solicitacoes();
                            switch (opcaoAlocar){
                                case 1:
                                    novaSolicitacao = new Solicitacoes("Auditorio",usuarioLogado.getNome(),atividade,
                                            inicioData,fimData);
                                    break;
                                case 2:
                                    novaSolicitacao = new Solicitacoes("Laboratorio",usuarioLogado.getNome(),atividade,
                                            inicioData,fimData);
                                    break;
                                case 3:
                                    novaSolicitacao = new Solicitacoes("Projetor",usuarioLogado.getNome(),atividade,
                                            inicioData,fimData);
                                    break;
                                case 4:
                                    novaSolicitacao = new Solicitacoes("Sala de aula",usuarioLogado.getNome(),atividade,
                                            inicioData,fimData);
                                    break;

                            }

                            solicitacoes.add(novaSolicitacao);
                            System.out.println("Solicitação feita!");

                        }
                        else System.out.println("Você não tem autorização ou já tem um recurso associado!");



                    }
                    else{
                        System.out.println("Você não está logado! Inicie sua seção para alocar algum recurso");
                    }
                    break;
                case 4:
                    return;
                case 5:
                    System.out.printf("%nUsuario: ");
                    String usuarioAtual = input.next();
                    System.out.printf("Senha: ");
                    String senhaAtual = input.next();
                    for(Usuario auxiliar : usuarios){
                        if((auxiliar.getNome()).intern() == usuarioAtual.intern())
                            if((auxiliar.getSenha()).intern() == senhaAtual.intern()){
                                verificaLogin = true;
                                usuarioLogado = new Usuario(auxiliar.getIdentificacao(),auxiliar.getNome(),
                                        auxiliar.getTipo(),auxiliar.getEmail(),auxiliar.getSenha());
                                System.out.println("Pronto! Você está logado!");
                                break;
                            }
                            else{
                                System.out.println("Senha incorreta!");
                                break;
                            }

                    }
                    break;
                case 6:
                    verificaLogin = false;
                    System.out.println("Seção encerrada!");
                    break;

                case 7:
                    System.out.println("Digite o nome do usuario que deseja consultar: ");
                    String usuarioAux = input.next();
                    for(Usuario auxiliar : usuarios){
                        if(auxiliar.getNome().intern() == usuarioAux.intern())
                        {
                            System.out.printf("Nome: %s%nEmail: %s%n", auxiliar.getNome(),auxiliar.getEmail());
                            auxiliar.getRecursosAlocados(auxiliar);
                            break;
                        }
                    }
                    break;

                case 8:
                    int opcaoRecurso;
                    System.out.printf("Selecione qual recurso deseja consultar:%n[1] Auditorio%n[2] Laboratorio%n" +
                            "[3] Projetor%n[4] Sala de aula");

                    opcaoRecurso = input.nextInt();
                    if (opcaoRecurso == 1){
                        if(auditorio1.getResponsavel() == "empty")
                            System.out.println("Auditório 1 não está alocado");
                        else
                            System.out.printf("Auditório 1:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ",auditorio1.getResponsavel(),auditorio1.getAtividade());
                        if(auditorio2.getResponsavel() == "empty")
                            System.out.println("Auditório 2 não está alocado");
                        else
                            System.out.printf("Auditório 2:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ",auditorio2.getResponsavel(),auditorio2.getAtividade());
                    }
                    else if (opcaoRecurso ==2) {
                        if (laboratorio1.getResponsavel() == "empty")
                            System.out.println("Laboratorio 1 não está alocado");
                        else
                            System.out.printf("Laboratorio 1:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ", laboratorio1.getResponsavel(), laboratorio1.getAtividade());
                        if (laboratorio2.getResponsavel() == "empty")
                            System.out.println("Laboratorio 2 não está alocado");
                        else
                            System.out.printf("Laboratorio 2:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ", laboratorio2.getResponsavel(), laboratorio2.getAtividade());
                    }
                    else if (opcaoRecurso == 3) {
                        if (projetor1.getResponsavel() == "empty")
                            System.out.println("Projetor 1 não está alocado");
                        else
                            System.out.printf("Projetor 1:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ", projetor1.getResponsavel(), projetor1.getAtividade());
                        if (projetor2.getResponsavel() == "empty")
                            System.out.println("Projetor 2 não está alocado");
                        else
                            System.out.printf("Projetor 2:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ", projetor2.getResponsavel(), projetor2.getAtividade());
                    }
                    else if (opcaoRecurso == 4) {
                        if (sala1.getResponsavel() == "empty")
                            System.out.println("Sala 1 não está alocado");
                        else
                            System.out.printf("Sala 1:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ", sala1.getResponsavel(), sala1.getAtividade());
                        if (sala2.getResponsavel() == "empty")
                            System.out.println("Sala 2 não está alocado");
                        else
                            System.out.printf("Sala 2:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ", sala2.getResponsavel(), sala2.getAtividade());
                        if (sala3.getResponsavel() == "empty")
                            System.out.println("Sala 3 não está alocado");
                        else
                            System.out.printf("Sala 3:%n - Responsavel: %s%n" +
                                    " - Atividade: %s ", sala3.getResponsavel(), sala3.getAtividade());
                    }
                    break;
                case 9:
                    int countRecursosLivres=0,countRecursosAlocados=0;
                    int atividadeAula=0,atividadeApresentacao=0,atividadeLaboratorio=0;

                    if(auditorio1.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else{
                        if(auditorio1.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if(auditorio1.getAtividade() == "Apresentacao")
                               atividadeApresentacao++;
                        else if(auditorio1.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;
                    }
                    if(auditorio2.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else {
                        if (auditorio2.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if (auditorio2.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if (auditorio2.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;
                    }
                    if(laboratorio1.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else{
                        if(laboratorio1.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if(laboratorio1.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if(laboratorio1.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;

                    }
                    if(laboratorio2.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else {
                        if (laboratorio2.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if (laboratorio2.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if (laboratorio2.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;
                    }
                    if(projetor1.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else {
                        if (projetor1.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if (projetor1.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if (projetor1.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;

                        countRecursosAlocados++;
                    }
                    if(projetor2.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else {
                        if (projetor2.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if (projetor2.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if (projetor2.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;
                    }
                    if(sala1.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else {
                        if (sala1.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if (sala1.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if (sala1.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;
                    }
                    if(sala2.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else {
                        if (sala2.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if (sala2.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if (sala2.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;
                    }
                    if(sala3.getStatus().intern() == "Livre")
                        countRecursosLivres++;
                    else {
                        if (sala3.getAtividade() == "Aula tradicional")
                            atividadeAula++;
                        else if (sala3.getAtividade() == "Apresentacao")
                            atividadeApresentacao++;
                        else if (sala3.getAtividade() == "Laboratorio")
                            atividadeLaboratorio++;
                        countRecursosAlocados++;
                    }

                    System.out.printf("Usuarios cadastrados: [%d]%nNumero de recursos alocados: [%d]%n" +
                                    "Numero de recursos livre: [%d]%nAtividade Aula tradicional: [%d]%n" +
                                    "Atividade Laboratorio: [%d]%nAtividade Apresentação: [%d]%n", usuarios.size(),
                            countRecursosAlocados,countRecursosLivres,atividadeAula,atividadeLaboratorio,
                            atividadeApresentacao);

                    countRecursosAlocados = countRecursosLivres = atividadeApresentacao = 0;
                    atividadeAula = atividadeLaboratorio = 0;
                    break;
                case 10:
                    if(verificaLogin && (usuarioLogado.getTipo().intern() == "Administrador"))
                    {

                        int i = 0;
                        int autorizacao;
                        for(Solicitacoes auxiliar : solicitacoes){
                            System.out.printf("[%d] [%s] Solicitado por [%s] para [%s] de [%s] até [%s]%n",i,
                                    auxiliar.getRecurso(),auxiliar.getUsuario(),auxiliar.getAtividade(),
                                    auxiliar.getInicio(),auxiliar.getFim());
                            System.out.println("Digite 1 para autorizar e 2 para recusar");
                            autorizacao = input.nextInt();
                            if(autorizacao == 1){
                                for(Usuario auxiliar1 : usuarios){
                                    if(auxiliar1.getNome().intern() == auxiliar.getUsuario().intern() &&
                                            auxiliar1.getRecursoAssociado() == "nenhum"){
                                        auxiliar1.addRecursosHistorico(auxiliar1,auxiliar.getRecurso());
                                        auxiliar1.setAtividadesRealizadas(auxiliar.getAtividade());
                                        auxiliar1.setRecursoAssociado(auxiliar.getRecurso());

                                        if(auxiliar.getRecurso().intern() == "Auditorio"){
                                            if(auditorio1.getStatus().intern() == "Livre")
                                                auditorio1 = new Auditorio(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());
                                            else
                                                auditorio2 = new Auditorio(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());
                                        }
                                        else if(auxiliar.getRecurso().intern() == "Laboratorio"){
                                            if(laboratorio1.getStatus().intern() == "Livre")
                                                laboratorio1 = new Laboratorio(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());
                                            else
                                                laboratorio2 = new Laboratorio(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());

                                        }
                                        else if(auxiliar.getRecurso().intern() == "Projetor"){
                                            if(projetor1.getStatus().intern() == "Livre")
                                                projetor1 = new Projetor(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());
                                            else
                                                projetor2 = new Projetor(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());

                                        }
                                        else if(auxiliar.getRecurso().intern() == "Sala"){
                                            if(sala1.getStatus().intern() == "Livre")
                                                sala1 = new Sala(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());
                                            else if(sala2.getStatus().intern() == "Livre")
                                                sala2 = new Sala(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());
                                            else
                                                sala3 = new Sala(auxiliar1.getIdentificacao(),auxiliar1.getNome(),
                                                        auxiliar.getInicio(),auxiliar.getFim(),"Alocado",auxiliar.getAtividade());
                                        }
                                        break;
                                    }else
                                        System.out.println("Usuario não encontrado ou usuario já tem algo alocado");

                                }

                            }

                        }
                        //Depois de processada todas as solicitações, todas sao deletadasa do arrayList
                        solicitacoes.clear();
                        System.out.println("Não há mais solicitações =)");
                    }else{

                        System.out.println("Você não está logado ou não é administrador do sistema!");

                    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }


        }


    }

    private static Usuario inicial(ArrayList usuarios)
    {

        Usuario inicial = new Usuario(001,"Jose","Professor","jovirone@ic.ufal.br","aaa");
        inicial.addRecursosHistorico(inicial,"AlocouoLAB2");
        inicial.addRecursosHistorico(inicial,"AlocouoLAB3");
        usuarios.add(inicial);
        Usuario inicial1 = new Usuario(010,"Joao","Aluno","jovirone@ic.ufal.br","010");
        usuarios.add(inicial1);
        Usuario inicial2 = new Usuario(100,"Ze","Aluno","jovirone@ic.ufal.br","100");
        usuarios.add(inicial2);
        Usuario inicial3 = new Usuario(011,"Dudu","Professor","jovirone@ic.ufal.br","011");
        usuarios.add(inicial3);
        Usuario inicial4 = new Usuario(101,"Baldoino","Professor","jovirone@ic.ufal.br","101");
        usuarios.add(inicial4);

        return inicial;
    }

	public static void main(String[] args) {

		boolean verificaLogin = false;

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();


        menu(usuarios,verificaLogin,inicial(usuarios));


		//for(Usuario auxiliar : usuarios)
        //    System.out.println(auxiliar.getNome() +" - "+auxiliar.getTipo());

	}

}
