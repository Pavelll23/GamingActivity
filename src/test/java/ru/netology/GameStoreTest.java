package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameStoreTest {

    private ru.netology.GameStore GameStore;

    @Test
    public void shouldAddGame() {     //Добавить игру

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }
    @Test
    public void shouldAddPublishGame(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertEquals(game, store.getGames());


    }

    @Test
    public void shouldAddPlayTime() {
        GameStore store = new GameStore();
        Map<String, Integer> time = new HashMap<>();
        time.put("Вова", 5);
        store.addPlayTime("Вова", 5);
        assertEquals(time , store.getPlayedTime());
    }

    @Test
    public void shouldAddSumPlayerTime(){
        GameStore store = new GameStore();
        Map<String,Integer> time = new HashMap<>();

        time.put("Vova", 8);

        store.addPlayTime("Vova", 5);
        store.addPlayTime("Vova", 3);

        assertEquals(time , store.getPlayedTime() );
    }
    @Test
    public void shouldMostPlayer(){
        GameStore store = new GameStore();
        Map<String,Integer> Playdtime = new HashMap<>();
        store.addPlayTime("Vova", 3);
        store.addPlayTime("Ira", 10);
        store.addPlayTime("Roma", 5);
        String expected = ("Ira");
        store.getMostPlayer();
        assertEquals(expected, store.getMostPlayer());

    }
    @Test
    public void shoulMostPlayerIfNull(){
        GameStore store = new GameStore();
        Map<String,Integer> Playdtime = new HashMap<>();

        String expected = ("null");
        store.getMostPlayer();
        assertEquals(expected, store.getMostPlayer());

    }
    @Test
    public void shouldMostPlayerOne() {
        GameStore store = new GameStore();
        Map<String,Integer> Playdtime = new HashMap<>();
        store.addPlayTime("Vova", 3);
        String expected = ("Vova");
        store.getMostPlayer();
        assertEquals(expected, store.getMostPlayer());
    }
    @Test
    public void shouldMostPlayerIfOneHouer(){
        GameStore store = new GameStore();
        Map<String,Integer> Playdtime = new HashMap<>();
        store.addPlayTime("Vova", 1);
        String expected = ("Vova");
        store.getMostPlayer();
        assertEquals(expected, store.getMostPlayer());
    }
    @Test
    public void shouldSumPlayedTime(){
        GameStore store = new GameStore();

    }


        // другие ваши тесты

}
