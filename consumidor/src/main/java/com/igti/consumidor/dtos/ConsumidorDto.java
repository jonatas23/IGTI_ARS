package com.igti.consumidor.dtos;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class ConsumidorDto implements Serializable {

    @NotBlank
    private String name;
}
