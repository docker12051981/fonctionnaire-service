package com.annuaire.fonctionnaireservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description entity for fonction

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "fonction")
public class Fonction {
    @Id
    private String id;
    @Indexed(unique = true)
    private String code;
    @NotNull
    private String lib_fr;
    @NotNull
    private String lib_ar;
    private String createdBy;
    private LocalDateTime createTime;
}
