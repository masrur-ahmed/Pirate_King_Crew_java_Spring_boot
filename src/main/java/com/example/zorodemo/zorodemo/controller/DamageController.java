package com.example.zorodemo.zorodemo.controller;

import com.example.zorodemo.zorodemo.model.Damage;
import com.example.zorodemo.zorodemo.model.Pirates;
import com.example.zorodemo.zorodemo.service.DamageService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/damageapi")
@Api(value = "Damage Information")
public class DamageController {
    private final DamageService dmgService;
    public DamageController(DamageService damageService) {
        this.dmgService =  damageService;
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

    @GetMapping(path = "/damage/{count}")
    public List<String> getBestDamage(@PathVariable("id") String crewid, @PathVariable("count") int count, @RequestBody Pirates pirate){


        return null;
    }
}


