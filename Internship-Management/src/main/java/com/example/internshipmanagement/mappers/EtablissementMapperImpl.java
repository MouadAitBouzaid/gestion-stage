package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class EtablissementMapperImpl {

    public EtudiantDTO fromEtudiant(Etudiant etudiant){
        EtudiantDTO etudiantDTO = new EtudiantDTO();
        BeanUtils.copyProperties(etudiant,etudiantDTO);
        etudiantDTO.setEtablissement(fromEtablissement(etudiant.getEtablissement()));
        return etudiantDTO;
    }

    public Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO){
        Etudiant etudiant=new Etudiant();
        BeanUtils.copyProperties(etudiantDTO,etudiant);
        return etudiant;
    }

    public EtablissementDTO fromEtablissement(Etablissement etablissement){
       if(etablissement==null) return  null;
        EtablissementDTO etablissementDTO = new EtablissementDTO();
        //BeanUtils.copyProperties(etablissement,etablissementDTO);
        etablissementDTO.setId(etablissement.getId());
        etablissementDTO.setName(etablissement.getName());
        return etablissementDTO;
    }

    public Etablissement fromeEtablissementDTO(EtablissementDTO etablissementDTO){
        Etablissement etablissement=new Etablissement();
        BeanUtils.copyProperties(etablissementDTO,etablissement);
        return etablissement;
    }
}
