package kh.edu.istasd.fswdapi.domain;

import jakarta.persistence.*;

@Entity
public class KYC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // uuid
    private String nationalCardId;
    private Boolean isVerified;
    private Boolean isDeleted;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cust_id")
    private Customer customer;

}
