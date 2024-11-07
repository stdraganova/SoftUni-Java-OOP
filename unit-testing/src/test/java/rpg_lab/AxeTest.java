package rpg_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static rpg_lab.Axe.DURABILITY_LOST;

public class AxeTest {
    public static final Dummy DUMMY = new Dummy(13,45);
    public static final int DURABILITY = 50;
    public static final int ATTACK_POINTS = 10;
    public Axe axe;

    //Анотацията @Test показва, че този метод е такъв,
    //който ще извършва тест.

    //Методът може да е публичен или без аксес модифаяр
    //и е войд - не връща резултат.

    @Test
    public void test_AxeAttack_DurabilityLost() {
       //Arrange
        axe = new Axe(ATTACK_POINTS, DURABILITY);
        //Act
        axe.attack(DUMMY);
        //Assert
        int expected = DURABILITY - DURABILITY_LOST;
        int current = axe.getDurabilityPoints();

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void test_AxeAttack_BrokenWeapon_Throws() {
        axe = new Axe(ATTACK_POINTS, 0);

        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> axe.attack(DUMMY));

        Assertions.assertEquals("Axe is broken.", ex.getMessage());
    }
}
