package peaksoft.ekzamtask3etap.ekzam_task.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SimpleResponse {
    private String message;

    public SimpleResponse(String message) {
        this.message = message;
    }

    // Getters and setters
}
