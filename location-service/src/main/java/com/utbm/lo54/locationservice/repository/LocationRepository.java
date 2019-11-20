package com.utbm.lo54.locationservice.repository;

import com.utbm.lo54.core.courses.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
