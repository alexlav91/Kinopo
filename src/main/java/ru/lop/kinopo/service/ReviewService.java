package ru.lop.kinopo.service;

import ru.lop.kinopo.exceptions.FilmNotFoundException;
import ru.lop.kinopo.exceptions.ReviewNotFoundException;
import ru.lop.kinopo.model.dto.ReviewDto;
import ru.lop.kinopo.model.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review>getAllReviews();
    Review getReviewById(long id);
    Review saveReview(ReviewDto reviewDTO) throws FilmNotFoundException;
    void deleteReviewById(long id);

    Review updateReviewById(long id, ReviewDto review) throws ReviewNotFoundException;

}
