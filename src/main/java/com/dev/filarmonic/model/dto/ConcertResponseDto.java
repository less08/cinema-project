package com.dev.filarmonic.model.dto;

public class ConcertResponseDto {
    private Long id;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ConcertResponseDto{"
            + "id=" + id
            + ", title='" + title + '\''
            + ", description='" + description + '\''
            + '}';
    }
}
