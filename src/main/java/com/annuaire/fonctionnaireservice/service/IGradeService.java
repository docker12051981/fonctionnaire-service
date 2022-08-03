package com.annuaire.fonctionnaireservice.service;

import com.annuaire.fonctionnaireservice.dto.GradeDto;
import com.annuaire.fonctionnaireservice.model.Grade;

import java.util.List;

/**
 * @author karim hmadi

 * @description grade Interface

 */
public interface IGradeService {
    Grade saveGrade(GradeDto gradeDto);

    Grade findGradeById(String id);

    List<Grade> findAllGrade();

    Boolean deleteGrade(String id);

    Grade updateGrade(String id, Grade gradeRequest);
}
