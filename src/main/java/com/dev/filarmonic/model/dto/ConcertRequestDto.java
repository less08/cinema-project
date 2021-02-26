package com.dev.filarmonic.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConcertRequestDto {
    @NotNull
    @Size(min = 4)
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
        return "ConcertRequestDto{"
            + "title='" + title + '\''
            + ", description='" + description + '\''
            + '}';
    }
}
