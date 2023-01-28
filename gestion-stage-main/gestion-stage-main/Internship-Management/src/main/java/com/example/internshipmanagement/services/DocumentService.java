package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.DocumentDTO;
import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.dtos.EtudiantDTO;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    DocumentDTO save(DocumentDTO documentDTO);
    List<DocumentDTO> findAll();
    Optional<DocumentDTO> getById(Long documentId);
    Optional<DocumentDTO> delete(Long documentId);
    Optional<DocumentDTO> update(Long documentId, DocumentDTO documentDTO);

    List<DocumentDTO> getDocByEtud(Long id);
}
