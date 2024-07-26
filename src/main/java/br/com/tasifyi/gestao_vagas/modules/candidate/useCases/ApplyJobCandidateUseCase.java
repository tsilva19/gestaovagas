package br.com.tasifyi.gestao_vagas.modules.candidate.useCases;

import br.com.tasifyi.gestao_vagas.exceptions.JobNotFoundException;
import br.com.tasifyi.gestao_vagas.exceptions.UserNotFoundException;
import br.com.tasifyi.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.tasifyi.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.tasifyi.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.tasifyi.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob){

        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob).build();
        applyJob = applyJobRepository.save(applyJob);

        return applyJob;

    }
}
