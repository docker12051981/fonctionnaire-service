package com.annuaire.fonctionnaireservice.repository;

import com.annuaire.fonctionnaireservice.model.Diplome;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiplomeRepository extends MongoRepository<Diplome,String> {
}
