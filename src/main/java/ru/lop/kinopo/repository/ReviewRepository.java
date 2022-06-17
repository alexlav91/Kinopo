package ru.lop.kinopo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lop.kinopo.model.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}