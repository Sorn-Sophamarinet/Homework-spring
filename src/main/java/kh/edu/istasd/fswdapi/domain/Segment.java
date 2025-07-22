package kh.edu.istasd.fswdapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "customer_segment")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerSegmentId;

    @NotBlank(message = "segment name is required")
    private String segmentName;


    private String description;
    private boolean isDeleted;

    @OneToMany(mappedBy = "segment")
    private List<Customer > customer;

    @OneToMany(mappedBy = "segment")
    private List<Account > accounts;

}
