package com.annuaire.fonctionnaireservice.controller;

import com.annuaire.fonctionnaireservice.VO.ResponseTemplateVO;
import com.annuaire.fonctionnaireservice.dto.FonctionnaireDto;
import com.annuaire.fonctionnaireservice.model.Fonctionnaire;
import com.annuaire.fonctionnaireservice.service.IFonctionnaireService;
import com.annuaire.fonctionnaireservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author karim hmadi

 * @description fonctionnaire controller

 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fonctionnaires")
public class FonctionnaireController {

    private IFonctionnaireService fonctionnaireService;
    public FonctionnaireController(IFonctionnaireService fonctionnaireService) {
        super();
        this.fonctionnaireService = fonctionnaireService;
    }
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public ResponseEntity<FonctionnaireDto> createFonctionnaire(@RequestBody FonctionnaireDto fonctionnaireDto)
    {
        FonctionnaireDto fonctionnaire= converter.entityToDto(fonctionnaireService.saveFonctionnaire(fonctionnaireDto));
        return new ResponseEntity<>(fonctionnaire, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structure/{idstructure}")
    public ResponseEntity<List<FonctionnaireDto>> findByStructure(@PathVariable String idstructure)
    {
        List<Fonctionnaire> findfonctionnairesbystructure= fonctionnaireService.findFonctionnaireByStructure(idstructure);
        return new ResponseEntity<List<FonctionnaireDto>>(converter.entityToDto(findfonctionnairesbystructure), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/structureId/{idstructure}")
    public ResponseEntity<List<FonctionnaireDto>> findByStructureId(@PathVariable String idstructure)
    {
        List<Fonctionnaire> findfonctionnairesbystructureId= fonctionnaireService.findFonctionnaireByStructureId(idstructure);
        return new ResponseEntity<List<FonctionnaireDto>>(converter.entityToDto(findfonctionnairesbystructureId), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/organismeId/{idorganisme}")
    public ResponseEntity<List<FonctionnaireDto>> findByOrganismeId(@PathVariable String idorganisme)
    {
        List<Fonctionnaire> findfonctionnairesbyorganismeId= fonctionnaireService.findFonctionnaireByOrganismeId(idorganisme);
        return new ResponseEntity<List<FonctionnaireDto>>(converter.entityToDto(findfonctionnairesbyorganismeId), HttpStatus.OK);
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<FonctionnaireDto> getStructureById(@PathVariable(name = "id") String id) {
        Fonctionnaire fonctionnaire= fonctionnaireService.findFonctionnaireById(id);
        // convert entity to DTO
        FonctionnaireDto fonctionnaireResponse = converter.entityToDto(fonctionnaire);
        return ResponseEntity.ok().body(fonctionnaireResponse);
    }*/
   @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseTemplateVO getFonctionnairewithStructure(@PathVariable("id") String id)
    {
        return fonctionnaireService.getFonctionnairewithStructure(id);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/identifiant/{identifiant}")

    public ResponseTemplateVO getFonctionnaireByidentifiantwithOrganisme(@PathVariable("identifiant") String identifiant)
    {
        return fonctionnaireService.getFonctionnaireByidentifiantwithOrganisme(identifiant);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteFonctionnaire(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = fonctionnaireService.deleteFonctionnaire(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public ResponseEntity<List<FonctionnaireDto>> findAll() {
        List<Fonctionnaire> findAll = fonctionnaireService.findAllFonctionnaires();
        return new ResponseEntity<List<FonctionnaireDto>>(converter.entityToDto(findAll), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<FonctionnaireDto> updateFonctionnaire(@PathVariable String id, @RequestBody FonctionnaireDto fonctionnaireDto) {
        // convert DTO to Entity
        Fonctionnaire fonctionnaireRequest = converter.dtoToEntity(fonctionnaireDto);
        Fonctionnaire fonctionnaire = fonctionnaireService.updateFonctionnaire(id, fonctionnaireRequest);
        // entity to DTO
        FonctionnaireDto fonctionnaireResponse = converter.entityToDto(fonctionnaire);
        return ResponseEntity.ok().body(fonctionnaireResponse);
    }

}
