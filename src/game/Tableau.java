package game;

public class Tableau {
    private String answer;
    private char[] lettersScoreboard;
    private char[] scoreboard;

    /**
     * Инициализация табло и записывает верный ответ в поле
     */
    public void initScoreboard(String answer) {
        this.answer = answer;
        lettersScoreboard = new char[answer.length()];
        scoreboard = new char[answer.length()];
        for (int i = 0; i < lettersScoreboard.length; i++) {
            lettersScoreboard = answer.toUpperCase().toCharArray();
            scoreboard[i] = '_';
        }
        printArray(scoreboard);
    }

    /**
     * Открывает букву
     */
    public boolean openLetter(char letter) {
        letter = Character.toUpperCase(letter);
        for (int i = 0; i < lettersScoreboard.length; i++) {
            if (letter == lettersScoreboard[i]) {
                scoreboard[i] = letter;
                printArray(scoreboard);
                return true;
            }
        }
        printArray(scoreboard);
        return false;
    }

    /**
     * Открывает слово целиком
     */
    public boolean openWord(String word) {
        if (answer.equals(word)) {
            printArray(lettersScoreboard);
            return true;
        }
        printArray(scoreboard);
        return false;
    }

    /**
     * Проверяет на наличие неразгаданных букв
     * Если не разгаданные буквы есть return true
     */
    public boolean hasHiddenLetters() {
        for (char c : scoreboard) {
            if (c == '_') {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверка корректности атрибутов
     * Провепяем на null
     */
    public void isEmptyAttribute() {
        if (answer != null || lettersScoreboard != null) {
            throw new IllegalArgumentException("Ошибка: Не корректный ввод атрибутов");
        }
    }

    private void printArray(char[] array) {
        System.out.println();
        for (char c : array) {
            System.out.printf("|%s|", c);
        }
    }
}
