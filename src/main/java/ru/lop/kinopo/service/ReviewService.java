package ru.lop.kinopo.service;

import ru.lop.kinopo.exceptions.ReviewNotFoundException;
import ru.lop.kinopo.model.dto.ReviewDTO;
import ru.lop.kinopo.model.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review>getAllReviews();
    Review getReviewById(long id);
    Review saveReview(ReviewDTO reviewDTO);
    void deleteReviewById(long id);

    Review updateReviewById(long id, ReviewDTO review) throws ReviewNotFoundException;
}
