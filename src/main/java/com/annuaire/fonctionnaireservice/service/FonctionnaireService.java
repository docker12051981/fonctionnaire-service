package com.annuaire.fonctionnaireservice.service;
import com.annuaire.fonctionnaireservice.VO.ResponseTemplateVO;
import com.annuaire.fonctionnaireservice.VO.Structure;
import com.annuaire.fonctionnaireservice.dto.FonctionnaireDto;
import com.annuaire.fonctionnaireservice.model.Fonctionnaire;
import com.annuaire.fonctionnaireservice.repository.IFonctionnaireRepository;
import com.annuaire.fonctionnaireservice.tools.Converter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author karim hmadi

 * @description fonctionnaire service

 */

@Service
@Slf4j
public class FonctionnaireService implements IFonctionnaireService{

    private final IFonctionnaireRepository fonctionnaireRepository;
    public FonctionnaireService(IFonctionnaireRepository fonctionnaireRepository) {
        super();
        this.fonctionnaireRepository = fonctionnaireRepository;
    }
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Fonctionnaire saveFonctionnaire(FonctionnaireDto fonctionnaireDto)
    {

        Fonctionnaire fonctionnaire = converter.dtoToEntity(fonctionnaireDto);
        fonctionnaire.setCreateTime(LocalDateTime.now());
        //StructureDto str= converter.entityToDto(structure);
        return fonctionnaireRepository.save(fonctionnaire);
    }

    @Override
    public List<Fonctionnaire> findFonctionnaireByStructure(String idstructure)
    {
        return fonctionnaireRepository.findByFonctionnaireAsCustom(idstructure);
    }



    @Override
    public Fonctionnaire findFonctionnaireById(String id) {
        Optional<Fonctionnaire> result = fonctionnaireRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Fonctionnaire", "id", id);
        }
    }


    @Override
    public List<Fonctionnaire> findFonctionnaireByStructureId(String id) {
       return fonctionnaireRepository.findByStructureId(id);
    }

    @Override
    public List<Fonctionnaire> findFonctionnaireByOrganismeId(String id)
    {
        return fonctionnaireRepository.findByOrganismeId(id);
    }

    @Override
    public Boolean deleteFonctionnaire(String id) {
        fonctionnaireRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Fonctionnaire> findAllFonctionnaires()
    {
        return fonctionnaireRepository.findAll();
    }

    @Override
    public Fonctionnaire updateFonctionnaire(String id, Fonctionnaire fonctionnaireRequest) {
        Fonctionnaire fonctionnaire = fonctionnaireRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("Fonctionnaire", "id", id));
        fonctionnaire.setOrganismeId(fonctionnaireRequest.getOrganismeId());
        fonctionnaire.setStructureId(fonctionnaireRequest.getStructureId());
        fonctionnaire.setIdentifiant(fonctionnaireRequest.getIdentifiant());
        fonctionnaire.setCin(fonctionnaireRequest.getCin());
        fonctionnaire.setNom_fr(fonctionnaireRequest.getNom_fr());
        fonctionnaire.setNom_ar(fonctionnaireRequest.getNom_ar());
        fonctionnaire.setPrenom_fr(fonctionnaireRequest.getPrenom_fr());
        fonctionnaire.setPrenom_ar(fonctionnaireRequest.getPrenom_ar());
        fonctionnaire.setDate_naissance(fonctionnaireRequest.getDate_naissance());
        fonctionnaire.setDate_recrutement(fonctionnaireRequest.getDate_recrutement());
        fonctionnaire.setFonction(fonctionnaireRequest.getFonction());
        fonctionnaire.setGrade(fonctionnaireRequest.getGrade());
        fonctionnaire.setClasse(fonctionnaireRequest.getClasse());
        fonctionnaire.setDiplome(fonctionnaireRequest.getDiplome());
        fonctionnaire.setGenre(fonctionnaireRequest.getGenre());
        fonctionnaire.setPosition(fonctionnaireRequest.getPosition());
        fonctionnaire.setContact(fonctionnaireRequest.getContact());
        fonctionnaire.setCreatedBy(fonctionnaireRequest.getCreatedBy());
        fonctionnaire.setCreateTime(LocalDateTime.now());

        return fonctionnaireRepository.save(fonctionnaire);
    }


    @Override
    public ResponseTemplateVO getFonctionnairewithStructure(String id) {
        log.info("methode getFonctionnairewithStructure de FonctionnaireService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<Fonctionnaire> fonctionnaire = fonctionnaireRepository.findById(id);
        if(fonctionnaire.isPresent()) {
            Fonctionnaire m = fonctionnaire.get();
            // then your usual logic

            Structure structure = restTemplate.getForObject("http://STRUCTURE-SERVICE/structures/"+m.getStructureId(), Structure.class);
            vo.setFonctionnaire(fonctionnaire.get());
            vo.setStructure(structure);
            return vo;
        }
        else {
            return null;
        }

    }


    @Override
    public ResponseTemplateVO getFonctionnaireByidentifiantwithOrganisme(String identifiant) {
        log.info("methode getFonctionnairewithOrganisme de FonctionnaireService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<Fonctionnaire> fonctionnaire = fonctionnaireRepository.findByIdentifiant(identifiant);
        if(fonctionnaire.isPresent()) {
            Fonctionnaire m = fonctionnaire.get();
            // then your usual logic

            Structure structure = restTemplate.getForObject("http://STRUCTURE-SERVICE/structures/key/organisme/"+m.getOrganismeId(), Structure.class);

            vo.setFonctionnaire(fonctionnaire.get());
            vo.setStructure(structure);
            return vo;
        }
        else {
            return null;
        }

    }


}
