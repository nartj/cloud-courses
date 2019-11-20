package com.utbm.lo54.clientwebapp.repository;

import com.utbm.lo54.clientwebapp.repository.http.HttpRepository;
import com.utbm.lo54.core.courses.domain.Location;
import org.springframework.stereotype.Repository;

public interface LocationRepository  extends HttpRepository<Location> {
}
