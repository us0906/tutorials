package com.baeldung.data;

import com.baeldung.model.Anfrage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface AnfrageRepository extends PagingAndSortingRepository<Anfrage, Long> {

    @RestResource (rel = "name-contains", path = "name-contains")
    Page<Anfrage> findByNameContaining (@Param("query") String query, Pageable page);
}
