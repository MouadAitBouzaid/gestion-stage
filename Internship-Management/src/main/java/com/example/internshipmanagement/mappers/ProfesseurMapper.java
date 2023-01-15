package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.entities.Professeur;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProfesseurMapper {
    ProfesseurDTO toDto(Professeur professeur);
    List<ProfesseurDTO> listToDtos (List<Professeur> professeurs);
    Professeur fromDto(ProfesseurDTO professeurDTO);
}
