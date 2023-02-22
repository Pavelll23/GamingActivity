package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PlayerTest {

    Map<String, Integer> listPlayers = new HashMap<>();              // Создаем Мар и конструктор для дальнейшего использования в тестах
    public Map<String, Integer> getListPlayers() {
        return listPlayers;
    }

    Map<Game, Integer> listGames = new HashMap<>();
    public Map<Game, Integer> getListGames() {
        return listGames;
    }
    @Test
    public void shouldTestGetName () {                          // Проводим тест на проверку создания игрока
        Player player = new Player("Petya");
        assertEquals("Petya", player.getName());
    }


    /*@Test

    public void shouldTestInstallGame () {                       // Проводим тест на установку игры игроку
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

            listGames.put(game, 0);


        Player player = new Player("Petya");
        player.installGame(game);


        assertEquals(listGames.entrySet(), player.playedTime.entrySet());

    }*/


    @Test
    public void testPlayIfGameNotInstall (){                        // Проводим тест на наличие ошибки RuntimeException если игра не установлена игроку
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");


        Assertions.assertThrows(RuntimeException.class,
                () -> player.play(game, 4));

    }

   /* @Test

    public void shouldTestPlayInGameStoreMap () {                      // Проводим тест что данные об игре игрока в игру передаются в объект католога игр
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        listPlayers.put("Petya", 3);

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        assertEquals( getListPlayers() , store.playedTime.entrySet());

    }*/

  /*  @Test

    public void shouldTestPlayInPlayerMap () {                      // Проводим тест что данные об игре игрока в игру передаются в Map игрока
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        listGames.put(game, 3);

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        assertEquals( listGames.entrySet() , player.playedTime.entrySet());

    }*/

    @Test
    public void shouldSumGenreIfOneGame() {                                             //Тестируем метод sumGenre если игрок играл в одну игру
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        assertEquals(expected, player.sumGenre(game.getGenre()));
    }

    @Test
    public void shouldSumGenreIfSomeGames() {                                           //Тестируем метод sumGenre если игрок играл в несколько игр одного жанра
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.play(game, 3);
        player.play(game2, 4);

        int expected = 7;
        assertEquals(expected, player.sumGenre (game.getGenre()));
    }

    @Test
        public void shouldTestMostPlayerByGenre() {                                         //Тестируем метод mostPlayerByGenre
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");

        Player player = new Player("Petya");
        Player player2 = new Player("Vasya");
        player.installGame(game);
        player2.installGame(game2);
        player.play(game, 3);
        player2.play(game2, 4);

        String expected = "Нетология Баттл Онлайн 2";
        assertEquals(expected, player.mostPlayerByGenre(game.getGenre()));
    }

    @Test
    public void shouldTestMostPlayerByGenreIfNotGenre() {                                   //Тестируем метод mostPlayerByGenre если в этот жанр не играли
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");

        Player player = new Player("Petya");
        Player player2 = new Player("Vasya");
        player.installGame(game);
        player2.installGame(game2);
        player.play(game, 3);
        player.play(game2, 4);

        String  expected = null ;
        Assertions.assertEquals(null, player.mostPlayerByGenre("Спорт"));
    }


}
