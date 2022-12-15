package baseball.domain;

public enum Ball {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String label;
    Ball(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

}
