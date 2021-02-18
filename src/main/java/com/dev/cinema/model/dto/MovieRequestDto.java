package com.dev.cinema.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MovieRequestDto {
    @NotNull
    @Min(4)
    private String title;
    @NotNull
    private String description;

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
        return "MovieRequestDto{"
            + "title='" + title + '\''
            + ", description='" + description + '\''
            + '}';
    }
}
