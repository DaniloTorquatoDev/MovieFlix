package com.movieflix.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest(@Schema(type = "string", description = "Nome do filme")
                           @NotEmpty(message = "O titulo do filme é obrigatório.")
                           String title,
                           @Schema(type = "string", description = "Descrição do filme")
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           @Schema(type = "data", description = "data de lançamento do filme. Ex: 27/08/2025")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Score do filme. Ex: 9.5")
                           double rating,
                           @Schema(type = "array", description = "Lista de códigos de categoria")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de códigos de serviços de streamings")
                           List<Long> streamings
) {
}
