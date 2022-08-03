package com.annuaire.fonctionnaireservice.tools;
import com.annuaire.fonctionnaireservice.dto.*;
import com.annuaire.fonctionnaireservice.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author karim hmadi

 * @description convert dto to entity and entity to dto

 */

@Component
public class Converter {

    public FonctionnaireDto entityToDto(Fonctionnaire fonctionnaire) {
        ModelMapper mapper =new ModelMapper();
        FonctionnaireDto map = mapper.map(fonctionnaire, FonctionnaireDto.class);
        return map;

    }
    public List<FonctionnaireDto> entityToDto(List<Fonctionnaire> fonctionnaire) {
        return	fonctionnaire.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }


    public Fonctionnaire dtoToEntity(FonctionnaireDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Fonctionnaire map = mapper.map(dto, Fonctionnaire.class);
        return map;
    }

    public List<Fonctionnaire> dtoToEntity(List<FonctionnaireDto> dto)
    {
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }


    /* convert dto for fonction */


    public FonctionDto fonc_entityToDto(Fonction fonction) {
        ModelMapper mapper =new ModelMapper();
        FonctionDto map = mapper.map(fonction, FonctionDto.class);
        return map;

    }
    public List<FonctionDto> fonc_entityToDto(List<Fonction> fonction) {
        return	fonction.stream().map(x -> fonc_entityToDto(x)).collect(Collectors.toList());
    }


    public Fonction fonc_dtoToEntity(FonctionDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Fonction map = mapper.map(dto, Fonction.class);
        return map;
    }

    public List<Fonction> fonc_dtoToEntity(List<FonctionDto> dto)
    {
        return dto.stream().map(x -> fonc_dtoToEntity(x)).collect(Collectors.toList());
    }

    /* convert dto for grade */

    public GradeDto grade_entityToDto(Grade grade) {
        ModelMapper mapper =new ModelMapper();
        GradeDto map = mapper.map(grade, GradeDto.class);
        return map;

    }
    public List<GradeDto> grade_entityToDto(List<Grade> grade) {
        return	grade.stream().map(x -> grade_entityToDto(x)).collect(Collectors.toList());
    }

    public Grade grade_dtoToEntity(GradeDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Grade map = mapper.map(dto, Grade.class);
        return map;
    }

    public List<Grade> grade_dtoToEntity(List<GradeDto> dto)
    {
        return dto.stream().map(x -> grade_dtoToEntity(x)).collect(Collectors.toList());
    }


    /* convert dto for categorie */


    public CategorieDto cat_entityToDto(Categorie categorie) {
        ModelMapper mapper =new ModelMapper();
        CategorieDto map = mapper.map(categorie, CategorieDto.class);
        return map;

    }
    public List<CategorieDto> cat_entityToDto(List<Categorie> categories) {
        return	categories.stream().map(x -> cat_entityToDto(x)).collect(Collectors.toList());
    }

    public Categorie cat_dtoToEntity(CategorieDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Categorie map = mapper.map(dto, Categorie.class);
        return map;
    }

    public List<Categorie> cat_dtoToEntity(List<CategorieDto> dto)
    {
        return dto.stream().map(x -> cat_dtoToEntity(x)).collect(Collectors.toList());
    }

    /* convert dto for classe */



    public ClasseDto classe_entityToDto(Classe classe) {
        ModelMapper mapper =new ModelMapper();
        ClasseDto map = mapper.map(classe, ClasseDto.class);
        return map;

    }
    public List<ClasseDto> classe_entityToDto(List<Classe> classe) {
        return	classe.stream().map(x -> classe_entityToDto(x)).collect(Collectors.toList());
    }

    public Classe classe_dtoToEntity(ClasseDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Classe map = mapper.map(dto, Classe.class);
        return map;
    }

    public List<Classe> classe_dtoToEntity(List<ClasseDto> dto)
    {
        return dto.stream().map(x -> classe_dtoToEntity(x)).collect(Collectors.toList());
    }


    /* convert dto for diplome */

    public DiplomeDto diplome_entityToDto(Diplome diplome) {
        ModelMapper mapper =new ModelMapper();
        DiplomeDto map = mapper.map(diplome, DiplomeDto.class);
        return map;

    }
    public List<DiplomeDto> diplome_entityToDto(List<Diplome> diplome) {
        return	diplome.stream().map(x -> diplome_entityToDto(x)).collect(Collectors.toList());
    }

    public Diplome diplome_dtoToEntity(DiplomeDto dto)
    {
        ModelMapper mapper = new ModelMapper();
        Diplome map = mapper.map(dto, Diplome.class);
        return map;
    }

    public List<Diplome> diplome_dtoToEntity(List<DiplomeDto> dto)
    {
        return dto.stream().map(x -> diplome_dtoToEntity(x)).collect(Collectors.toList());
    }

}
