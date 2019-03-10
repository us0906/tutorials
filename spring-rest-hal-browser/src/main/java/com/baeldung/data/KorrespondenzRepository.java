package com.baeldung.data;


import com.baeldung.model.Korrespondenz;
import com.baeldung.model.Suche;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(exported=false)
public interface KorrespondenzRepository extends PagingAndSortingRepository<Korrespondenz, Long> {

    @RestResource (rel = "id-equals", path = "i-equals")
    Page<Korrespondenz> findById(@Param("query") String query, Pageable page);
}
