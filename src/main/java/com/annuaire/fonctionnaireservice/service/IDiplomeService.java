package com.annuaire.fonctionnaireservice.service;
import com.annuaire.fonctionnaireservice.dto.DiplomeDto;
import com.annuaire.fonctionnaireservice.model.Diplome;


import java.util.List;

/**
 * @author karim hmadi

 * @description diplome Interface

 */
public interface IDiplomeService {
    Diplome saveDiplome(DiplomeDto diplomeDto);

    Diplome findDiplomeById(String id);

    List<Diplome> findAllDiplome();

    Boolean deleteDiplome(String id);

    Diplome updateDiplome(String id, Diplome diplomeRequest);
}
