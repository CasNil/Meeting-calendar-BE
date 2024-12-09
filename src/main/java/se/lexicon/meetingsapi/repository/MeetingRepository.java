package se.lexicon.meetingsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.meetingsapi.entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
