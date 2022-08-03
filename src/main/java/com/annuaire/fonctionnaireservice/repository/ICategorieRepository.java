package com.annuaire.fonctionnaireservice.repository;

import com.annuaire.fonctionnaireservice.model.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategorieRepository extends MongoRepository<Categorie,String> {
}
