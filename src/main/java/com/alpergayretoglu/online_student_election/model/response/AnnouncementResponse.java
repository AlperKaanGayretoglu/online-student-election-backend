package com.alpergayretoglu.online_student_election.model.response;

import com.alpergayretoglu.online_student_election.model.entity.Announcement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementResponse {
    private String title;
    private String content;
    private LocalDateTime date;

    public static AnnouncementResponse fromEntity(Announcement announcement) {
        return AnnouncementResponse.builder()
                .title(announcement.getTitle())
                .content(announcement.getContent())
                .date(announcement.getDate())
                .build();
    }
}
