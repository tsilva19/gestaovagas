package br.com.tasifyi.gestao_vagas.exceptions;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message){
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
            List<ErrorMessageDto> dto = new ArrayList<>();

            exception.getBindingResult().getFieldErrors().forEach(err ->{
                String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());   
                ErrorMessageDto error = new ErrorMessageDto(message, err.getField());
                dto.add(error);

            });

            return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
    
}
