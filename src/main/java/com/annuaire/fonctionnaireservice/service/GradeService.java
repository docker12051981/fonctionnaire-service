package com.annuaire.fonctionnaireservice.service;
import com.annuaire.fonctionnaireservice.dto.GradeDto;
import com.annuaire.fonctionnaireservice.model.Grade;
import com.annuaire.fonctionnaireservice.repository.IGradeRepository;
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

 * @description Grade service

 */

@Service
public class GradeService implements IGradeService{

    @Autowired
    private IGradeRepository gradeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    Converter converter;

    @Override
    public Grade saveGrade(GradeDto gradeDto)
    {
        Grade grade = converter.grade_dtoToEntity(gradeDto);
        grade.setCreateTime(LocalDateTime.now());
        return gradeRepository.save(grade);
    }


    @Override
    public Grade findGradeById(String id) {
        Optional<Grade> result = gradeRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new InvalidConfigurationPropertyValueException("Grade", "id", id);
        }
    }


    @Override
    public Boolean deleteGrade(String id) {
        gradeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Grade> findAllGrade()
    {
        return gradeRepository.findAll();
    }

    @Override
    public Grade updateGrade(String id, Grade gradeRequest) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("grade", "id", id));

        grade.setCode(gradeRequest.getCode());
        grade.setLib_fr(gradeRequest.getLib_fr());
        grade.setLib_ar(gradeRequest.getLib_ar());

        return gradeRepository.save(grade);
    }

}
