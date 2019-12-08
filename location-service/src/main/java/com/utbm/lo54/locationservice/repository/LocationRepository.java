package com.utbm.lo54.locationservice.repository;

import com.utbm.lo54.common.domain.courses.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
