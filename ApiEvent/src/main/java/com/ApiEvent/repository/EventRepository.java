package com.ApiEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApiEvent.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
