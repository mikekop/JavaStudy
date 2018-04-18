package ru.logrocon.lesson9.service;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.logrocon.lesson9.model.Incidents;

public interface IncidentService extends JpaRepository<Incidents, Integer> {
        }
