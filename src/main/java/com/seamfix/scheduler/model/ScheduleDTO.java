package com.seamfix.scheduler.model;

import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.List;


public class ScheduleDTO {

    private String Id;

    @NotNull
    private String Name;

    private String Description;

    private String File;

    private String Recipients;

    private com.seamfix.scheduler.entity.ScheduleType ScheduleType;

    private List<DayOfWeek> frequency;

    private String Time;

    private String Date;

    private boolean IsActive;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        File = file;
    }

    public String getRecipients() {
        return Recipients;
    }

    public void setRecipients(String recipients) {
        Recipients = recipients;
    }

    public com.seamfix.scheduler.entity.ScheduleType getScheduleType() {
        return ScheduleType;
    }

    public void setScheduleType(com.seamfix.scheduler.entity.ScheduleType scheduleType) {
        ScheduleType = scheduleType;
    }

    public List<DayOfWeek> getFrequency() {
        return frequency;
    }

    public void setFrequency(List<DayOfWeek> frequency) {
        this.frequency = frequency;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }
}
