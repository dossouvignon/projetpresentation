package com.example.cmproMonNewprojet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String numeroTelephone;
    private String adresseHabitation;
    private String nomEntreprise;
    private String preoccupation;
}
