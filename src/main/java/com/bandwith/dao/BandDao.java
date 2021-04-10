package com.bandwith.dao;

import com.bandwith.domain.Band;
import java.util.List;

public interface BandDao {
    List<Band> selectBands(String username);
}
