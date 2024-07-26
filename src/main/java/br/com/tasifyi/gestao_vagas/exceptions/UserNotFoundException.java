package br.com.tasifyi.gestao_vagas.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("Usuario Não encontrado");
    }
}
