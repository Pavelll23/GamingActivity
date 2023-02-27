package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {

    private ru.netology.GameStore GameStore;

    @Test
    public void shouldAddGame() {     //Добавить игру

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }


    @Test
    public void shouldAddGameIfNoGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Нетология Баттл Онлайн 2", "Аркады", store );

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldAddGames() {     //Добавить несколько игр
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Батл Онлайн", "Аркады");
        Game game1 = store.publishGame("Battle Sity", "Arcade");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPublishGame() {     //Создание обьекта игры
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertEquals(List.of(game), store.getGames());
    }

    @Test
    public void shouldAddPublishGames() {         //Создание несколких обьектов
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");

        assertEquals(List.of(game, game1), store.getGames());
    }

    @Test
    public void shouldAddPlayTime() {        //Регистрация количества игрового времени
        GameStore store = new GameStore();
        Map<String, Integer> time = new HashMap<>();
        time.put("Вова", 5);
        store.addPlayTime("Вова", 5);

        assertEquals(time, store.getPlayedTime());
    }

    @Test
    public void shouldAddPlayTimeSomePlayers() {     //Регистрация игрового времени у нескольких игроков
        GameStore store = new GameStore();
        Map<String, Integer> time = new HashMap<>();
        time.put("Vova", 5);
        time.put("Roma", 3);
        store.addPlayTime("Vova", 5);
        store.addPlayTime("Roma", 3);

        assertEquals(time, store.getPlayedTime());
    }

    @Test
    public void shouldAddSumPlayerTime() {      // Суммирование игрового времени
        GameStore store = new GameStore();
        Map<String, Integer> time = new HashMap<>();

        store.addPlayTime("Vova", 5);
        store.addPlayTime("Vova", 3);

        time.put("Vova", 8);

        assertEquals(time, store.getPlayedTime());
    }

    @Test
    public void shouldMostPlayer() {             //Поиск игрока с наибольшим количеством игрового времени
        GameStore store = new GameStore();
        Map<String, Integer> Playedtime = new HashMap<>();
        store.addPlayTime("Vova", 3);
        store.addPlayTime("Ira", 10);
        store.addPlayTime("Roma", 5);

        String expected = ("Ira");
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test
    public void shoulMostPlayerIfNull() {
        GameStore store = new GameStore();

        String expected = null;
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test
    public void shouldMostPlayerOne() {
        GameStore store = new GameStore();
        Map<String, Integer> Playedtime = new HashMap<>();
        store.addPlayTime("Vova", 3);

        String expected = ("Vova");
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldMostPlayerIfOneHouer() {
        GameStore store = new GameStore();
        Map<String, Integer> playedtime = new HashMap<>();

        store.addPlayTime("Vova", 1);
        String expected = ("Vova");

        assertEquals(expected, store.getMostPlayer());
    }

    @Test
    public void shouldSumPlayedTime() {     // Общее количество игрового времени в коталоге
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Батл Онлайн", "Аркады");
        Map<String, Integer> Playedtime = new HashMap<>();

        store.addPlayTime("Vova", 3);
        store.addPlayTime("Ira", 10);
        store.addPlayTime("Roma", 5);

        int expected = 18;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

}
