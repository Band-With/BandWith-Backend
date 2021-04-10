package com.bandwith.dao;


import com.bandwith.domain.Record;
import java.util.List;

public interface RecordDao {
    List<Record> selectRecords(String username);
}
