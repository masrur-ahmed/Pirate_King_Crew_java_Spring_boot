package com.example.zorodemo.zorodemo.service;

import com.example.zorodemo.zorodemo.model.Damage;
import com.example.zorodemo.zorodemo.model.Pirates;
import com.example.zorodemo.zorodemo.repository.DamageRepository;
import com.example.zorodemo.zorodemo.repository.PirateRepository;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class PirateAppServiceImplTest {
    @Mock
    private PirateRepository pirateRepository;

    @InjectMocks
    private PirateAppServiceImpl pirateService;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void savePirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        Pirates pirate = new Pirates("1", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);
        when(pirateRepository.save(pirate)).thenReturn(pirate);
        Pirates result = pirateRepository.save(pirate);
        assertEquals("1", result.getCrewid());
    }

    @Test
    public void getPirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        Pirates pirates = new Pirates("1", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);
        when(pirateService.getPirate("1")).thenReturn(pirates);
        Pirates result = pirateService.getPirate("1");
        assertEquals("1", result.getCrewid());
        assertEquals("Onigiri", result.getSpecialAttack());
        assertEquals(122, result.getDamage().getDamagePerMove());
    }

    @Test
    public void deletePirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        Pirates pirates = new Pirates("1", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);

        when(pirateRepository.save(pirates)).thenReturn(pirates);
        Pirates result = pirateService.savePirate(pirates);

        when(pirateRepository.delete("1")).thenReturn("Kicked out of the crew!");
        String s = pirateService.deletePirate("1");
        assertEquals("Kicked out of the crew!",s);
    }

    @Test
    public void updatePirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 999);
        Pirates pirate = new Pirates("2", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);
        when(pirateRepository.update("1", pirate)).thenReturn("1");
        pirateService.updatePirate("1",pirate);
        Pirates result = pirateService.getPirate("1");
        assertEquals("2", pirate.getCrewid());
    }

    @Test
    public void getBestDamage() {
    }
}