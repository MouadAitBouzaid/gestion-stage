package com.example.internshipmanagement;

import com.example.internshipmanagement.dtos.AdminDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.ResponsableStage;
import com.example.internshipmanagement.repositories.EtablissementRepository;
import com.example.internshipmanagement.repositories.EtudiantAccountRepository;
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
    @Bean
    CommandLineRunner start(EtudiantAccountRepository etudiantAccountRepository, EtablissementRepository etablissementRepository){
        Etablissement etablissement = new Etablissement();
        etablissement.setId(1L);
        Role role = null;
        return  args -> {
            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
                Etudiant etudiant=new Etudiant();
                etudiant.setName(name);
                etudiant.setUsername(name+"123");
                etudiant.setPassword(name+"1996");
                etudiant.setLastName("idrissi");
                etudiant.setPhoneNumber("0604247324");
             //   etudiant.setRole(role.ETUDIANT);
                etudiant.setNiveau("5ieme année");
                etudiant.setEmail(name+"@gmail.com");
                etudiant.setEtablissement(etablissement);
                etudiantAccountRepository.save(etudiant);
                //(email, last_name, name, niveau, password, phone_number, role, username)
            });

            etablissementRepository.findAll().forEach(cust->{
                Etablissement etablissements = new Etablissement();
                etablissement.setName("UUIR");
               // etablissement.setResponssableEtab(new ResponsableStage());
              });


            };


        };



    }




