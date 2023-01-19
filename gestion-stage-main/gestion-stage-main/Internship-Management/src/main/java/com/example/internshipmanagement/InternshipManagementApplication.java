package com.example.internshipmanagement;

import com.example.internshipmanagement.dtos.AdminDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.ResponsableStage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.internshipmanagement.enums.Role;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class InternshipManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternshipManagementApplication.class, args);
    }
    }




