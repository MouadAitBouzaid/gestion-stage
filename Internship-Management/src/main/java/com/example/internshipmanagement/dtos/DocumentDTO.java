package com.example.internshipmanagement.dtos;

import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.enums.TypeDocument;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DocumentDTO {
    private Long id;
    private String name;
    private LocalDateTime dateSoumission;
    private LocalDateTime dateModification;
    private String path;
    private TypeDocument typeDocument;
    private Etudiant etudiant;
}
