package com.movieflix.controller;

import com.movieflix.controller.request.MovieRequest;
import com.movieflix.controller.response.MovieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes.")
public interface MovieController {

    @Operation(summary = "Salvar filme", description = "Método reponsavel por realizar o salvamento de um novo filme.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PostMapping
    ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request);


    @Operation(summary = "Buscar filmes", description = "Método reponsavel por retornar todos os filmes cadastrados.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Retorna todos os filmes cadastrados.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @GetMapping
    ResponseEntity<List<MovieResponse>> findAll();


    @Operation(summary = "Buscar filme por ID", description = "Método reponsavel por realizar buscas atravez do Id informado.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @ApiResponse(responseCode = "404", description = "Filme não encontrado.", content = @Content())
    @GetMapping("/{id}")
    ResponseEntity<MovieResponse> findById(@PathVariable Long id);


    @Operation(summary = "Alterar filme", description = "Método reponsavel por fazer alteração de um filme.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme alterado com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PutMapping("/{id}")
    ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request);


    @Operation(summary = "Buscar filmes por categoria", description = "Método reponsavel por realizar buscas atravez da categoria informada.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filmes encontrados com sucesso.",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    @GetMapping("/search")
    ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category);


    @Operation(summary = "Deletar filme por ID", description = "Método reponsavel por deletar filme.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Filme deletado com sucesso.",
            content = @Content())
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteMovie(@PathVariable Long id);
}
