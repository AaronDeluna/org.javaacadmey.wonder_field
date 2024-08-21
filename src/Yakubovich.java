import player.Player;
import player.PlayerAnswer;

public class Yakubovich {

    /**
     * Начинает шоу
     */
    public void startShow() {
        System.out.println("Якубович: Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    /**
     * Остановка шоу
     */
    public void stopShow() {
        System.out.println("Якубович: Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }

    /**
     * Пригласить тройку игроков
     */
    public void inviteThreePlayers(Player[] players, int roundNumber) {
        if (roundNumber != Game.FINAL_ROUND_INDEX) {
            System.out.printf("\nЯкубович: приглашаю %s тройку игроков: %s\n",
                    roundNumber, separateWithCommas(players));
        }
    }

    /**
     * Задать вопросс раунда
     */
    public void askQuestion(String question) {
        System.out.printf("\nЯкубович: Внимание вопрос! \n%s", question);
    }

    /**
     * Кричать в случае победы игрока
     */
    public void shoutPlayerWins(Player player, boolean isFinalRound) {
        if (!isFinalRound) {
            System.out.printf("Якубович: Молодец! %s из %s проходит в финал!\n", player.getName(), player.getCity());
        } else {
            System.out.printf("Якубович: И перед нами победитель Капитал шоу поле чудес! Это %s из %s",
                    player.getName(), player.getCity());
        }
    }

    /**
     * Проверяем ответ игрока
     */
    public boolean checkPlayerAnswer(PlayerAnswer playerAnswer, Tableau tableau) {
        if (playerAnswer.isLetter()) {
            if (tableau.openLetter(playerAnswer.getPlayerAnswer().charAt(0))) {
                System.out.println("\nЯкубович: Есть такая буква, откройте её!");
                return true;
            }

            System.out.println("\nЯкубович: Нет такой буквы! Следующий игрок, крутите барабан!");
        } else {
            if (tableau.openWord(playerAnswer.getPlayerAnswer())) {
                System.out.printf("\nЯкубович: %s! Абсолютно верно!\n", playerAnswer.getPlayerAnswer());
                return true;
            }

            System.out.println("\nЯкубович: Неверно! Следующий игрок!");
        }
        System.out.println("__________________________________");
        return false;
    }

    /**
     * Выводит имена участников через запятую
     */
    private String separateWithCommas(Player[] players) {
        String participantNames = "";
        for (Player player : players) {
            participantNames += player.getName() + ", ";
        }

        return participantNames.substring(0, participantNames.length() - 2);
    }

}
