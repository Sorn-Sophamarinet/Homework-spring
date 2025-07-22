package kh.edu.istasd.fswdapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.istasd.fswdapi.domain.Segment;
import kh.edu.istasd.fswdapi.repository.SegmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerSegmentInitialize {

    private final SegmentRepository customerSegmentRepository;

    @PostConstruct
    public void init() {

        if (customerSegmentRepository.count() == 0) {
            Segment segmentRegular = new Segment();
            segmentRegular.setSegment("REGULAR");
            segmentRegular.setDescription("REGULAR");
            segmentRegular.setIsDeleted(false);

            Segment segmentSilver = new Segment();
            segmentSilver.setSegment("SILVER");
            segmentSilver.setDescription("SILVER");
            segmentSilver.setIsDeleted(false);

            Segment segmentGold = new Segment();
            segmentGold.setSegment("GOLD");
            segmentGold.setDescription("GOLD");
            segmentGold.setIsDeleted(false);

            customerSegmentRepository.saveAll(
                    List.of(segmentRegular, segmentSilver, segmentGold)
            );
        }

    }

}