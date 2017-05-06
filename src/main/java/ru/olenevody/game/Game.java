package ru.olenevody.game;

import ru.olenevody.Code;
import ru.olenevody.model.Level;
import ru.olenevody.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Game {

    private String pin;
    private Team team;
    private Level level;
    private Status status;
    private Timer timer;
    private long timeOnLevel;
    private List<Integer> doneLevels;

    public Game(String pin, Team team, Level level) {
        this.pin = pin;
        this.team = team;
        this.level = level;
        this.status = Status.PLAYING;
        this.timeOnLevel = 0;
        this.timer = new Timer();
        this.doneLevels = new ArrayList<>();
    }

    public String getPin() {
        return pin;
    }

    public Team getTeam() {
        return team;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
        this.timeOnLevel = 0;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public long getTimeOnLevel() {
        return timeOnLevel;
    }

    public void incTimeOnLevel() {
        timeOnLevel++;
    }

    public void resetTimeOnLevel() {
        timeOnLevel = 0;
    }

    public synchronized Code.EnterCodeResult enterCode(String code) {
        if (timeOnLevel >= getLevel().getDuration()) {
            return Code.EnterCodeResult.NOT_DONE;
        }
        return level.enterCode(code);
    }

    public boolean allCodesDone() {
        return level.allCodesDone();
    }

    public void addDoneLevel(Level level) {
        if (!level.isTech()) {
            doneLevels.add(level.getNumber());
        }
    }

    public List<Integer> getDoneLevels() {


        return doneLevels;
    }

    public enum Status {

        PLAYING("Игра в процессе"), PAUSED("Игра приостановлена"), FINISHED("Игра завершена");

        String statusString;

        Status(String statusString) {
            this.statusString = statusString;
        }

        @Override
        public String toString() {
            return statusString;
        }
    }

}
