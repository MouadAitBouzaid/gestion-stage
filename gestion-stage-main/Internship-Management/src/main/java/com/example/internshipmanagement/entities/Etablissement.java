package com.example.internshipmanagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "etablissement", fetch = FetchType.EAGER)
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Etudiant> etudiantList;
    @OneToOne
    private ResponsableStage responssableEtab;

}
