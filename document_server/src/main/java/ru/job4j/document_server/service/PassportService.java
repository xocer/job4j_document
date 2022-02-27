package ru.job4j.document_server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.document_server.exception.NotFoundException;
import ru.job4j.document_server.modal.Passport;
import ru.job4j.document_server.repository.PassportRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportService {
    private final PassportRepository repository;

    public Passport save(Passport passport) {
        return repository.save(passport);
    }

    public Passport update(Passport passport) {
        var result = repository.findById(passport.getId()).orElseThrow(NotFoundException::new);
        result.setSeries(passport.getSeries());
        result.setNumber(passport.getNumber());
        result.setDateOfIssue(passport.getDateOfIssue());
        result.setIssuedBy(passport.getIssuedBy());
        return repository.save(result);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Passport> findAll() {
        return repository.findAll();
    }

    public List<Passport> findAllBySeries(Integer series) {
        return repository.findAllBySeries(series);
    }

    public List<Passport> findAllUnavailablePassports() {
        return repository.findAllByFinishDateBefore(LocalDate.now());
    }

    public List<Passport> findAllReplaceablePassports() {
        var now = LocalDate.now();
        return repository.findAllByFinishDateBetween(now, now.plusMonths(3));
    }
}
