package com.example.zorodemo.zorodemo.service;

import com.example.zorodemo.zorodemo.entity.Pirates;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface PirateAppService {
    public Pirates savePirate(Pirates pirate);
    public Pirates getPirate(String crewid);
    public String deletePirate(String crewid);
    public String updatePirate(String crewid, Pirates pirate);
    public List<String > getBestDamage(String crewid, int count, Pirates pirate);


}
