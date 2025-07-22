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
            segmentRegular.setSegmentName("REGULAR");
            segmentRegular.setDescription("REGULAR");
            segmentRegular.setDeleted(false);

            Segment segmentSilver = new Segment();
            segmentSilver.setSegmentName("SILVER");
            segmentSilver.setDescription("SILVER");
            segmentSilver.setDeleted(false);

            Segment segmentGold = new Segment();
            segmentGold.setSegmentName("GOLD");
            segmentGold.setDescription("GOLD");
            segmentGold.setDeleted(false);

            customerSegmentRepository.saveAll(
                    List.of(segmentRegular, segmentSilver, segmentGold)
            );
        }

    }

}