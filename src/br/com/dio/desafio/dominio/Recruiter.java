package br.com.dio.desafio.dominio;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Recruiter {

    private String name;

    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Dev findDevWithMaxXp(Set<Dev> devs) {
        Optional<Dev> dev = devs.stream()
                .sorted(Comparator.comparingDouble(Dev::calcularTotalXp))
                .skip(devs.size() - 1)
                .limit(1)
                .findFirst();
        return dev.orElseThrow();
    }
}
