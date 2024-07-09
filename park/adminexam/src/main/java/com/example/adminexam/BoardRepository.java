package com.example.adminexam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    Board findByTitle(String title);
    Board findByTitleAndContent(String title, String content);
    List<Board> findByTitleLike(String title);
}