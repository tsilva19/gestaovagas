package br.com.tasifyi.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Thiago S", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do Candidato")
    private String name;

    @NotBlank
    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter  espaço")
    @Schema(example = "daniel", requiredMode = Schema.RequiredMode.REQUIRED, description = "Username do Candidato")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail valido")
    @Schema(example = "daniel@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "Email do Candidato")
    private String email;

    @Length(min=10, max=100, message= "A senha deve conter entre (10)  e (100) caracteres")
    @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED, description = "Senha do Candidato")
    private String password;

    @Schema(example = "Desenvolvedor JAVA", requiredMode = Schema.RequiredMode.REQUIRED, description = "Breve descrição do Candidato")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
