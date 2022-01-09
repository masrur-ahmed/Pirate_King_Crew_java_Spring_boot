package com.example.zorodemo.zorodemo.service;

import com.example.zorodemo.zorodemo.entity.Pirates;
import com.example.zorodemo.zorodemo.repository.PirateRepository;

import java.util.List;

public class PirateAppServiceImpl implements PirateAppService{
    private PirateRepository pirateRepository;

    public PirateAppServiceImpl() {
        pirateRepository = new PirateRepository();
    }

    @Override
    public Pirates savePirate(Pirates pirate) {
        return pirateRepository.save(pirate);
    }

    @Override
    public Pirates getPirate(String crewid) {
        return pirateRepository.getCrewById(crewid);
    }

    @Override
    public String deletePirate(String crewid) {
        return pirateRepository.delete(crewid);
    }

    @Override
    public String updatePirate(String crewid, Pirates pirate) {
        return pirateRepository.update(crewid,pirate);
    }

    @Override
    public List<String> getBestDamage(String crewid, int count, Pirates pirate) {
        return null;
    }
}
