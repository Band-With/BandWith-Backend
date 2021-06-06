package com.bandwith.service;


import com.bandwith.dao.LikeDao;
import com.bandwith.dto.band.BandMontlyDto;
import com.bandwith.dto.member.MemberMonthlyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@EnableScheduling
@Service("scheduledService")
public class ScheduledService {

    LikeDao likeDao;
    List<BandMontlyDto> bandResult;
    List<MemberMonthlyDto> memberResult;

    public List<BandMontlyDto> getBandResult() {
        return bandResult;
    }

    public void setBandResult(List<BandMontlyDto> bandResult) {
        this.bandResult = bandResult;
    }

    public List<MemberMonthlyDto> getMemberResult() {
        return memberResult;
    }

    public void setMemberResult(List<MemberMonthlyDto> memberResult) {
        this.memberResult = memberResult;
    }

    class BandComparator implements Comparator<BandMontlyDto> {
        @Override
        public int compare(BandMontlyDto a, BandMontlyDto b) {
            if (a.getLikes() > b.getLikes()) return -1;
            if (a.getLikes() < b.getLikes()) return 1;
            return 0;
        }
    }

    class MemberComparator implements Comparator<MemberMonthlyDto> {
        @Override
        public int compare(MemberMonthlyDto a, MemberMonthlyDto b) {
            if (a.getLike() > b.getLike()) return -1;
            if (a.getLike() < b.getLike()) return 1;
            return 0;
        }
    }

    //@Scheduled(cron = "0 0 0 1 * *") 매월 1일 0시
    @Scheduled(cron = "0 0 0/9 * * *") //10초마다 수정
    public List<BandMontlyDto> monthlyBand() {
        List<BandMontlyDto> list = likeDao.monthlyBand();
        Collections.sort(list, new BandComparator());
        bandResult = new ArrayList();
        if (list.size() > 4) {
            for (int i = 0; i < 4; i++) {
                bandResult.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                bandResult.add(list.get(i));
            }
        }
        return bandResult;
    }

    //@Scheduled(fixedDelay=10000) //10초마다 수정
    @Scheduled(cron = "0 0 0/9 * * *") //10초마다 수정
    public List<MemberMonthlyDto> monthlyMember() {
        List<MemberMonthlyDto> list = likeDao.monthlyMember();
        Collections.sort(list, new MemberComparator());
        memberResult = new ArrayList();
        if (list.size() > 5) {
            for (int i = 0; i < 5; i++) {
                memberResult.add(list.get(i));
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                memberResult.add(list.get(i));
            }
        }
        return memberResult;
    }

    @Autowired
    public ScheduledService(@Qualifier("likeDaoBean") LikeDao likeDao) {
        this.likeDao = likeDao;
        monthlyBand();
        monthlyMember();
    }

}