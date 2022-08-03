package com.annuaire.fonctionnaireservice.controller;
import com.annuaire.fonctionnaireservice.dto.FonctionDto;
import com.annuaire.fonctionnaireservice.model.Fonction;
import com.annuaire.fonctionnaireservice.service.IFonctionService;
import com.annuaire.fonctionnaireservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author karim hmadi

 * @description fonction controller

 */

@RestController
public class FonctionController {

    private IFonctionService fonctionService;
    public FonctionController(IFonctionService fonctionService) {
        super();
        this.fonctionService = fonctionService;
    }
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/fonctionnaires/fonctions/add")
    public ResponseEntity<FonctionDto> createFonction(@RequestBody FonctionDto fonctionDto)
    {
        FonctionDto fonction= converter.fonc_entityToDto(fonctionService.saveFonction(fonctionDto));
        return new ResponseEntity<>(fonction, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/fonctions/{id}")
    public ResponseEntity<FonctionDto> getFonctionById(@PathVariable(name = "id") String id) {
        Fonction fonction= fonctionService.findFonctionById(id);
        // convert entity to DTO
        FonctionDto fonctionResponse = converter.fonc_entityToDto(fonction);
        return ResponseEntity.ok().body(fonctionResponse);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/fonctions/")
    public ResponseEntity<List<FonctionDto>> findAll() {
        List<Fonction> findAll = fonctionService.findAllFonction();
        return new ResponseEntity<List<FonctionDto>>(converter.fonc_entityToDto(findAll), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/fonctionnaires/fonctions/{id}")
    public ResponseEntity<Boolean> deleteFonction(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = fonctionService.deleteFonction(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/fonctionnaires/fonctions/{id}")
    public ResponseEntity<FonctionDto> updateFonction(@PathVariable String id, @RequestBody FonctionDto fonctionDto) {
        // convert DTO to Entity
        Fonction fonctionRequest = converter.fonc_dtoToEntity(fonctionDto);
        Fonction fonction = fonctionService.updateFonction(id, fonctionRequest);
        // entity to DTO
        FonctionDto fonctionResponse = converter.fonc_entityToDto(fonction);
        return ResponseEntity.ok().body(fonctionResponse);
    }
}
