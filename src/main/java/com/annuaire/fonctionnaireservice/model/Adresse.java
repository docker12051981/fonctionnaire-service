package com.annuaire.fonctionnaireservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description entity for adresse

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
    private String gouvernorat_fr;
    private String gouvernorat_ar;
    private String ville_fr;
    private String ville_ar;
    private String rue_fr;
    private String rue_ar;
    private String num;
    private String postal;
}
