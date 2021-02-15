package com.dev.cinema.model.dto;

public class MovieSessionRequestDto {
    private Long cinemaHallId;
    private Long movieId;
    private String showTime;

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "MovieSessionRequestDto{"
            + "cinemaHallId=" + cinemaHallId
            + ", movieId=" + movieId
            + ", showTime='" + showTime + '\''
            + '}';
    }
}
