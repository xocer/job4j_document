package ru.job4j.document_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.job4j.document_server.modal.Passport;
import ru.job4j.document_server.service.PassportService;

import java.util.List;

@RestController
@RequestMapping("/passport")
@RequiredArgsConstructor
public class PassportController {
    private final PassportService service;

    @PostMapping
    public Passport save(@RequestBody Passport passport) {
        return service.save(passport);
    }

    @PatchMapping
    public Passport update(@RequestBody Passport passport) {
        return service.update(passport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping
    public List<Passport> findAll() {
        return service.findAll();
    }

    @GetMapping("/{series}")
    public List<Passport> findAllBySeries(@PathVariable Integer series) {
        return service.findAllBySeries(series);
    }

    @GetMapping("/unavailable")
    public List<Passport> findAllUnavailable() {
        return service.findAllUnavailablePassports();
    }

    @GetMapping("/replaceable")
    public List<Passport> findAllReplaceable() {
        return service.findAllReplaceablePassports();
    }
}
