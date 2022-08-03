package com.annuaire.fonctionnaireservice.repository;

import com.annuaire.fonctionnaireservice.model.Classe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClasseRepository extends MongoRepository<Classe,String> {
}
