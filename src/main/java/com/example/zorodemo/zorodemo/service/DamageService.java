package com.example.zorodemo.zorodemo.service;

import com.example.zorodemo.zorodemo.entity.Damage;
import com.example.zorodemo.zorodemo.entity.Pirates;
import com.example.zorodemo.zorodemo.repository.DamageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DamageService {
    public Damage save(Damage dmg);
    public Damage getMoveById(int moveid);
    public String deleteMove(int moveid);
    public int update(int moveid, Damage dmg);
    public List<String> getBestDamage(String crewid, int count, Pirates pirate);

}
