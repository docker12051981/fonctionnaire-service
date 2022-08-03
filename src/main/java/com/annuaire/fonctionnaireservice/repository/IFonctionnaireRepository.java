package com.annuaire.fonctionnaireservice.repository;

import com.annuaire.fonctionnaireservice.model.Fonctionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFonctionnaireRepository extends MongoRepository<Fonctionnaire,String> {

    Optional<Fonctionnaire> findById(String id);
    List<Fonctionnaire> findByStructureId(String id);

    @Query(value="{ structure: ?0 }", fields="{ nom_fr: 1, _id: 0 }", sort="{ nom_fr: -1 }")
    List<Fonctionnaire> findByFonctionnaireAsCustom(String structureid);
    @Query(value="{ id: ?0 }", fields="{ nom_fr: 1, _id: 0 }", sort="{ nom_fr: -1 }")
    Fonctionnaire findFonctionnairewithStructureAsCustom(String fonctionnaireId);

    List<Fonctionnaire> findByOrganismeId(String id);

    Optional<Fonctionnaire> findByIdentifiant(String identifiant);
}
