package com.alpergayretoglu.online_student_election.repository;

import com.alpergayretoglu.online_student_election.model.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, String> {
}