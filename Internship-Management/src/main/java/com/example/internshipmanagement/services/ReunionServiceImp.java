package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.ReunionDTO;
import com.example.internshipmanagement.entities.Reunion;
import com.example.internshipmanagement.mappers.ReunionMapper;
import com.example.internshipmanagement.repositories.ReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReunionServiceImp implements ReunionService{
    @Autowired
    private ReunionMapper reunionMapper;
    @Autowired
    private ReunionRepository reunionRepository;


    @Override
    public ReunionDTO save(ReunionDTO reunionDTO) {
        Reunion reunion = reunionMapper.fromDto(reunionDTO);
        Reunion saved = reunionRepository.save(reunion);
        reunionDTO.setId(saved.getId());

        return reunionDTO;
    }

    @Override
    public List<ReunionDTO> findAll() {
        return reunionMapper.listToDtos(reunionRepository.findAll());
    }
}
