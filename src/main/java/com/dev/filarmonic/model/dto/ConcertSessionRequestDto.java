package com.dev.filarmonic.model.dto;

import javax.validation.constraints.NotNull;

public class ConcertSessionRequestDto {
    @NotNull
    private Long stageId;
    @NotNull
    private Long concertId;
    @NotNull
    private String showTime;

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "ConcertSessionRequestDto{"
            + "stageId=" + stageId
            + ", concertId=" + concertId
            + ", showTime='" + showTime + '\''
            + '}';
    }
}
