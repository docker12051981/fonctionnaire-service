package com.annuaire.fonctionnaireservice.service;

import com.annuaire.fonctionnaireservice.dto.CategorieDto;
import com.annuaire.fonctionnaireservice.model.Categorie;

import java.util.List;

/**
 * @author karim hmadi

 * @description categorie Interface

 */
public interface ICategorieService {
    Categorie saveCategorie(CategorieDto categorieDto);

    Categorie findCategorieById(String id);

    List<Categorie> findAllCategie();

    Boolean deleteCategorie(String id);

    Categorie updateCategorie(String id, Categorie categorieRequest);
}
