package com.annuaire.fonctionnaireservice.service;

import com.annuaire.fonctionnaireservice.dto.ClasseDto;

import com.annuaire.fonctionnaireservice.model.Classe;


import java.util.List;

/**
 * @author karim hmadi

 * @description classe  Interface

 */

public interface IClasseService {
    Classe saveClasse(ClasseDto classeDto);

    Classe findClasseById(String id);

    List<Classe> findAllClasse();

    Boolean deleteClasse(String id);

    Classe updateClasse(String id, Classe classeRequest);
}
