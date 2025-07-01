package com.coderefer.learnspringrest.entity;

import java.util.Objects;

public class PostV2 extends Post {
    private String category;

    public PostV2() {
        super();
    }

    public PostV2(int id, String title, String body, int userId, String category) {
        super(id, title, body, userId);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PostV2 postV2 = (PostV2) o;
        return Objects.equals(category, postV2.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category);
    }

    @Override
    public String toString() {
        return "PostV2{" +
                "category='" + category + '\'' +
                "} " + super.toString();
    }
} 