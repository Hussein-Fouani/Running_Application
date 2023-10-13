package com.hf.running_application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class clubDTO {
    private Long Id;
    private String title;
    private String photoUrl;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
