package com.coderefer.service;

import com.coderefer.document.Player;
import com.coderefer.repo.IPlayerRepo;
import com.coderefer.repo.IMedalRepo;
import com.coderefer.repo.ISportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rtoMgmtService")
public class SportMgmtServiceImpl implements ISportMgmtService {
    @Autowired
    private IMedalRepo repo;
    @Autowired
    private IPlayerRepo playerRepo;

    @Autowired
    private ISportRepo sportRepo;

    @Override
    public String registerPlayer(Player player) {
        return "Player is registered with id: " + playerRepo.save(player).getId();
    }
}
