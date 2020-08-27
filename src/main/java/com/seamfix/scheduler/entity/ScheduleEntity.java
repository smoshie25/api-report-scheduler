package com.seamfix.scheduler.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.DayOfWeek;
import java.util.List;

@Entity
public class ScheduleEntity {


    @Id
    private String Id;

    @Size(max = 100)
    private String Name;

    @Size(max = 255)
    private String Description;

    private String File;

    private String Recipients;

    @NotNull
    private ScheduleType ScheduleType;

    @ElementCollection
    private List<DayOfWeek> frequency;

    private String Time;

    private String Date;

    @NotNull
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

    public ScheduleType getScheduleType() {
        return ScheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        ScheduleType = scheduleType;
    }

    public List<DayOfWeek> getFrequency() {
        return frequency;
    }

    public void setFrequency(List<DayOfWeek> values) {
        this.frequency = values;
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
