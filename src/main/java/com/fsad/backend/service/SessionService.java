package com.fsad.backend.service;

import com.fsad.backend.model.Session;
import com.fsad.backend.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository repo;

    public SessionService(SessionRepository repo) {
        this.repo = repo;
    }

    public List<Session> getAllSessions() {
        return repo.findAll();
    }

    public Session addSession(Session session) {
        return repo.save(session);
    }

    public Session updateSession(Long id, Session session) {
        Session existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        existing.setTitle(session.getTitle());
        existing.setDescription(session.getDescription());
        existing.setCounselor(session.getCounselor());
        existing.setDate(session.getDate());
        existing.setTime(session.getTime());
        existing.setDuration(session.getDuration());
        existing.setMode(session.getMode());
        existing.setStatus(session.getStatus());

        return repo.save(existing);
    }

    public void deleteSession(Long id) {
        repo.deleteById(id);
    }
}