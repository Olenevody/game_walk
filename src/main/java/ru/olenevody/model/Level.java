package ru.olenevody.model;

import ru.olenevody.Code;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Level implements Cloneable {

    private int number;
    private List<Code> codes;
    private String description;
    private String imgName;
    private long duration;
    private Date startDate;
    private boolean tech;

    public Level(int number) {
        this.number = number;
        this.codes = new ArrayList<>();
        this.description = "";
        this.imgName = "";
        this.duration = 600L;
        this.startDate = new Date();
        this.tech = false;
    }

    public Level(Level level) {
        this.number = level.getNumber();
        this.codes = new ArrayList<>();
        for (Code c : level.getCodes()){
            this.addCode(new Code(c));
        }
        this.description = level.getDescription();
        this.imgName = level.getImgName();
        this.duration = level.getDuration();
        this.startDate = new Date();
        this.tech = level.isTech();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }

    public void addCode(Code code) {
        codes.add(code);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isTech() {
        return tech;
    }

    public void setTech(boolean tech) {
        this.tech = tech;
    }

    public Code.EnterCodeResult enterCode(String code) {
        for (Code c : codes) {
            Code.EnterCodeResult ecr = c.enterCode(code);
            if (ecr == Code.EnterCodeResult.DONE || ecr == Code.EnterCodeResult.DONE_AGAIN) {
                return ecr;
            }
        }
        return Code.EnterCodeResult.NOT_DONE;
    }

    public synchronized boolean allCodesDone() {
        for (Code c : codes) {
            if (!c.isDone()) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected Level clone() throws CloneNotSupportedException {
        return new Level(this);
    }
}
