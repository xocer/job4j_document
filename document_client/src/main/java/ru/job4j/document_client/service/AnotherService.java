package ru.job4j.document_client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.document_server.modal.Passport;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnotherService {
    private final RestTemplate template;

    private String URL = "http://localhost:8080/passport";

    public Passport save(Passport passport) {
        return template.postForEntity(URL, passport, Passport.class).getBody();
    }

    public Passport update(Passport passport) {
        return template.patchForObject(URL, passport, Passport.class);
    }

    public void delete(Integer id) {
        template.delete(URL + "/" + id);
    }

    public List<Passport> findAll() {
        return template.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }).getBody();
    }

    public List<Passport> findAllBySeries(Integer series) {
        return template.exchange(URL + "/" + series, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }).getBody();
    }

    public List<Passport> findAllUnavailable() {
        return template.exchange(URL + "/unavailable", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }).getBody();
    }

    public List<Passport> findAllReplaceable() {
        return template.exchange(URL + "/replaceable", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Passport>>() {
                }).getBody();
    }
}
