package com.annuaire.fonctionnaireservice.service;
import com.annuaire.fonctionnaireservice.dto.CategorieDto;
import com.annuaire.fonctionnaireservice.model.Categorie;
import com.annuaire.fonctionnaireservice.repository.ICategorieRepository;
import com.annuaire.fonctionnaireservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description Categorie service

 */

@Service
public class CategorieService implements ICategorieService{

    @Autowired
    private ICategorieRepository categorieRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Categorie saveCategorie(CategorieDto categorieDto)
    {
        Categorie categorie = converter.cat_dtoToEntity(categorieDto);
        categorie.setCreateTime(LocalDateTime.now());
        return categorieRepository.save(categorie);
    }


    @Override
    public Categorie findCategorieById(String id) {
        Optional<Categorie> result = categorieRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Categorie", "id", id);
        }
    }


    @Override
    public Boolean deleteCategorie(String id) {
        categorieRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Categorie> findAllCategie()
    {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie updateCategorie(String id, Categorie categorieRequest) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("categorie", "id", id));

        categorie.setCode(categorieRequest.getCode());
        categorie.setLib_fr(categorieRequest.getLib_fr());
        categorie.setLib_ar(categorieRequest.getLib_ar());
        return categorieRepository.save(categorie);
    }
}
