package com.annuaire.fonctionnaireservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description contact admin and responsable DTO

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FcontactDto
{
    private String num_tel_prof;
    private String num_fax;
    private String poste;
    private String num_tel_perso;
    private String email_prof;
    private String email_perso;
    private String social_linkdin;
    private String social_facebook;
    private String social_twitter;
}
