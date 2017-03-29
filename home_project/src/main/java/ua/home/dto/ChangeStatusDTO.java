package ua.home.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChangeStatusDTO {

    @NotNull
    private String id;
    private String status;
}