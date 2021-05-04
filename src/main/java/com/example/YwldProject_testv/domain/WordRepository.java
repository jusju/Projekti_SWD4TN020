package com.example.YwldProject_testv.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<WordAndTranslation, Long> {

    List<WordAndTranslation> findByWord(String word);
    List<WordAndTranslation> findByTheme(Optional<Theme> theme);
  
    
}