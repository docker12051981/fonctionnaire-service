package com.annuaire.fonctionnaireservice.controller;

import com.annuaire.fonctionnaireservice.dto.ClasseDto;

import com.annuaire.fonctionnaireservice.model.Classe;
import com.annuaire.fonctionnaireservice.service.IClasseService;
import com.annuaire.fonctionnaireservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ClasseController {
    private IClasseService classeService;
    public ClasseController(IClasseService classeService) {
        super();
        this.classeService = classeService;
    }
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/fonctionnaires/classe/add")
    public ResponseEntity<ClasseDto> createClasse(@RequestBody ClasseDto classeDto)
    {
        ClasseDto classe= converter.classe_entityToDto(classeService.saveClasse(classeDto));
        return new ResponseEntity<>(classe, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/classes/{id}")
    public ResponseEntity<ClasseDto> getClasseById(@PathVariable(name = "id") String id) {
        Classe classe= classeService.findClasseById(id);
        // convert entity to DTO
        ClasseDto classeResponse = converter.classe_entityToDto(classe);
        return ResponseEntity.ok().body(classeResponse);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/classes/")
    public ResponseEntity<List<ClasseDto>> findAll() {
        List<Classe> findAll = classeService.findAllClasse();
        return new ResponseEntity<List<ClasseDto>>(converter.classe_entityToDto(findAll), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/fonctionnaires/classes/{id}")
    public ResponseEntity<Boolean> deleteClasse(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = classeService.deleteClasse(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/fonctionnaires/classes/{id}")
    public ResponseEntity<ClasseDto> updateClasse(@PathVariable String id, @RequestBody ClasseDto classeDto) {
        // convert DTO to Entity
        Classe classeRequest = converter.classe_dtoToEntity(classeDto);
        Classe classe = classeService.updateClasse(id, classeRequest);
        // entity to DTO
        ClasseDto classeResponse = converter.classe_entityToDto(classe);
        return ResponseEntity.ok().body(classeResponse);
    }
}
