package com.ing.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavouriteResponseDto {
private String accountName;
private String bankName;
private String IBANNumber;

private LocalDate date;
}
