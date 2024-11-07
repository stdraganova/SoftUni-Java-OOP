package rpg_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static rpg_lab.AxeTest.ATTACK_POINTS;
import static rpg_lab.AxeTest.DURABILITY;

public class DummyTest {
    public static final int ALIVE_HEALTH = 30;
    public static final int DEATH_HEALTH = 0;
    public static final int EXPERIENCE = 20;

    Dummy dummy;

    @Test
    public void test_DummyLosesHealth_OnAttack() {
        dummy = new Dummy(ALIVE_HEALTH, EXPERIENCE);

        dummy.takeAttack(ATTACK_POINTS);

        int expected = ALIVE_HEALTH - ATTACK_POINTS;
        int actual = dummy.getHealth();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_DummyDeath_Throws() {
        dummy = new Dummy(DEATH_HEALTH,EXPERIENCE);

        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> dummy.takeAttack(ATTACK_POINTS));
        Assertions.assertEquals("Dummy is dead.", ex.getMessage());
    }

    @Test
    void test_DummyDeath_CanGiveXP() {
        dummy = new Dummy(DEATH_HEALTH, EXPERIENCE);

        dummy.giveExperience();

        int expected = EXPERIENCE;
        
    }
}
