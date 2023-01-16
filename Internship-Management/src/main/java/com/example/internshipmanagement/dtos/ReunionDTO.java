package com.example.internshipmanagement.dtos;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ReunionDTO {
    private Long id;
    private LocalDateTime dateReunion;

    private EtudiantDTO etudiantDTO;

    private ProfesseurDTO professeurDTO;
}
