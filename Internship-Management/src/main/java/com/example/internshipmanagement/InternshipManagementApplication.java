package com.example.internshipmanagement;

import com.example.internshipmanagement.dtos.AdminDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.repositories.EtudiantAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.internshipmanagement.enums.Role;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class InternshipManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternshipManagementApplication.class, args);
    }
    @Bean
    CommandLineRunner start(EtudiantAccountRepository etudiantAccountRepository){
        Role role = null;
        return  args -> {
            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
                Etudiant etudiant=new Etudiant();
                etudiant.setName(name);
                etudiant.setUsername(name+"123");
                etudiant.setPassword(name+"1996");
                etudiant.setLastName("idrissi");
                etudiant.setPhoneNumber("0604247324");
                etudiant.setRole(role.ETUDIANT);
                etudiant.setNiveau("5ieme année");
                etudiant.setEmail(name+"@gmail.com");
                etudiantAccountRepository.save(etudiant);
                //(email, last_name, name, niveau, password, phone_number, role, username)
            });
        };



    }



}
