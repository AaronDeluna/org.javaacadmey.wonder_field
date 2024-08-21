package player;

public class PlayerAnswer {
    private boolean isLetter;
    private String playerAnswer;

    /**
     * Коструктор для слова
     */
    public PlayerAnswer(boolean isLetter, String playerAnswer) {
        this.isLetter = isLetter;
        this.playerAnswer = playerAnswer;
    }

    /**
     * Коструктор для буквы
     */
    public PlayerAnswer(boolean isLetter, char playerAnswer) {
        this.isLetter = isLetter;
        this.playerAnswer = Character.toString(playerAnswer);
    }

    public boolean isLetter() {
        return isLetter;
    }

    public void setLetter(boolean letter) {
        isLetter = letter;
    }

    public String getPlayerAnswer() {
        return playerAnswer;
    }

    public void setPlayerAnswer(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }
}
