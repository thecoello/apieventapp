package com.ApiEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ApiEvent.domain.Attendee;
import java.util.List;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
    List<Attendee> findByEventId(Long eventId);
}
