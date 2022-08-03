package com.annuaire.fonctionnaireservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author karim hmadi

 * @description grade DTO

 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradeDto {
    private String id;
    private String code;
    private String lib_fr;
    private String lib_ar;
    private String createdBy;
    private LocalDateTime createTime;
}
