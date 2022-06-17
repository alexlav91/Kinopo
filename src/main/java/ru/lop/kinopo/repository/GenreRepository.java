package ru.lop.kinopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lop.kinopo.model.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
