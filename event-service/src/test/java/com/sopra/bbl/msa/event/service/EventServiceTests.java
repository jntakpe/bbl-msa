package com.sopra.bbl.msa.event.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests du service {@link EventService}
 *
 * @author jntakpe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EventServiceTests extends AbstractDBServiceTests {

    private static final String TABLE_NAME = "event";

    @Autowired
    private EventService eventService;

    @Autowired
    private EventServiceTestsUtils eventServiceTestsUtils;

    @Test
    public void findAll_shouldFindSome() {
        assertThat(eventService.findAll().size()).isNotZero().isEqualTo(countRowsInCurrentTable());
    }

    @Test
    public void findById_shouldFindOne() {
        assertThat(eventService.findById(eventServiceTestsUtils.findAnyEvent().getId())).isNotNull();
    }

    @Test(expected = EntityNotFoundException.class)
    public void findById_shouFailCuzUnknownId() {
        eventService.findById(9999L);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
