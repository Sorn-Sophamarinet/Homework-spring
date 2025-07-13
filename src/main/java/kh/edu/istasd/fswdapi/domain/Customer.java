package kh.edu.istasd.fswdapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Column(length = 15,nullable = false)
    private String gender;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    @Column( columnDefinition = "TEXT")
    private String remark;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Account> accounts;


    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private KYC kyc;


}
