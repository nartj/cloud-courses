package com.utbm.lo54.adminwebapp.repository;

import com.utbm.lo54.adminwebapp.repository.http.HttpRepository;
import com.utbm.lo54.core.domain.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository  extends HttpRepository<Location> {
}
