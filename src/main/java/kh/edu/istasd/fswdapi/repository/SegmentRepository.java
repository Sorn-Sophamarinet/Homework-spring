package kh.edu.istasd.fswdapi.repository;

import kh.edu.istasd.fswdapi.domain.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Long> {
    Segment findByCustomerSegmentId(Integer customerSegmentId);

}
