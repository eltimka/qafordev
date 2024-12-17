package com.eltimka.qafordevs.util;

import com.eltimka.qafordevs.entity.DeveloperEntity;
import com.eltimka.qafordevs.entity.Status;

public class DataUtils {

    public static DeveloperEntity getJohnDoeTransient(){
        return  DeveloperEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
    }
    public  DeveloperEntity getJohnDoePersisted() {
        return DeveloperEntity.builder()
                .id(1)
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
    }
}
