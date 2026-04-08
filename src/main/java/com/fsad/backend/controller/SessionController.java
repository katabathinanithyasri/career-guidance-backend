package com.fsad.backend.controller;

import com.fsad.backend.model.Session;
import com.fsad.backend.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

    private final SessionService service;

    public SessionController(SessionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Session> getAll() {
        return service.getAllSessions();
    }

    @PostMapping
    public Session add(@RequestBody Session session) {
        return service.addSession(session);
    }

    @PutMapping("/{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        return service.updateSession(id, session);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSession(id);
    }
}