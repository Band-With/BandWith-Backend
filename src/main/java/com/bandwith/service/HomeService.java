package com.bandwith.service;

import com.bandwith.dto.member.MemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HomeService {
    List<MemberDto> monthlyMembers();
    List<MemberDto> updateMonth();
    void testScheduler();
}
