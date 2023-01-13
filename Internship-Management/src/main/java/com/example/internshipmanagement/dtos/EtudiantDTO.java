package com.example.internshipmanagement.dtos;


import com.example.internshipmanagement.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EtudiantDTO extends UtilisateurDTO{

    private String niveau;
    @Enumerated(EnumType.STRING)
    private Role role;
}
