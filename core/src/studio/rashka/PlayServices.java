package studio.rashka;

public interface PlayServices {

    /** Реклама и покупки */
    void showAds(int show);

    /** Узнать статус входа пользователя */
    boolean getSignedInGPGS();

    /** Вход */
    void loginGPGS();

    /** Выход */
    void logoutGPGS();

    /** Отправить результат в таблицу рекордов */
    void recordGPGS(String name, int score);

    /** Отправить результат в события */
    void submitScoreGPGS(String id, int score);

    /**
     * Разблокировать достижение
     *
     * @param achievementId
     *            ID достижения. Берется из файла ids.xml
     */
    void unlockAchievementGPGS(String achievementId);

    /** Показать Activity с достижениями */
    void getAchievementsGPGS();

    /** Показать Activity с таблицей рекордов */
    void getLeaderboardGPGS();

    void loadGameState();

    void saveGameState();
}