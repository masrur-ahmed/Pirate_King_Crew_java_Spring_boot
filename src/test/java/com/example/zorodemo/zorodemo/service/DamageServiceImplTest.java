package com.example.zorodemo.zorodemo.service;

import com.example.zorodemo.zorodemo.model.Damage;
import com.example.zorodemo.zorodemo.repository.DamageRepository;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DamageServiceImplTest {
    @Mock
    private DamageRepository damageRepository;

    @InjectMocks
    private DamageServiceImpl damageService;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void save() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        when(damageRepository.save(toDo)).thenReturn(toDo);
        Damage result = damageService.save(toDo);
        assertEquals(1, result.getDamageid());
    }

    @Test
    public void getMoveById() {
        Damage toDo = new Damage( 1,"Santoryu", "2", 122);
        when(damageRepository.save(toDo)).thenReturn(toDo);
        Damage result = damageService.save(toDo);
        assertEquals("2", result.getCrewid());
        assertEquals("Santoryu", result.getMoveName());
        assertEquals(122, result.getDamagePerMove());

    }

    @Test
    public void deleteMove() {
        Damage toDo = new Damage( 1,"25 Todo Sample 8", "2", 122);
        when(damageRepository.save(toDo)).thenReturn(toDo);
        Damage result = damageService.save(toDo);
        String s = damageService.deleteMove(1);
        assertEquals("Kicked out of the crew!",s);
        //verify(damageRepository, times(1)).delete(1);
    }

    @Test
    public void update() {
        Damage damage = new Damage( 1,"Santoryu", "2", 133);

        damageService.update(1,damage);
        Damage result = damageService.getMoveById(1);
        assertEquals(133,result.getDamagePerMove());
    }

    @Test
    public void getBestDamage() {
    }
}