package player;

import java.util.Scanner;

public class Player {
    private String name;
    private String city;
    private static final char ANSWER_OPTION_B = 'Б';
    private static final char ANSWER_OPTION_C = 'С';
    private Scanner scanner = new Scanner(System.in);


    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    /**
     * Игрок выкрикивает букву
     */
    public char shoutLetter() {
        while (true) {
            System.out.println("Введите букву: ");
            char letter = scanner.next().toUpperCase().charAt(0);
            if (isRussianLetter(letter)) {
                System.out.printf("\nИгрок: %s, Буква: %s \n", name, letter);
                return letter;
            } else {
                System.out.println("Ошибка! это не русская буква, введите русскую букву");
            }
        }
    }

    /**
     * Игрок говорит слово
     */
    public String sayWord() {
        System.out.println("Введите слово: ");
        String word = scanner.nextLine().toUpperCase();
        System.out.printf("\nИгрок: %s, слово: %s\n", name, word);
        return word;
    }

    /**
     * Проверка на Русскую букву
     */
    private boolean isRussianLetter(char letter) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of(letter);
        return block == Character.UnicodeBlock.CYRILLIC;
    }

    /**
     * Ход игрока
     * Результат работы метода вернёт PlayerAnswer
     */
    public PlayerAnswer playerTurn() {
        System.out.printf("\nХод игрока: %s, %s\n", name, city);
        while (true) {
            System.out.println("Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'с' и enter: ");
            char actionSelection = scanner.nextLine().toUpperCase().charAt(0);
            switch (actionSelection) {
                case ANSWER_OPTION_B -> {
                    return new PlayerAnswer(true, shoutLetter());
                }
                case ANSWER_OPTION_C -> {
                    return new PlayerAnswer(false, sayWord());
                }
                default -> System.out.println("Некорректное значение, введите 'б' или 'с'");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
