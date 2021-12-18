package com.coderefer.service;

import com.coderefer.entity.Tourist;
import com.coderefer.exceptions.TouristNotFoundException;

import java.util.List;

public interface ITouristMgmtService {
    String registerTourist(Tourist tourist);
    List<Tourist> fetchAllTourist();
    Tourist findTouristById(Integer id) throws TouristNotFoundException;
    String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
}
