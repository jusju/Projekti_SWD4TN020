package com.example.YwldProject_testv.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Long> {

    List<Theme> findByThemename(String themename);
 
    
}