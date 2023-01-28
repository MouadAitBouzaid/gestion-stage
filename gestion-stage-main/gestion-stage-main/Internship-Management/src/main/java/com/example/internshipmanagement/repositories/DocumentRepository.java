package com.example.internshipmanagement.repositories;

import com.example.internshipmanagement.entities.Document;
import com.example.internshipmanagement.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    @Query(value = "SELECT * FROM Document WHERE etudiant_doc_id = :etudiant_doc_id", nativeQuery = true)
    List<Document> findEtudiantByEtudiantDoc(@Param("etudiant_doc_id")Long id);
}
