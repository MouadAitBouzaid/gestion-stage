package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.DocumentDTO;
import com.example.internshipmanagement.entities.Document;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.mappers.DocumentMapper;
import com.example.internshipmanagement.mappers.EtablissementMapper;
import com.example.internshipmanagement.repositories.DocumentRepository;
import com.example.internshipmanagement.repositories.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    DocumentMapper documentMapper;
    @Autowired
    DocumentRepository documentRepository;
    @Override
    public DocumentDTO save(DocumentDTO documentDTO) {
        Document etablissement = documentMapper.fromDto(documentDTO);
        Document saved = documentRepository.save(etablissement);
        documentDTO.setId(saved.getId());

        return documentDTO;
    }

    @Override
    public List<DocumentDTO> findAll() {
        return documentMapper.listToDtos(documentRepository.findAll());
    }

    @Override
    public Optional<DocumentDTO> getById(Long documentId) {
        return documentRepository.findById(documentId)
                .map(documentMapper::toDto);
    }

    @Override
    public Optional<DocumentDTO> delete(Long documentId) {
        Optional<Document> document = documentRepository.findById(documentId);
        document.ifPresent(documentRepository::delete);
        return document.map(documentMapper::toDto);
    }

    @Override
    public Optional<DocumentDTO> update(Long documentId, DocumentDTO documentDTO) {
        Optional<Document> documentOptional = documentRepository.findById(documentId);
        if (documentOptional.isPresent()) {
            Document document = documentMapper.fromDto(documentDTO);
            document.setId(documentId);
            Document updatedEtudiant = documentRepository.save(document);
            return Optional.of(documentMapper.toDto(updatedEtudiant));
        }
        return Optional.empty();
    }

    @Override
    public List<DocumentDTO> getDocByEtud(Long id) {
        return null;
    }
}
