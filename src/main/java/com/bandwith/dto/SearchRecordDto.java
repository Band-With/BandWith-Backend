package com.bandwith.dto;

import com.bandwith.dto.record.RecordDto;
import com.bandwith.dto.member.MemberBasicDto;

public class SearchRecordDto implements Comparable<SearchRecordDto>{
    private RecordDto record;
    private MemberBasicDto member;
    private int likeNum;
    private int commentNum;
    private String filter="latest";

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public SearchRecordDto(RecordDto record, MemberBasicDto member, int likeNum, int commentNum) {
        this.record = record;
        this.member = member;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
    }



    public RecordDto getRecord() {
        return record;
    }

    public void setRecord(RecordDto record) {
        this.record = record;
    }

    public MemberBasicDto getMember() {
        return member;
    }

    public void setMember(MemberBasicDto member) {
        this.member = member;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }


    @Override
    public int compareTo(SearchRecordDto o) {

        if (this.getFilter().equals("like")) {
            if (this.getLikeNum() > o.getLikeNum()) {
                return 1;
            } else if (this.getLikeNum() < o.getLikeNum()) {
                return -1;
            } else {
                return 0;
            }
        }
        return 1;
    }
}
