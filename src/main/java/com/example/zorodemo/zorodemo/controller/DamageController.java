package com.example.zorodemo.zorodemo.controller;

import com.example.zorodemo.zorodemo.entity.Damage;
import com.example.zorodemo.zorodemo.entity.Pirates;
import com.example.zorodemo.zorodemo.repository.DamageRepository;
import com.example.zorodemo.zorodemo.service.DamageServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DamageController {
    private final DamageServiceImpl dmgService;

    public DamageController() {
        dmgService =  new DamageServiceImpl();
    }

    @PostMapping("/move")
    public Damage save(@RequestBody Damage dmg) {

        return dmgService.save(dmg);
    }

    @GetMapping("/damage/{id}")
    public Damage getMoveById(@PathVariable("id") int moveid) {

        return dmgService.getMoveById(moveid);
    }

    @DeleteMapping("/damage/{id}")
    public String deleteMove(@PathVariable("id") int moveid) {

        return  dmgService.deleteMove(moveid);
    }

    @PutMapping("/damage/{id}")
    public int update(@PathVariable("id") int moveid, @RequestBody Damage dmg) {
        return dmgService.update(moveid, dmg );
    }

    @GetMapping(path = "/damage/{id}/{count}")
    public List<String> getBestDamage(@PathVariable("id") String crewid, @PathVariable("count") int count, @RequestBody Pirates pirate){


        return null;
    }
}


