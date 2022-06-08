package team12;

import org.junit.Test;
import team12.model.GameCharacters.Fighter;
import team12.model.Projectiles.Fireball;
import team12.view.ProjectileSprites.ProjectileSprite;

import static org.junit.Assert.*;

public class FireballTest {

    @Test
    public void testHorizontal() {
        Fireball fire = new Fireball(new ProjectileSprite(0), 0, 0, 0);
        fire.moveHorizontal(40);
        int x = fire.getX();
        assertEquals(40, x);
    }

    @Test
    public void testCheckHitPositive() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Fireball fire = new Fireball(new ProjectileSprite(0), 0, 80, 180);
        assertTrue(fire.checkHit(f1));
    }

    @Test
    public void testCheckHitNegative() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Fireball fire = new Fireball(new ProjectileSprite(0), 0, 80, 0);
        assertFalse(fire.checkHit(f1));
    }
}
