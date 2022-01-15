package ru.buran9.geoquiz;

public class Question {
    private int resTextId;
    private boolean answerTrueFalse;

    public Question(int resTextId, boolean answerTrueFalse) {
        this.resTextId = resTextId;
        this.answerTrueFalse = answerTrueFalse;
    }

    public int getResTextId() {
        return resTextId;
    }

    public void setResTextId(int resTextId) {
        this.resTextId = resTextId;
    }

    public boolean isAnswerTrueFalse() {
        return answerTrueFalse;
    }

    public void setAnswerTrueFalse(boolean answerTrueFalse) {
        this.answerTrueFalse = answerTrueFalse;
    }
}
