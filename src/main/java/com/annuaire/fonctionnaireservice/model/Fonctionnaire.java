package com.annuaire.fonctionnaireservice.model;

import com.annuaire.fonctionnaireservice.ennumeration.Genre;
import com.annuaire.fonctionnaireservice.ennumeration.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author karim hmadi

 * @description entity for fonctionnaire

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fonctionnaires")
public class Fonctionnaire {
    @Id
    private String id;
    @Field(value="organismeId")
    private String organismeId;
    @Field(value="structureId")
    private String structureId;
    @Indexed(unique = true)
    @Field(value="identifiant")
    private String identifiant;
    @Field(value="cin")
    private String cin;
    @Field(value="nom_fr")
    private  String nom_fr;
    @Field(value="nom_ar")
    private String nom_ar;
    @Field(value="prenom_fr")
    private String prenom_fr;
    @Field(value="prenom_ar")
    private String prenom_ar;
    @Field(value="date_naissance")
    private Date date_naissance;
    @Field("genre")
    private Genre genre;
    @Field("fonction")
    @DBRef
    private Fonction fonction;
    @Field("grade")
    @DBRef
    private Grade grade;
    @Field("classe")
    @DBRef
    private Classe classe;
    @Field("diplome")
    @DBRef
    private Diplome diplome;
    @Field("position")
    private Position position;
    private Date date_recrutement;
    @Field("contact")
    private Fcontact contact;
    private String createdBy;
    private LocalDateTime createTime;
}

