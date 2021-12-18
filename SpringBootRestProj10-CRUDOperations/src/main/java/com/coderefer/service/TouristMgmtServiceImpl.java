package com.coderefer.service;

import com.coderefer.entity.Tourist;
import com.coderefer.exceptions.TouristNotFoundException;
import com.coderefer.repo.ITouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService{

    @Autowired
    private ITouristRepo repo;

    @Override
    public String registerTourist(Tourist tourist) {
        int id = repo.save(tourist).getTId();
        return "student is registered successfully with id: " + id;
    }

    @Override
    public List<Tourist> fetchAllTourist() {
        List<Tourist> list  = repo.findAll();
        list.sort(Comparator.comparing(Tourist::getTId));
        return list;
    }

    @Override
    public Tourist findTouristById(Integer id) throws TouristNotFoundException {
        return repo.findById(id).orElseThrow(()-> new TouristNotFoundException(id + "tourist not found"));
    }

    @Override
    public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
        repo.findById(tourist.getTId()).orElseThrow(() -> new TouristNotFoundException(tourist.getTId() + "tourist not found"));
        repo.save(tourist);
        return "Tourist details updated";
    }
}
