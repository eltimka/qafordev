package com.eltimka.qafordevs.service;

import com.eltimka.qafordevs.entity.DeveloperEntity;

import java.util.List;

public interface DeveloperService {
    DeveloperEntity saveDeveloper(DeveloperEntity developer);

    DeveloperEntity updateDeveloper(DeveloperEntity developer);

    DeveloperEntity getDeveloperById(Integer id);

    DeveloperEntity getDeveloperByEmail(String email);

    List<DeveloperEntity> getAllDevelopers();

    List<DeveloperEntity> getAllActiveBySpecialty(String specialty);

    void softDeleteById(Integer id);

    void hardDeleteById(Integer id);

}
