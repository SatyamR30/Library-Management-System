package com.sr.librarymanage.repository;

import com.sr.librarymanage.model.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookrepo extends JpaRepository<book, Long> {
}
