package com.annuaire.fonctionnaireservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.Email;

/**
 * @author karim hmadi

 * @description entity for contact responsable admin

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fcontact {

    private String num_tel_prof;
    private String num_fax;
    private String poste;
    private String num_tel_perso;
    @Email
    private String email_prof;
    @Email
    private String email_perso;
    private String social_linkdin;
    private String social_facebook;
    private String social_twitter;
    private String skype;
}
