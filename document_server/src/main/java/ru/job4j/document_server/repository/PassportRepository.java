package ru.job4j.document_server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.document_server.modal.Passport;

import java.time.LocalDate;
import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Integer> {
    List<Passport> findAll();

    List<Passport> findAllBySeries(Integer series);

    List<Passport> findAllByFinishDateBefore(LocalDate date);
}
