package com.nt.service;

import com.nt.entity.Tourist;
import com.nt.exceptions.TouristNotFoundException;

import java.util.List;

public interface ITouristMgmtService {
    String registerTourist(Tourist tourist);
    List<Tourist> fetchAllTourist();
    Tourist findTouristById(Integer id) throws TouristNotFoundException;
    String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
}
