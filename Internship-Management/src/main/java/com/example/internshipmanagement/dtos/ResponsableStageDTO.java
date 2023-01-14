package com.example.internshipmanagement.dtos;


import com.example.internshipmanagement.entities.Etablissement;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
public class ResponsableStageDTO extends UtilisateurDTO{


    private List<EtablissementDTO> etablissementDTOS;
}
