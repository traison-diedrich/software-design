package team12.control.Navigators;

import team12.view.StartMenu.*;
import team12.view.EndScreen.*;
import team12.view.Stats.*;
import team12.view.Arena.*;

public class Navigator {

   private StartMenu startMenu;
   private Arena arena;
   private EndScreen victoryScreen;
   private EndScreen defeatScreen;
   private StatScreen stats;
   private NavigateToScreen screenNavigator;

   public Navigator(StartMenu startMenu, Arena arena, EndScreen victoryScreen, EndScreen defeatScreen, StatScreen stats) {
      this.startMenu = startMenu;
      this.arena = arena;
      this.victoryScreen = victoryScreen;
      this.defeatScreen = defeatScreen;
      this.stats = stats;

      this.screenNavigator = new NavigateToScreen(this.victoryScreen, this.arena);
      this.arena.addScreenNavigator(this.screenNavigator);

      this.screenNavigator = new NavigateToScreen(this.defeatScreen, this.arena);
      this.arena.addScreenNavigator(this.screenNavigator);

      this.screenNavigator = new NavigateToScreen(this.stats, this.startMenu);
      this.startMenu.addScreenNavigator(this.screenNavigator);

      this.screenNavigator = new NavigateToScreen(this.arena, this.startMenu);
      this.startMenu.addScreenNavigator(this.screenNavigator);

      this.screenNavigator = new NavigateToScreen(this.startMenu, this.victoryScreen);
      this.victoryScreen.addScreenNavigator(this.screenNavigator);

      this.screenNavigator = new NavigateToScreen(this.startMenu, this.defeatScreen);
      this.defeatScreen.addScreenNavigator(this.screenNavigator);

      this.screenNavigator = new NavigateToScreen(this.startMenu, this.stats);
      this.stats.addScreenNavigator(this.screenNavigator);
   }
}
