package br.com.tasifyi.gestao_vagas.exceptions;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(){
        super("JOB Não encontrado");
    }
}
