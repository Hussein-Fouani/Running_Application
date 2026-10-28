package com.hf.running_application.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubDTO {
    private Long Id;
    @NotEmpty(message = "Club Title shouldn't be Empty")
    private String title;
    @NotEmpty(message = "PhotoUrl Title shouldn't be Empty")
    private String photoUrl;
    @NotEmpty(message = "Content Title shouldn't be Empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
