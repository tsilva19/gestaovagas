package br.com.tasifyi.gestao_vagas.exceptions;

public class CompanyNotFoundException extends RuntimeException{

    public CompanyNotFoundException(){
        super("company not Found");
    }
}