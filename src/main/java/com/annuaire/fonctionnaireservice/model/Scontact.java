package com.annuaire.fonctionnaireservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description entity for structure contact

 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scontact {
    private String num_tel;
    private String num_tel2;
    private String num_fax;
    private String num_fax2;
    private String email;
    private String site_web;
    private String social_fb;
    private String social_twitter;
    private String social_linkdin;
}
