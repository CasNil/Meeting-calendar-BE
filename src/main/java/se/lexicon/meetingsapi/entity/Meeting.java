package se.lexicon.meetingsapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String startDate;
    private String startTime;
    private String level;
    private String participants;
    private String description;

    public Meeting() {
    }

    public Meeting(String title, String startDate, String startTime, String level, String participants, String description) {
        this.title = title;
        this.startDate = startDate;
        this.startTime = startTime;
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

    public String getStartTime() {
        return startTime;
    }

    public String getStartDate() {
        return startDate;
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
        return Objects.equals(id, meeting.id) && Objects.equals(title, meeting.title) && Objects.equals(startDate, meeting.startDate) && Objects.equals(startTime, meeting.startTime) && Objects.equals(level, meeting.level) && Objects.equals(participants, meeting.participants) && Objects.equals(description, meeting.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, startDate, startTime, level, participants, description);
    }
}
