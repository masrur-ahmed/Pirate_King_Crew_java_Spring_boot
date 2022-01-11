package com.example.zorodemo.zorodemo.controller;

import com.example.zorodemo.zorodemo.model.Pirates;
import com.example.zorodemo.zorodemo.service.PirateAppService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pirateapi")
@Api(value = "PIrate Information")
public class PirateController {
    @Autowired
    public PirateAppService pirateAppService;



    @PostMapping("/pirate/")
    public Pirates savePirate(@RequestBody Pirates pirate) {

        return pirateAppService.savePirate(pirate);
    }

    @GetMapping("/pirate/{id}")
    public Pirates getPirate(@PathVariable("id") String crewid) {

        return pirateAppService.getPirate(crewid);
    }

    @DeleteMapping("/pirate/{id}")
    public String deletePirate(@PathVariable("id") String crewid) {

        return  pirateAppService.deletePirate(crewid);
    }

    @PutMapping("/pirate/{id}")
    public String updatePirate(@PathVariable("id") String crewid, @RequestBody Pirates pirate) {
        return pirateAppService.updatePirate(crewid,pirate);
    }

    @GetMapping(path = "/pirate/damage/{id}/{count}")
    public List<String> getBestDamage(@PathVariable("id") String crewid, @PathVariable("count") int count, @RequestBody Pirates pirate){


        return null;
    }
}
