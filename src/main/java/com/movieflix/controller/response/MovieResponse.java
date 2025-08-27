package com.movieflix.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "long", description = "Código do filme.")
                            Long id,
                            @Schema(type = "string", description = "Título do filme.")
                            String title,
                            @Schema(type = "string", description = "Descrição do filme")
                            String description,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            @Schema(type = "data", description = "Data de lançamento do filme. Ex:27/08/2025")
                            LocalDate releaseDate,
                            @Schema(type = "double", description = "Score do filme.L")
                            double rating,
                            @Schema(type = "array", description = "Lista de códigos de categoria")
                            List<CategoryResponse> categories,
                            @Schema(type = "array", description = "Lista de códigos de serviços de streamings")
                            List<StreamingResponse> streamings
) {
}
