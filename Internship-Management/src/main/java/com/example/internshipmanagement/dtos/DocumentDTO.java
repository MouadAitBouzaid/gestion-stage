package com.example.internshipmanagement.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class DocumentDTO {
    private Long id;
    private String name;
    private Date dateSoumission;
}
