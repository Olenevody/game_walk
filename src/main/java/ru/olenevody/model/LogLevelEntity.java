package ru.olenevody.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "436_log_levels")
public class LogLevelEntity {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private int level;

    private boolean done;

    public LogLevelEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
