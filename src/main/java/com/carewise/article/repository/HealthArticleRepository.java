package com.carewise.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carewise.article.entity.HealthArticle;

@Repository
public interface HealthArticleRepository
        extends JpaRepository<HealthArticle, Long> {

}