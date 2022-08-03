package com.annuaire.fonctionnaireservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description fonction DTO

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FonctionDto {
    private String id;
    private String code;
    private String lib_fr;
    private String lib_ar;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
