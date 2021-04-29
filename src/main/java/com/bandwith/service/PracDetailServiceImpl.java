package com.bandwith.service;

import com.bandwith.dao.CommentDao;
import com.bandwith.dao.LikeDao;
import com.bandwith.dao.MusicDao;
import com.bandwith.dao.RecordDao;
import com.bandwith.dto.PracDetailDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("pracDetailServiceBean")
public class PracDetailServiceImpl implements PracDetailService {
    private MusicDao musicDao;
    private RecordDao recordDao;
    private CommentDao commentDao;
    private LikeDao likeDao;

    @Autowired
    public PracDetailServiceImpl(@Qualifier("musicDaoBean") MusicDao musicDao,
                                 @Qualifier("recordDaoBean") RecordDao recordDao,
                                 @Qualifier("commentDaoBean") CommentDao commentDao,
                                 @Qualifier("likeDaoBean") LikeDao likeDao) {
        this.musicDao = musicDao;
        this.recordDao = recordDao;
        this.commentDao = commentDao;
        this.likeDao = likeDao;
    }

    public PracDetailDto getPracDetail(String username, String title, Boolean condition){
        List<HashMap<String, Object>> details = new ArrayList<>();
        List<RecordDto> recordDtoList;


        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("username", username);
        params.put("title", title);
        params.put("condition", condition);

        recordDtoList = RecordDto.of(recordDao.selectRecordsByTitle(params));

        for(RecordDto recordDto: recordDtoList) {
            HashMap<String, Object> detail = new HashMap<>();

            int likeNum = likeDao.countLike(recordDto.getRecord_id());
            int commentNum = commentDao.countComment(recordDto.getRecord_id());

            detail.put("records", recordDto);
            detail.put("likeNum", likeNum);
            detail.put("commentNum", commentNum);

            details.add(detail);
        }
        return new PracDetailDto(MusicDto.of(musicDao.selectMusicByTitle(title)), details);
    };

}
