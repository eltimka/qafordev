package com.eltimka.qafordevs.service;

import com.eltimka.qafordevs.entity.DeveloperEntity;
import com.eltimka.qafordevs.entity.Status;
import com.eltimka.qafordevs.exeption.DeveloperNotFoundException;
import com.eltimka.qafordevs.exeption.DeveloperWithDuplicateEmailException;
import com.eltimka.qafordevs.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;
    @Override
    public DeveloperEntity saveDeveloper(DeveloperEntity developer) {
        DeveloperEntity duplicateCandidate = developerRepository.findByEmail(developer.getEmail());

        if(Objects.nonNull(duplicateCandidate)){
            throw new DeveloperWithDuplicateEmailException("Developer with defined email is already exist");
        }
        developer.setStatus(Status.ACTIVE);
        return developerRepository.save(developer);
    }

    @Override
    public DeveloperEntity updateDeveloper(DeveloperEntity developer) {
        boolean isExists = developerRepository.existsById(developer.getId());

        if(!isExists){
            throw new DeveloperNotFoundException("Developer not found");
        }
        return developerRepository.save(developer);
    }

    @Override
    public DeveloperEntity getDeveloperById(Integer id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new DeveloperNotFoundException("Developer not found"));
    }

    @Override
    public DeveloperEntity getDeveloperByEmail(String email) {
        DeveloperEntity obtainedDeveloper = developerRepository.findByEmail(email);

        if(Objects.isNull(obtainedDeveloper)) {
            throw new DeveloperNotFoundException("Developer not found");
        }
        return obtainedDeveloper;
    }

    @Override
    public List<DeveloperEntity> getAllDevelopers() {
        return developerRepository.findAll()
                .stream().filter(d -> {
                    return d.getStatus().equals(Status.ACTIVE);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<DeveloperEntity> getAllActiveBySpecialty(String specialty) {
        return developerRepository.findAllActiveBySpecialty(specialty);
    }

    @Override
    public void softDeleteById(Integer id) {
        DeveloperEntity obtainedDeveloper = developerRepository.findById(id)
                .orElseThrow(() -> new DeveloperNotFoundException("Developer not found"));

        obtainedDeveloper.setStatus(Status.DELETED);
        developerRepository.save(obtainedDeveloper);
    }

    @Override
    public void hardDeleteById(Integer id) {
        DeveloperEntity obtainedDeveloper = developerRepository.findById(id)
                .orElseThrow(() -> new DeveloperNotFoundException("Developer not found"));
        developerRepository.deleteById(obtainedDeveloper.getId());
    }

}
