package com.dev.filarmonic.model.dto;

public class ConcertSessionResponseDto {
    private Long concertSessionId;
    private String showTime;
    private String concertTitle;
    private Long stageId;

    public Long getConcertSessionId() {
        return concertSessionId;
    }

    public void setConcertSessionId(Long concertSessionId) {
        this.concertSessionId = concertSessionId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getConcertTitle() {
        return concertTitle;
    }

    public void setConcertTitle(String concertTitle) {
        this.concertTitle = concertTitle;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    @Override
    public String toString() {
        return "ConcertSessionResponseDto{"
            + "concertSessionId=" + concertSessionId
            + ", showTime='" + showTime + '\''
            + ", concertTitle='" + concertTitle + '\''
            + ", stageId=" + stageId
            + '}';
    }
}
