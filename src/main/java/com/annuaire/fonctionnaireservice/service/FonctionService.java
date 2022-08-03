package com.annuaire.fonctionnaireservice.service;
import com.annuaire.fonctionnaireservice.dto.FonctionDto;
import com.annuaire.fonctionnaireservice.model.Fonction;
import com.annuaire.fonctionnaireservice.repository.IFonctionRepository;
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

 * @description fonction service

 */

@Service
public class FonctionService implements IFonctionService{

    @Autowired
    private IFonctionRepository fonctionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Fonction saveFonction(FonctionDto fonctionDto)
    {
        Fonction fonction = converter.fonc_dtoToEntity(fonctionDto);
        fonction.setCreateTime(LocalDateTime.now());
        return fonctionRepository.save(fonction);
    }


    @Override
    public Fonction findFonctionById(String id) {
        Optional<Fonction> result = fonctionRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Fonction", "id", id);
        }
    }


    @Override
    public Boolean deleteFonction(String id) {
        fonctionRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Fonction> findAllFonction()
    {
        return fonctionRepository.findAll();
    }

    @Override
    public Fonction updateFonction(String id, Fonction fonctionRequest) {
        Fonction fonction = fonctionRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("Fonction", "id", id));

        fonction.setCode(fonctionRequest.getCode());
        fonction.setLib_fr(fonctionRequest.getLib_fr());
        fonction.setLib_ar(fonctionRequest.getLib_ar());
        return fonctionRepository.save(fonction);
    }


}
