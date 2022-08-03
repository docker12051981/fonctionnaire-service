package com.annuaire.fonctionnaireservice.controller;
import com.annuaire.fonctionnaireservice.dto.GradeDto;
import com.annuaire.fonctionnaireservice.model.Grade;
import com.annuaire.fonctionnaireservice.service.IGradeService;
import com.annuaire.fonctionnaireservice.tools.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {

    private IGradeService gradeService;
    public GradeController(IGradeService gradeService) {
        super();
        this.gradeService = gradeService;
    }
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;
    @CrossOrigin(origins = "*")
    @PostMapping("/fonctionnaires/grades/add")
    public ResponseEntity<GradeDto> createGrade(@RequestBody GradeDto gradeDto)
    {
        GradeDto grade= converter.grade_entityToDto(gradeService.saveGrade(gradeDto));
        return new ResponseEntity<>(grade, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/grades/{id}")
    public ResponseEntity<GradeDto> getGradeById(@PathVariable(name = "id") String id) {
        Grade grade= gradeService.findGradeById(id);
        // convert entity to DTO
        GradeDto gradeResponse = converter.grade_entityToDto(grade);
        return ResponseEntity.ok().body(gradeResponse);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/fonctionnaires/grades/")
    public ResponseEntity<List<GradeDto>> findAll() {
        List<Grade> findAll =gradeService.findAllGrade();
        return new ResponseEntity<List<GradeDto>>(converter.grade_entityToDto(findAll), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/fonctionnaires/grades/{id}")
    public ResponseEntity<Boolean> deleteGrade(@PathVariable String id) {
        Boolean deleted = false;
        if(id!=null)
        {
            deleted = gradeService.deleteGrade(id);
        }
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/fonctionnaires/grades/{id}")
    public ResponseEntity<GradeDto> updateGrade(@PathVariable String id, @RequestBody GradeDto gradeDto) {
        // convert DTO to Entity
        Grade gradeRequest = converter.grade_dtoToEntity(gradeDto);
        Grade grade = gradeService.updateGrade(id, gradeRequest);
        // entity to DTO
        GradeDto gradeResponse = converter.grade_entityToDto(grade);
        return ResponseEntity.ok().body(gradeResponse);
    }
}
