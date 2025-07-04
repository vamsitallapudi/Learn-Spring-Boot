package com.coderefer.learnspringrest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostV2 extends Post {
    private String category;
    private String author;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;
    
    private List<String> tags;
    private int likes;
    private int views;
    private boolean isPublished;
    private String featuredImageUrl;
    private List<String> comments;

    public PostV2() {
        super();
    }

    public PostV2(int id, String title, String body, int userId, String category, String author,
                  LocalDateTime createdAt, LocalDateTime updatedAt, List<String> tags, int likes, 
                  int views, boolean isPublished, String featuredImageUrl, List<String> comments) {
        super(id, title, body, userId);
        this.category = category;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tags = tags;
        this.likes = likes;
        this.views = views;
        this.isPublished = isPublished;
        this.featuredImageUrl = featuredImageUrl;
        this.comments = comments;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public void setFeaturedImageUrl(String featuredImageUrl) {
        this.featuredImageUrl = featuredImageUrl;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PostV2 postV2 = (PostV2) o;
        return likes == postV2.likes &&
                views == postV2.views &&
                isPublished == postV2.isPublished &&
                Objects.equals(category, postV2.category) &&
                Objects.equals(author, postV2.author) &&
                Objects.equals(createdAt, postV2.createdAt) &&
                Objects.equals(updatedAt, postV2.updatedAt) &&
                Objects.equals(tags, postV2.tags) &&
                Objects.equals(featuredImageUrl, postV2.featuredImageUrl) &&
                Objects.equals(comments, postV2.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category, author, createdAt, updatedAt, tags, likes, views, isPublished, featuredImageUrl, comments);
    }

    @Override
    public String toString() {
        return "PostV2{" +
                "category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", tags=" + tags +
                ", likes=" + likes +
                ", views=" + views +
                ", isPublished=" + isPublished +
                ", featuredImageUrl='" + featuredImageUrl + '\'' +
                ", comments=" + comments +
                "} " + super.toString();
    }
} 