package com.carewise.article.dto;

import jakarta.validation.constraints.NotBlank;

public class HealthArticleRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String category;

    @NotBlank
    private String content;

    @NotBlank
    private String author;

    public HealthArticleRequestDTO() {

    }

    public HealthArticleRequestDTO(String title,
                                   String category,
                                   String content,
                                   String author) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "HealthArticleRequestDTO [title=" + title
                + ", category=" + category
                + ", content=" + content
                + ", author=" + author + "]";
    }
}