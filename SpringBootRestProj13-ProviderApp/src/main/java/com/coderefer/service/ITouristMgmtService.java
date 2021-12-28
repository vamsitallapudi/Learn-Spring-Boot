package com.coderefer.service;

import java.util.List;

import com.coderefer.entity.Tourist;
import com.coderefer.exception.TouristNotFoundException;

public interface ITouristMgmtService {
     public   String  registerTourist(Tourist tourist);
     public   List<Tourist> fetchAllTourists();
     public   Tourist   fetchTouristById(Integer tid)throws TouristNotFoundException;
     public    String   updateTouristDetails(Tourist tourist)throws TouristNotFoundException;
    public  String    deleteTourist(Integer tid)throws TouristNotFoundException;
    public  String  updateTouristBudgetById(Integer id, Float hikePercent)throws TouristNotFoundException;
}
