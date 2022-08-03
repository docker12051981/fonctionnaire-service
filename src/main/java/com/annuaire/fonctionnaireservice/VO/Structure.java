package com.annuaire.fonctionnaireservice.VO;

import com.annuaire.fonctionnaireservice.model.Adresse;
import com.annuaire.fonctionnaireservice.model.Scontact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description value object resttemplate

 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Structure {
    private String id;
    private Integer key;
    private String title;
    private String abr_fr;
}

