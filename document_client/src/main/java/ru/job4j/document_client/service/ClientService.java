package ru.job4j.document_client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.document_client.repository.ClientRepository;
import ru.job4j.document_server.modal.Passport;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Passport save(Passport passport) {
        return clientRepository.save(passport);
    }

    public Passport update(Passport passport) {
        return clientRepository.update(passport);
    }

    public void delete(Integer id) {
        clientRepository.delete(id);
    }

    public List<Passport> findAll() {
        return clientRepository.findAll();
    }

    public List<Passport> findAllBySeries(Integer series) {
        return clientRepository.findAllBySeries(series);
    }

    public List<Passport> findAllUnavailable() {
        return clientRepository.findAllUnavailable();
    }

    public List<Passport> findAllReplaceable() {
        return clientRepository.findAllReplaceable();
    }
}
