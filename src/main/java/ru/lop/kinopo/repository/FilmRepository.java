package ru.lop.kinopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lop.kinopo.model.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    }

