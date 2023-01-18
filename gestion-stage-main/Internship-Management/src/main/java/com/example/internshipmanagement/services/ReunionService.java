package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.ReunionDTO;

import java.util.List;

public interface ReunionService {
    ReunionDTO save(ReunionDTO reunionDTO);

    List<ReunionDTO> findAll();
}
