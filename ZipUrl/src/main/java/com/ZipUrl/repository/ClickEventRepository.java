package com.ZipUrl.repository;

import com.ZipUrl.models.ClickEvent;
import com.ZipUrl.models.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent,Long> {
    List<ClickEvent> findByUrlMappingAndClickDateBetween(UrlMapping mapping, LocalDateTime start, LocalDateTime end);
    List<ClickEvent> findByUrlMappingInAndClickDateBetween(List<UrlMapping> urlMappings, LocalDateTime start, LocalDateTime end);



}
