package com.annuaire.fonctionnaireservice.service;

import com.annuaire.fonctionnaireservice.dto.ClasseDto;
import com.annuaire.fonctionnaireservice.model.Classe;
import com.annuaire.fonctionnaireservice.repository.IClasseRepository;
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

 * @description classe service

 */

@Service
public class ClasseService implements IClasseService{

    @Autowired
    private IClasseRepository classeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Classe saveClasse(ClasseDto classeDto)
    {
        Classe classe = converter.classe_dtoToEntity(classeDto);
        classe.setCreateTime(LocalDateTime.now());
        return classeRepository.save(classe);
    }


    @Override
    public Classe findClasseById(String id) {
        Optional<Classe> result = classeRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Classe", "id", id);
        }
    }


    @Override
    public Boolean deleteClasse(String id) {
        classeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Classe> findAllClasse()
    {
        return classeRepository.findAll();
    }

    @Override
    public Classe updateClasse(String id, Classe classeRequest) {
        Classe classe = classeRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("Fonction", "id", id));

        classe.setCode(classeRequest.getCode());
        classe.setLib_fr(classeRequest.getLib_fr());
        classe.setLib_ar(classeRequest.getLib_ar());

        return classeRepository.save(classe);
    }


}
