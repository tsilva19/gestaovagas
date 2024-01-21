package br.com.tasifyi.gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDto {

    private String message;
    private String field;
    
}
