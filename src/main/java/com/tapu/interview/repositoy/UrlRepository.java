package com.tapu.interview.repositoy;

import com.tapu.interview.model.Url;
import com.tapu.interview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {

    public Url findByShortLink(String shortLink);
}
