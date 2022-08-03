package com.annuaire.fonctionnaireservice.controller;

import com.annuaire.fonctionnaireservice.dto.DiplomeDto;
import com.annuaire.fonctionnaireservice.model.Diplome;
import com.annuaire.fonctionnaireservice.service.IDiplomeService;
import com.annuaire.fonctionnaireservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiplomeController {
    private IDiplomeService diplomeService;
    public DiplomeController(IDiplomeService diplomeService) {
        super();
        this.diplomeService = diplomeService;
    }
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/fonctionnaires/diplome/add")
    public ResponseEntity<DiplomeDto> createDiplome(@RequestBody DiplomeDto diplomeDto)
    {
        DiplomeDto diplome= converter.diplome_entityToDto(diplomeService.saveDiplome(diplomeDto));
        return new ResponseEntity<>(diplome, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/diplome/{id}")
    public ResponseEntity<DiplomeDto> getDiplomeById(@PathVariable(name = "id") String id) {
        Diplome diplome= diplomeService.findDiplomeById(id);
        // convert entity to DTO
        DiplomeDto diplomeResponse = converter.diplome_entityToDto(diplome);
        return ResponseEntity.ok().body(diplomeResponse);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/diplomes/")
    public ResponseEntity<List<DiplomeDto>> findAll() {
        List<Diplome> findAll = diplomeService.findAllDiplome();
        return new ResponseEntity<List<DiplomeDto>>(converter.diplome_entityToDto(findAll), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/fonctionnaires/diplomes/{id}")
    public ResponseEntity<Boolean> deleteDiplome(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = diplomeService.deleteDiplome(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/fonctionnaires/diplomes/{id}")
    public ResponseEntity<DiplomeDto> updateDiplome(@PathVariable String id, @RequestBody DiplomeDto diplomeDto) {
        // convert DTO to Entity
        Diplome diplomeRequest = converter.diplome_dtoToEntity(diplomeDto);
        Diplome diplome = diplomeService.updateDiplome(id, diplomeRequest);
        // entity to DTO
        DiplomeDto diplomeResponse = converter.diplome_entityToDto(diplome);
        return ResponseEntity.ok().body(diplomeResponse);
    }
}
