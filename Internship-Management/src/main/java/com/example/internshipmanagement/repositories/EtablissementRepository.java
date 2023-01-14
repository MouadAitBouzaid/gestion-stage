package com.example.internshipmanagement.repositories;

import com.example.internshipmanagement.entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement,Long> {
}
