package br.com.tasifyi.gestao_vagas.modules.company.repositories;

import br.com.tasifyi.gestao_vagas.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyRepository> findByUsernameOrEmail(String username, String email );
    Optional<CompanyEntity> findByUsername(String username);

}
