package game;

import player.Player;

import java.util.Scanner;

public class Game {
    private static final int PLAYER_COUNT = 3;
    private static final int TOTAL_NUMBER_ROUNDS = 4;
    private static final int NUMBER_GROUP_ROUNDS = 3;
    public static final int FINAL_ROUND_INDEX = 3;
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Массив вопрос / ответ
     */
    private String[] questionsArray = new String[TOTAL_NUMBER_ROUNDS];
    private String[] answerArray = new String[TOTAL_NUMBER_ROUNDS];

    private Tableau tableau = new Tableau();
    private Yakubovich yakubovich = new Yakubovich();
    private String[] winners;

    public void init() {
        for (int i = 0; i < answerArray.length; i++) {
            System.out.println("Введите вопрос №" + (i + 1) + " :");
            String question = scanner.nextLine();
            System.out.println("Введите ответ на вопрос №" + (i + 1) + " :");
            String answer = scanner.nextLine();
            questionsArray[i] = question;
            answerArray[i] = answer;
        }

        System.out.println("Игра запускается...");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n".repeat(50));
    }

    /**
     * Создание нового игрока
     */
    public Player[] createPlayers() {
        Player[] players = new Player[PLAYER_COUNT];
        for (int i = 0; i < players.length; i++) {
            System.out.printf("Игрок №%s представьтесь: имя,город. Например: Иван,Москва: \n", (i + 1));
            String input = scanner.nextLine();
            String[] parts = input.split(",");
            players[i] = new Player(parts[0], parts[1]);
        }
        return players;
    }

    /**
     *  Метод для извлечения имен игроков
     */
    public String[] getPlayerNames(Player[] players) {
        String[] names = new String[players.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = players[i].getName();
        }
        return names;
    }

    /**
     * Проверка на заполненность таблицы
     * По сути, означает, что игрок победил
     */
    public boolean isScoreboardComplete() {
        return !tableau.hasHiddenLetters();
    }
}
