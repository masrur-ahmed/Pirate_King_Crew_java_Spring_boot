package com.example.zorodemo.zorodemo.service;

import com.example.zorodemo.zorodemo.entity.Damage;
import com.example.zorodemo.zorodemo.entity.Pirates;
import com.example.zorodemo.zorodemo.repository.DamageRepository;

import java.util.List;

public class DamageServiceImpl implements DamageService {
    private final DamageRepository dmgRepo;

    public DamageServiceImpl() {
        dmgRepo = new DamageRepository();
    }

    @Override
    public Damage save(Damage dmg) {
        return dmgRepo.save(dmg);
    }

    @Override
    public Damage getMoveById(int moveid) {
        return dmgRepo.getMoveById(moveid);
    }

    @Override
    public String deleteMove(int moveid) {
        return dmgRepo.delete(moveid);
    }

    @Override
    public int update(int moveid, Damage dmg) {
        return dmgRepo.update(moveid, dmg);
    }

    @Override
    public List<String> getBestDamage(String crewid, int count, Pirates pirate) {
        return null;
    }
}
