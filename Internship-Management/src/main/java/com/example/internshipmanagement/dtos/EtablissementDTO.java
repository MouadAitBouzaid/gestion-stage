package com.example.internshipmanagement.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EtablissementDTO {
    private Long id;
    private String name;
    private List<EtudiantDTO> etudiantDTOList;
}
