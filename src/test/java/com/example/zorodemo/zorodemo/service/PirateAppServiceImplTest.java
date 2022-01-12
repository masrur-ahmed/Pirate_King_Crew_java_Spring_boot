package com.example.zorodemo.zorodemo.service;

import com.example.zorodemo.zorodemo.model.Damage;
import com.example.zorodemo.zorodemo.model.Pirates;
import com.example.zorodemo.zorodemo.repository.DamageRepository;
import com.example.zorodemo.zorodemo.repository.PirateRepository;
import org.junit.Rule;
import org.junit.Test;
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

@RunWith(SpringRunner.class)
@SpringBootTest
class PirateAppServiceImplTest {
    @Mock
    private PirateRepository pirateRepository;

    @InjectMocks
    private PirateAppServiceImpl pirateService;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    void savePirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        Pirates pirate = new Pirates("1", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);
        when(pirateRepository.save(pirate)).thenReturn(pirate);
        Pirates result = pirateRepository.save(pirate);
        assertEquals("1", result.getCrewid());
    }

    @Test
    void getPirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        Pirates pirates = new Pirates("1", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);
        when(pirateService.getPirate("1")).thenReturn(pirates);
        Pirates result = pirateService.getPirate("1");
        assertEquals("1", result.getCrewid());
        assertEquals("Onigiri", result.getSpecialAttack());
        assertEquals(122, result.getDamage().getDamagePerMove());
    }

    @Test
    void deletePirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        Pirates pirates = new Pirates("1", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);
        pirateService.deletePirate("1");
        verify(pirateService, times(1)).deletePirate("1");
    }

    @Test
    void updatePirate() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 999);
        Pirates pirate = new Pirates("1", "Roronoa", "Zoro", "Katana", "Onigiri", false, "N/A", toDo);
        pirateService.updatePirate("1",pirate);
        Pirates result = pirateService.getPirate("1");
        assertEquals(999,result.getDamage().getDamagePerMove());
    }

    @Test
    void getBestDamage() {
    }
}