package com.annuaire.fonctionnaireservice.service;

import com.annuaire.fonctionnaireservice.VO.ResponseTemplateVO;
import com.annuaire.fonctionnaireservice.dto.FonctionnaireDto;
import com.annuaire.fonctionnaireservice.model.Fonctionnaire;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author karim hmadi

 * @description fonctionnaire Interface

 */

public interface IFonctionnaireService {
    Fonctionnaire saveFonctionnaire(FonctionnaireDto fonctionnaireDto);

    List<Fonctionnaire> findFonctionnaireByStructure(String idstructure);

    Fonctionnaire findFonctionnaireById(String id);

    Boolean deleteFonctionnaire(String id);

    List<Fonctionnaire> findAllFonctionnaires();

    Fonctionnaire updateFonctionnaire(String id, Fonctionnaire fonctionnaireRequest);

    ResponseTemplateVO getFonctionnairewithStructure(String id);

    List<Fonctionnaire> findFonctionnaireByStructureId(String idstructure);

    List<Fonctionnaire> findFonctionnaireByOrganismeId(String idorganisme);

    ResponseTemplateVO getFonctionnaireByidentifiantwithOrganisme(String identifiant);
}
