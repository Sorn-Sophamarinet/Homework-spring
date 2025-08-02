package kh.edu.istasd.fswdapi.repository;

import kh.edu.istasd.fswdapi.domain.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Integer> {
    Optional<Media> findByName(String fileName);
}

