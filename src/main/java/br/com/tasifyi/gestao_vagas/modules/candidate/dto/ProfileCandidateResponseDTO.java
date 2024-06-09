package br.com.tasifyi.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Desenvolvedor JAVA")
    private String description;

    @Schema(example = "jose")
    private String username;

    @Schema(example = "jose@gmail.com")
    private String email;

    private UUID id;

    @Schema(example = "Jose Silva")
    private String name;

}
