package com.coderefer.runner;

import com.coderefer.document.Medal;
import com.coderefer.document.Player;
import com.coderefer.document.Sport;
import com.coderefer.service.ISportMgmtService;
import com.coderefer.utils.MedalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Component
public class AssociationsTestRunner implements CommandLineRunner {
    @Autowired
    private ISportMgmtService service;
    @Override
    public void run(String... args) throws Exception {
        Player player = new Player();
        player.setId(new Random().nextInt(10000));
        player.setPname("Neeraj Chopra");
        player.setPaddrs("Haryana");
        player.setCountry("India");

        Sport sport = new Sport();
        sport.setId((long) new Random().nextInt(10000));
        sport.setName("Javelin");
        sport.setKits(new String[]{"stick", "suit"});
        sport.setTeamSport(false);
        sport.setOlympicSport(true);

        Sport sport2 = new Sport();
        sport2.setId((long) new Random().nextInt(10000));
        sport2.setOlympicSport(false);
        sport2.setName("Cricket");
        sport2.setKits(new String[]{"Bat", "Ball", "Wickets", "Pads"});
        sport2.setTeamSport(false);

        Medal medal1 = new Medal();
        medal1.setId(UUID.randomUUID().toString());
        medal1.setType(MedalType.GOLD);
        medal1.setPrizeMoney(10000000.0);
        medal1.setSportName("Javelin");
        medal1.setEventName("Tokyo-Olympics-2021");
        Medal medal2 = new Medal();
        medal2.setId(UUID.randomUUID().toString());
        medal2.setType(MedalType.GOLD);
        medal2.setPrizeMoney(10000000.0);
        medal2.setSportName("Javelin");
        medal2.setEventName("Rio-Olympics-2016");
        player.setSports(Set.of(sport, sport2));
        player.setMedals(Map.of("tokyo", medal1, "rio",medal2));

        try {
            System.out.println(service.registerPlayer(player));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
