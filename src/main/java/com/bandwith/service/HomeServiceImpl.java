package com.bandwith.service;

import com.bandwith.dto.member.MemberDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("homeServiceBean")
public class HomeServiceImpl implements HomeService {

    @Override
    public List<MemberDto> monthlyMembers() {
        return null;
    }

    @Scheduled(cron = "0 0 0 1 * *") // 매달 1일 00시에
    public List<MemberDto> updateMonth() {
        List<MemberDto> list = null;
        return null;
    }

    @Scheduled(cron = "0 0/1 9-18 * * *")
    public void testScheduler() {
        System.out.println("스케줄링 테스트");
    }
}
