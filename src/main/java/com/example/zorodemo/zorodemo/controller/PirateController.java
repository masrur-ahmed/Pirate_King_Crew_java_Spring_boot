package com.example.zorodemo.zorodemo.controller;

import com.example.zorodemo.zorodemo.entity.Pirates;
import com.example.zorodemo.zorodemo.repository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PirateController {

    private PirateRepository pirateRepository = new PirateRepository();

    @PostMapping("/pirate")
    public Pirates savePirate(@RequestBody Pirates pirate) {

        return pirateRepository.save(pirate);
    }

    @GetMapping("/pirate/{id}")
    public Pirates getPirate(@PathVariable("id") String crewid) {

        return pirateRepository.getCrewById(crewid);
    }

    @DeleteMapping("/pirate/{id}")
    public String deletePirate(@PathVariable("id") String crewid) {

        return  pirateRepository.delete(crewid);
    }

    @PutMapping("/pirate/{id}")
    public String updatePirate(@PathVariable("id") String crewid, @RequestBody Pirates pirate) {
        return pirateRepository.update(crewid,pirate);
    }

    @GetMapping(path = "/pirate/damage/{id}/{count}")
    public List<String> getBestDamage(@PathVariable("id") String crewid, @PathVariable("count") int count, @RequestBody Pirates pirate){


        return null;
    }
}
