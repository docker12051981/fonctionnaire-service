package com.annuaire.fonctionnaireservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author karim hmadi

 * @description date DTO

 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DateNDto {
    private int year;
    private int month;
    private int day;
}
