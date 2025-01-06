package se.lexicon.meetingsapi.service;

import org.springframework.stereotype.Service;
import se.lexicon.meetingsapi.dto.MeetingDto;
import se.lexicon.meetingsapi.entity.Meeting;
import se.lexicon.meetingsapi.repository.MeetingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    private MeetingDto toDto(Meeting meeting) {
        return new MeetingDto(
                meeting.getId(),
                meeting.getTitle(),
                meeting.getDate(),
                meeting.getTime(),
                meeting.getLevel(),
                meeting.getParticipants(),
                meeting.getDescription()
        );
    }

    private Meeting toEntity(MeetingDto dto) {
        Meeting meeting = new Meeting();
        meeting.setId(dto.id());
        meeting.setTitle(dto.title());
        meeting.setDate(dto.date());
        meeting.setTime(dto.time());
        meeting.setLevel(dto.level());
        meeting.setParticipants(dto.participants());
        meeting.setDescription(dto.description());
        return meeting;
    }


    public List<MeetingDto> getAllMeetings() {
        return meetingRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public MeetingDto getMeetingById(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meeting not found with ID: " + id));
        return toDto(meeting);
    }

    public MeetingDto saveMeeting(MeetingDto dto) {
        Meeting meeting = toEntity(dto);
        Meeting savedMeeting = meetingRepository.save(meeting);
        return toDto(savedMeeting);
    }

    public void updateMeeting(Long id, MeetingDto meetingDto) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meeting not found with ID: " + id));

        meeting.setTitle(meetingDto.title());
        meeting.setDate(meetingDto.date());
        meeting.setTime(meetingDto.time());
        meeting.setLevel(meetingDto.level());
        if(meetingDto.participants() != null) {
            meeting.setParticipants(meetingDto.participants());
        }

        if(meetingDto.description() != null) {
            meeting.setDescription(meetingDto.description());
        }
        meetingRepository.save(meeting);
    }

    public void deleteMeeting(Long id) {
      Meeting meeting = meetingRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Meeting not found with ID: " + id));
      meetingRepository.delete(meeting);
    }
}
