package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Security> securities;

    public Portfolio() {}

    public Portfolio(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(Set<Security> securities) {
        this.securities = securities;
    }
}
