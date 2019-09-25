package com.ing.dto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FavouriteDto {
List<FavouriteResponseDto> data;
private Integer count;
}