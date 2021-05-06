package com.bandwith.dto.like;

public class LikeOnRecordDto {
    int memberId;
    int recordId;

    public LikeOnRecordDto() {

    }

    public LikeOnRecordDto(int memberId, int recordId) {
        this.memberId = memberId;
        this.recordId = recordId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }
}
