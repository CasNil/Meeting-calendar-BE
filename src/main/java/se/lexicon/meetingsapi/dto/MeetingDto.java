package se.lexicon.meetingsapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record MeetingDto(
        Long id,

        @NotBlank(message = "Title is required")
        @Size(max =
                100, message = "Title must not exceed 100 characters")
        String title,

        @NotBlank(message = "Date is required")
        @Pattern(
                regexp = "\\d{4}-\\{2}-\\d{2}",
                message = "Date must be in the format YYYY-MM-DD"
        )
        String startDate,

        @NotBlank(message = "Time is required")
        @Pattern(
                regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]",
                message = "Time must be in the format HH:MM"

        )
        String startTime,

        @NotBlank()
        @Pattern(
                regexp = "team|department|company",
                message = "Level must be 'Team', 'Department', or 'Company'"
        )
        String level,

        @NotBlank(message = "Participants are required")
        @Email(message = "Invalid email")
        String participants,

        @NotBlank()
        @Size(max = 255, message = "Description must not exceed 255 characters")
        String description
) {
}
