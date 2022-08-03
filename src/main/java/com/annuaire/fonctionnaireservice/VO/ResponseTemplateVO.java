package com.annuaire.fonctionnaireservice.VO;

import com.annuaire.fonctionnaireservice.model.Fonctionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description Value Object for resttemplate

 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Fonctionnaire fonctionnaire;
    private Structure structure;
}
