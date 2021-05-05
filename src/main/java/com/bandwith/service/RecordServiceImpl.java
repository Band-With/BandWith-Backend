package com.bandwith.service;

import com.bandwith.dao.CommentDao;
import com.bandwith.dao.LikeDao;
import com.bandwith.dao.MemberDao;
import com.bandwith.dao.RecordDao;
import com.bandwith.dto.PracDetailDto;
import com.bandwith.dto.SearchRecordDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;
import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("recordServiceBean")
public class RecordServiceImpl implements RecordService {

    private RecordDao recordDao;
    private MemberDao memberDao;
    private CommentDao commentDao;
    private LikeDao likeDao;

    @Autowired
    public RecordServiceImpl(@Qualifier("recordDaoBean") RecordDao recordDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("commentDaoBean") CommentDao commentDao,
                             @Qualifier("likeDaoBean") LikeDao likeDao) {
        this.recordDao = recordDao;
        this.memberDao = memberDao;
        this.commentDao = commentDao;
        this.likeDao = likeDao;
    }

    @Override
    public RecordNameDto getRecordName(int recordId) {
        return recordDao.getRecordName(recordId);
    }

    @Override
    public void uploadRecord(RecordInsertDto recordDto) {
        recordDao.insertRecord(recordDto);
        System.out.println("upload record service");
    }

    @Override
    public void deleteRecord(int recordId) {
        recordDao.deleteRecord(recordId);
        System.out.println("delete record service");
    }

    @Override
    public List<SearchRecordDto> getRecords(int musicId, String filter) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("musicId", musicId);
        params.put("filter", filter);

        List<RecordDto> recordDtoList = RecordDto.of(recordDao.selectRecordsByFilter(params));
        List<SearchRecordDto> searchRecordDtoList = new ArrayList<>();

        for (RecordDto recordDto : recordDtoList) {
            MemberBasicDto memberBasicDto = MemberBasicDto.of(memberDao.selectMember(recordDto.getMember_id()));
            int likeNum = likeDao.countLike(recordDto.getRecord_id());
            int commentNum = commentDao.countComment(recordDto.getRecord_id());

            searchRecordDtoList.add(new SearchRecordDto(recordDto, memberBasicDto, likeNum, commentNum));
        }

        return searchRecordDtoList;
    }
}
