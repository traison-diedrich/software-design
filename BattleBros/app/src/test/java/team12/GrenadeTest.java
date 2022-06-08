package team12;

import org.junit.Test;
import team12.model.GameCharacters.Fighter;
import team12.model.Projectiles.Grenade;
import team12.view.ProjectileSprites.ProjectileSprite;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GrenadeTest {
    @Test
    public void testHorizontal() {
        Grenade grenade = new Grenade(new ProjectileSprite(1), 1, 0, 0);
        grenade.moveHorizontal(40);
        int x = grenade.getX();
        assertEquals(40, x);
    }

   @Test
    public void testVertical() {
        Grenade grenade = new Grenade(new ProjectileSprite(1), 1, 0, 0);
        grenade.moveVertical(100);
        int y = grenade.getY();
        assertEquals(100, y);
    }

    @Test
    public void testCheckHitPositive() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Grenade grenade = new Grenade(new ProjectileSprite(1), 1, 80, 180);
        assertTrue(grenade.checkHit(f1));
    }

    @Test
    public void testCheckHitNegative() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Grenade grenade = new Grenade(new ProjectileSprite(1), 1, 700, 180);
        assertFalse(grenade.checkHit(f1));
    }

    @Test
    public void testTrajectory() {
        Grenade grenade = new Grenade(new ProjectileSprite(1), 1, 700, 180);
        ArrayList<Integer> trajectory = grenade.calculateGrenadeTrajectory(0);
        ArrayList<Integer> realTrajectory = new ArrayList<Integer>(Arrays.asList(-14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13, 14));
        assertEquals(realTrajectory, trajectory);
    }
}
