package com.eltimka.qafordevs.repository;

import com.eltimka.qafordevs.entity.DeveloperEntity;
import com.eltimka.qafordevs.entity.Status;

import com.eltimka.qafordevs.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class DeveloperRepositoryTests {

    @Autowired
    private DeveloperRepository developerRepository;

  @BeforeEach
    public void setup() {
        developerRepository.deleteAll();
    }


    @Test
    @DisplayName("Test save developer functionality")
    public void givenDeveloperObject_whenSave_thenDeveloperIsCreated() {
        //given
        DeveloperEntity developerToSave = DataUtils.getJohnDoeTransient();
        //when
        DeveloperEntity savedDeveloper = developerRepository.save(developerToSave);
        //then
        assertThat(savedDeveloper).isNotNull();
        assertThat(savedDeveloper.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test update developer functionality")
    public void givenDeveloperToUpdate_whenSave_thenEmailIsChanged(){
         //given
        String updatedEmail = "updated@mail.com";
        DeveloperEntity developerToCreate = DataUtils.getJohnDoeTransient();
        developerRepository.save(developerToCreate);
        //when
        DeveloperEntity developerToUpdate = developerRepository.findById(developerToCreate.getId())
                .orElse(null);
        developerToUpdate.setEmail(updatedEmail);
        DeveloperEntity updatedDeveloper = developerRepository.save(developerToUpdate);
        //then
        assertThat(updatedDeveloper).isNotNull();
       assertThat(updatedDeveloper.getEmail()).isEqualTo(updatedEmail);

    }

    @Test
    @DisplayName("Test get developer by id functionality")
    public void givenDeveloperCreated_whenGetById_thenDeveloperIsReturned(){
      //given
        DeveloperEntity developerToSave = DataUtils.getJohnDoeTransient();
        developerRepository.save(developerToSave);
        //when
        DeveloperEntity obtainedDeveloper = developerRepository.findById(developerToSave.getId()).orElse(null);
        //then
        assertThat(obtainedDeveloper).isNotNull();
        assertThat(obtainedDeveloper.getEmail()).isEqualTo("john.doe@mail.com");
  }
  @Test
  @DisplayName("Test developer not found functionality")
  public void givenDeveloperIsNotCreated_whenGetById_thenOptionalIsEmpty(){
      //given

      //when
      DeveloperEntity obtainedDeveloper = developerRepository.findById(1).orElse(null);
      //then
      assertThat(obtainedDeveloper).isNull();

  }
}
