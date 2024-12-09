package se.lexicon.meetingsapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import se.lexicon.meetingsapi.entity.Meeting;
import se.lexicon.meetingsapi.repository.MeetingRepository;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer {

    private final MeetingRepository meetingRepository;

    public DatabaseInitializer(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @PostConstruct
    public void initializeDatabase() {
        List<Meeting> meetings = Arrays.asList(
                new Meeting("Team Meeting", "2024-12-10", "11:00", "Team", "test@test.se", "Short meeting with the project team"),
                new Meeting("Company Meeting", "2024-12-11", "10:00", "Company", "test@test.se", "Meeting with the company"),
                new Meeting("Department Meeting", "2024-12-12", "9:00", "Department", "test@test.se", "Meeting with the department")
        );

        meetingRepository.saveAll(meetings);
        System.out.println("Database initialization complete.");
    }
}
