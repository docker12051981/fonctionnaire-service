package com.annuaire.fonctionnaireservice.repository;

import com.annuaire.fonctionnaireservice.model.Grade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRepository extends MongoRepository<Grade,String> {
}
