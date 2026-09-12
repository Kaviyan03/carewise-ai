package com.carewise.article.service;

import java.util.List;

import com.carewise.article.dto.HealthArticleRequestDTO;
import com.carewise.article.dto.HealthArticleResponseDTO;

public interface HealthArticleService {

    HealthArticleResponseDTO createArticle(
            HealthArticleRequestDTO requestDTO);

    HealthArticleResponseDTO getArticleById(Long id);

    List<HealthArticleResponseDTO> getAllArticles();

    HealthArticleResponseDTO updateArticle(
            Long id,
            HealthArticleRequestDTO requestDTO);

    void deleteArticle(Long id);
}