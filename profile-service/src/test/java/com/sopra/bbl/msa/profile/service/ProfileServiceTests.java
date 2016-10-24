package com.sopra.bbl.msa.profile.service;

import com.sopra.bbl.msa.profile.dto.ProfileNotificationDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Tests associés au service {@link ProfileService}
 *
 * @author jntakpe
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProfileServiceTests extends AbstractDBServiceTests {

    private static final String TABLE_NAME = "profile";

    @Autowired
    private ProfileService profileService;

    @Test
    public void findByLogin_shouldFindExactMatch() {
        assertThat(profileService.findByLogin("jntakpe")).isNotNull();
    }

    @Test
    public void findByLogin_shouldFindIgnoringCase() {
        assertThat(profileService.findByLogin("JntaKpe")).isNotNull();
    }

    @Test(expected = IllegalStateException.class)
    public void findByLogin_shouldNotFindCuzUnknownLogin() {
        profileService.findByLogin("Unknown");
        fail("should have failed at this point");
    }

    @Test
    public void findByLogin_shouldFindWithNotificationsListInitialized() {
        ProfileNotificationDTO jntakpe = profileService.findByLogin("jntakpe");
        assertThat(jntakpe.getNotifications()).isNotEmpty();
    }

    @Test
    public void findByLogin_shouldFindWithNotificationsListInitializedButEmpty() {
        ProfileNotificationDTO jntakpe = profileService.findByLogin("cbarillet");
        assertThat(jntakpe.getNotifications()).isEmpty();
    }

    @Test
    public void findMailsWithLogins_shouldReturnEmptyCuzEmptyLoginArray() {
        assertThat(profileService.findMailsWithLogins(Stream.<String>of().collect(Collectors.toSet()))).isEmpty();
    }

    @Test
    public void findMailsWithLogins_shouldReturnEmptyCuzNoNamesFound() {
        assertThat(profileService.findMailsWithLogins(Stream.of("toto", "titi").collect(Collectors.toSet()))).isEmpty();
    }

    @Test
    public void findMailsWithLogins_shouldFindOne() {
        assertThat(profileService.findMailsWithLogins(Stream.of("jntakpe", "titi").collect(Collectors.toSet()))).hasSize(1);
    }

    @Test
    public void findMailsWithLogins_shouldFindAll() {
        Set<String> input = Stream.of("jntakpe", "cbarillet").collect(Collectors.toSet());
        assertThat(profileService.findMailsWithLogins(input)).hasSize(input.size());
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
