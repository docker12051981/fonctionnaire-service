package com.annuaire.fonctionnaireservice.controller;

import com.annuaire.fonctionnaireservice.dto.CategorieDto;
import com.annuaire.fonctionnaireservice.dto.GradeDto;
import com.annuaire.fonctionnaireservice.model.Categorie;
import com.annuaire.fonctionnaireservice.model.Grade;
import com.annuaire.fonctionnaireservice.service.ICategorieService;
import com.annuaire.fonctionnaireservice.service.IGradeService;
import com.annuaire.fonctionnaireservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {
    private ICategorieService categorieService;
    public CategorieController(ICategorieService categorieService) {
        super();
        this.categorieService = categorieService;
    }
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/fonctionnaires/categories/add")
    public ResponseEntity<CategorieDto> creatCategorie(@RequestBody CategorieDto categorieDto)
    {
        CategorieDto categorie= converter.cat_entityToDto(categorieService.saveCategorie(categorieDto));
        return new ResponseEntity<>(categorie, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/categories/{id}")
    public ResponseEntity<CategorieDto> getCategorieById(@PathVariable(name = "id") String id) {
        Categorie categorie= categorieService.findCategorieById(id);
        // convert entity to DTO
        CategorieDto categorieResponse = converter.cat_entityToDto(categorie);
        return ResponseEntity.ok().body(categorieResponse);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/categories/")
    public ResponseEntity<List<CategorieDto>> findAll() {
        List<Categorie> findAll =categorieService.findAllCategie();
        return new ResponseEntity<List<CategorieDto>>(converter.cat_entityToDto(findAll), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/fonctionnaires/categories/{id}")
    public ResponseEntity<Boolean> deleteGrade(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = categorieService.deleteCategorie(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/fonctionnaires/categories/{id}")
    public ResponseEntity<CategorieDto> updateCategorie(@PathVariable String id, @RequestBody CategorieDto categorieDto) {
        // convert DTO to Entity
        Categorie categorieRequest = converter.cat_dtoToEntity(categorieDto);
        Categorie categorie = categorieService.updateCategorie(id, categorieRequest);
        // entity to DTO
        CategorieDto categorieResponse = converter.cat_entityToDto(categorie);
        return ResponseEntity.ok().body(categorieResponse);
    }
}
