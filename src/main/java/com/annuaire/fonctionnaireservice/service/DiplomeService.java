package com.annuaire.fonctionnaireservice.service;

import com.annuaire.fonctionnaireservice.dto.DiplomeDto;
import com.annuaire.fonctionnaireservice.model.Diplome;
import com.annuaire.fonctionnaireservice.repository.IDiplomeRepository;
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

 * @description Diplome service

 */

@Service
public class DiplomeService implements IDiplomeService{

    @Autowired
    private IDiplomeRepository diplomeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Diplome saveDiplome(DiplomeDto diplomeDto)
    {
        Diplome diplome = converter.diplome_dtoToEntity(diplomeDto);
        diplome.setCreateTime(LocalDateTime.now());
        return diplomeRepository.save(diplome);
    }

    @Override
    public Diplome findDiplomeById(String id) {
        Optional<Diplome> result = diplomeRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Diplome", "id", id);
        }
    }


    @Override
    public Boolean deleteDiplome(String id) {
        diplomeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Diplome> findAllDiplome()
    {
        return diplomeRepository.findAll();
    }

    @Override
    public Diplome updateDiplome(String id, Diplome diplomeRequest) {
        Diplome diplome = diplomeRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("Diplome", "id", id));
        diplome.setCode(diplomeRequest.getCode());
        diplome.setLib_fr(diplomeRequest.getLib_fr());
        diplome.setLib_ar(diplomeRequest.getLib_ar());
        return diplomeRepository.save(diplome);
    }

}
