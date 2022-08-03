package com.annuaire.fonctionnaireservice.dto;

import com.annuaire.fonctionnaireservice.ennumeration.Genre;
import com.annuaire.fonctionnaireservice.ennumeration.Position;
import com.annuaire.fonctionnaireservice.model.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description fonctionnaire DTO

 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FonctionnaireDto {

    private String id;
    private String organismeId;
    private String structureId;
    private String identifiant;
    private String cin;
    private  String nom_fr;
    private String nom_ar;
    private String prenom_fr;
    private String prenom_ar;
    private DateNDto date_naissance;
    private Genre genre;
    private Fonction fonction;
    private Grade grade;
    private Classe classe;
    private Diplome diplome;
    private Position position;
    private DateNDto date_recrutement;
    private Fcontact contact;
    private String createdBy;
    private LocalDateTime createTime;
}
