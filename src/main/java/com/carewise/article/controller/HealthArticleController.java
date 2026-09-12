package com.carewise.article.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carewise.article.dto.HealthArticleRequestDTO;
import com.carewise.article.dto.HealthArticleResponseDTO;
import com.carewise.article.service.HealthArticleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/articles")
public class HealthArticleController {

    private final HealthArticleService healthArticleService;

    public HealthArticleController(
            HealthArticleService healthArticleService) {

        this.healthArticleService = healthArticleService;
    }

    @PostMapping
    public ResponseEntity<HealthArticleResponseDTO> createArticle(
            @Valid @RequestBody HealthArticleRequestDTO requestDTO) {

        HealthArticleResponseDTO responseDTO =
                healthArticleService.createArticle(requestDTO);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthArticleResponseDTO>
            getArticleById(@PathVariable Long id) {

        return ResponseEntity.ok(
                healthArticleService.getArticleById(id));
    }

    @GetMapping
    public ResponseEntity<List<HealthArticleResponseDTO>>
            getAllArticles() {

        return ResponseEntity.ok(
                healthArticleService.getAllArticles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthArticleResponseDTO>
            updateArticle(
                    @PathVariable Long id,
                    @Valid @RequestBody HealthArticleRequestDTO requestDTO) {

        return ResponseEntity.ok(
                healthArticleService.updateArticle(
                        id,
                        requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(
            @PathVariable Long id) {

        healthArticleService.deleteArticle(id);

        return ResponseEntity.ok(
                "Health article deleted successfully");
    }
}