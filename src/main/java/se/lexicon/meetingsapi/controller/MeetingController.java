package se.lexicon.meetingsapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.meetingsapi.dto.MeetingDto;
import se.lexicon.meetingsapi.service.MeetingService;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@CrossOrigin(origins = "http://localhost:5173")
public class MeetingController {
    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MeetingDto> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MeetingDto getMeetingById(@PathVariable Long id) {
        return meetingService.getMeetingById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MeetingDto> createMeeting(@RequestBody MeetingDto meetingDto) {
        MeetingDto savedDto = meetingService.saveMeeting(meetingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> updateMeeting(@PathVariable Long id, @RequestBody MeetingDto meetingDto) {
        meetingService.updateMeeting(id, meetingDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
        return ResponseEntity.noContent().build();
    }
}
