package com.carewise.article.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.carewise.article.dto.HealthArticleRequestDTO;
import com.carewise.article.dto.HealthArticleResponseDTO;
import com.carewise.article.entity.HealthArticle;
import com.carewise.article.repository.HealthArticleRepository;
import com.carewise.article.service.HealthArticleService;
import com.carewise.exception.ResourceNotFoundException;

@Service
public class HealthArticleServiceImpl implements HealthArticleService {

    private final HealthArticleRepository healthArticleRepository;

    public HealthArticleServiceImpl(
            HealthArticleRepository healthArticleRepository) {

        this.healthArticleRepository = healthArticleRepository;
    }

    @Override
    public HealthArticleResponseDTO createArticle(
            HealthArticleRequestDTO requestDTO) {

        HealthArticle article = new HealthArticle();

        article.setTitle(requestDTO.getTitle());
        article.setCategory(requestDTO.getCategory());
        article.setContent(requestDTO.getContent());
        article.setAuthor(requestDTO.getAuthor());

        HealthArticle savedArticle =
                healthArticleRepository.save(article);

        return convertToResponseDTO(savedArticle);
    }

    @Override
    public HealthArticleResponseDTO getArticleById(Long id) {

        HealthArticle article = healthArticleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Health article not found with id: " + id));

        return convertToResponseDTO(article);
    }

    @Override
    public List<HealthArticleResponseDTO> getAllArticles() {

        List<HealthArticle> articles =
                healthArticleRepository.findAll();

        return articles.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HealthArticleResponseDTO updateArticle(
            Long id,
            HealthArticleRequestDTO requestDTO) {

        HealthArticle article = healthArticleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Health article not found with id: " + id));

        article.setTitle(requestDTO.getTitle());
        article.setCategory(requestDTO.getCategory());
        article.setContent(requestDTO.getContent());
        article.setAuthor(requestDTO.getAuthor());

        HealthArticle updatedArticle =
                healthArticleRepository.save(article);

        return convertToResponseDTO(updatedArticle);
    }

    @Override
    public void deleteArticle(Long id) {

        HealthArticle article = healthArticleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Health article not found with id: " + id));

        healthArticleRepository.delete(article);
    }

    private HealthArticleResponseDTO convertToResponseDTO(
            HealthArticle article) {

        HealthArticleResponseDTO responseDTO =
                new HealthArticleResponseDTO();

        responseDTO.setId(article.getId());
        responseDTO.setTitle(article.getTitle());
        responseDTO.setCategory(article.getCategory());
        responseDTO.setContent(article.getContent());
        responseDTO.setAuthor(article.getAuthor());
        responseDTO.setCreatedAt(article.getCreatedAt());

        return responseDTO;
    }
}