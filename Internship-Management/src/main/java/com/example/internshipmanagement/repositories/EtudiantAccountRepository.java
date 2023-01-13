package com.example.internshipmanagement.repositories;

import com.example.internshipmanagement.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantAccountRepository extends JpaRepository<Etudiant,Long> {
    @Query("select e from Etudiant e where e.name like :kw")
    List<Etudiant> searchCustomer(@Param("kw") String keyword);
}

