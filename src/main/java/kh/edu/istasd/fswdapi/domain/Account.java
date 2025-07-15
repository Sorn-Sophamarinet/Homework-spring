package kh.edu.istasd.fswdapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true,length = 32 )
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "accountType_id")
    private AccountType accountType;

    @Column(nullable = false,length = 50)
    private String accountCurrency;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private Boolean isDeleted;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "segment_id")
    private Segment segment;

    @OneToMany(mappedBy = "sender")
    private List<Transaction> sentTransactions;

    @OneToMany(mappedBy = "receiver")
    private List<Transaction> receivedTransactions;




}