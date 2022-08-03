package com.annuaire.fonctionnaireservice.repository;

import com.annuaire.fonctionnaireservice.model.Fonction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFonctionRepository extends MongoRepository<Fonction,String> {
}
