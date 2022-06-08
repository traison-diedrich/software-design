package team12;

import org.junit.Test;
import team12.model.GameCharacters.Fighter;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class FighterTest {
    @Test
    public void testWalk() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        //int firstX = f1.getX();
        f1.walk(10);
        int secondX = f1.getX();
        assertEquals(90, secondX);
    }

    @Test
    public void testJump() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        f1.jump(50);
        int jumpY = f1.getY();
        assertEquals(230, jumpY);
    }

    @Test
    public void testTrajectory() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        ArrayList<Integer> jumps = f1.calculateJumpTrajectory();
        ArrayList<Integer> realJumps = new ArrayList<Integer>(Arrays.asList(-26, -24, -22, -20, -18, -16, -14, -12, -10, -8, -6, -4, -2, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26));
        assertEquals(realJumps, jumps);
    }

    @Test
    public void testHitNegativeX() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Fighter f2 = new Fighter(0, 0, 0, 0, 0, 0, null, 700, 180);
        boolean hit = f1.checkHit(f2, false);
        assertFalse(hit);
    }

    @Test
    public void testHitNegativeY() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Fighter f2 = new Fighter(0, 0, 0, 0, 0, 0, null, 150, 0);
        boolean hit = f1.checkHit(f2, false);
        assertFalse(hit);
    }

    @Test
    public void testHitPositive() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Fighter f2 = new Fighter(0, 0, 0, 0, 0, 0, null, 150, 180);
        boolean hit = f1.checkHit(f2, false);
        assertTrue(hit);
    }

    @Test
    public void testHitPositiveDownSlame() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Fighter f2 = new Fighter(0, 0, 0, 0, 0, 0, null, 100, 180);
        boolean hit = f1.checkHit(f2, true);
        assertTrue(hit);
    }

    @Test
    public void testHitNegativeDownSlam() {
        Fighter f1 = new Fighter(0, 0, 0, 0, 0, 0, null, 80, 180);
        Fighter f2 = new Fighter(0, 0, 0, 0, 0, 0, null, 500, 180);
        boolean hit = f1.checkHit(f2, true);
        assertFalse(hit);
    }
}
