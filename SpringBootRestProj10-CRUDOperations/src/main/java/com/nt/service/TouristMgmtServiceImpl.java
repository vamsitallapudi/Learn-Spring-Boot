package com.nt.service;

import com.nt.entity.Tourist;
import com.nt.repo.ITouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService{

    @Autowired
    private ITouristRepo repo;

    @Override
    public String registerTourist(Tourist tourist) {
        int id = repo.save(tourist).getTId();
        return "student is registered successfully with id: " + id;
    }
}
