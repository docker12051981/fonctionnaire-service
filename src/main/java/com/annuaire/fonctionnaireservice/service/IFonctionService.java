package com.annuaire.fonctionnaireservice.service;

import com.annuaire.fonctionnaireservice.dto.FonctionDto;
import com.annuaire.fonctionnaireservice.model.Fonction;

import java.util.List;

/**
 * @author karim hmadi

 * @description fonction Interface

 */
public interface IFonctionService {
    Fonction saveFonction(FonctionDto fonctionDto);

    Fonction findFonctionById(String id);

    List<Fonction> findAllFonction();

    Boolean deleteFonction(String id);

    Fonction updateFonction(String id, Fonction fonctionRequest);
}
