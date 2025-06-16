package com.wellsfargo.counselor.entity;
import javax.persistence.*;
import java.util.List;
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(String name, Client client, List<Security> securities) {
        this.name = name;
        this.client = client;
        this.securities = securities;
    }

    public Long getPortfolioId() { return portfolioId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}