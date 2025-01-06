package se.lexicon.meetingsapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String date;
    private String time;
    private String level;
    private String participants;
    private String description;

    public Meeting() {
    }


    public Meeting(Long id, String title, String date, String time, String level, String participants, String description) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.level = level;
        this.participants = participants;
        this.description = description;
    }

    public Meeting(String title, String startDate, String startTime, String level, String participants, String description) {
        this.title = title;
        this.date = startDate;
        this.time = startTime;
        this.level = level;
        this.participants = participants;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public String getParticipants() {
        return participants;
    }

    public String getLevel() {
        return level;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String startDate) {
        this.date = startDate;
    }

    public void setTime(String startTime) {
        this.time = startTime;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id) && Objects.equals(title, meeting.title) && Objects.equals(date, meeting.date) && Objects.equals(time, meeting.time) && Objects.equals(level, meeting.level) && Objects.equals(participants, meeting.participants) && Objects.equals(description, meeting.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, time, level, participants, description);
    }
}
