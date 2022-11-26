public enum SportsPlayerCounter {

    FOOT_BALL(cnt -> cnt > 11),

    BASE_BALL(cnt -> cnt > 10);

    private Function<Integer, Boolean> playerCounter;

    SportsPlayerCounter(Function<Integer, Boolean> playerCounter) {
        this.playerCounter = playerCounter;
    }

    public boolean maximum(Integer currentPlayers) {
        return this.playerCounter
                .apply(currentPlayers);
    }
}