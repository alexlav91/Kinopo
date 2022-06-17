package ru.lop.kinopo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lop.kinopo.exceptions.ReviewNotFoundException;
import ru.lop.kinopo.model.dto.ReviewDTO;
import ru.lop.kinopo.model.entity.Review;
import ru.lop.kinopo.repository.ReviewRepository;
import ru.lop.kinopo.service.ReviewService;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImp implements ReviewService {
    private ReviewRepository reviewRepository;
    @Autowired
    public ReviewServiceImp(ReviewRepository reviewRepository) {

        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        Optional<Review>optional=reviewRepository.findById(id);
        Review review=null;
        if(optional.isPresent()){
            review=optional.get();
        } else {
            throw new RuntimeException("Review not found for id: "+id);
        }
        return review;
    }

    @Override
    public Review saveReview(ReviewDTO review) {
        Review review1=new Review();
        review1.setRating(review.getRating());
        review1.setMessage(review.getMessage());
        review1.setDate(review.getDate());
        review1.setFilm(review.getFilm());
        review1.setCritic(review.getCritic());
        return this.reviewRepository.save(review1) ;
    }

    @Override
    public void deleteReviewById(long id) {
       this.reviewRepository.findById(id);
    }

    @Override
    public Review updateReviewById(long id, ReviewDTO review) throws ReviewNotFoundException {
        Review review1=reviewRepository.findById(id).orElseThrow(()->new ReviewNotFoundException("Отзыв с таким ID не найден"));
        review1.setRating(review.getRating());
        review1.setMessage(review.getMessage());
        review1.setDate(review.getDate());
        review1.setFilm(review.getFilm());
        review1.setCritic(review.getCritic());
        return this.reviewRepository.save(review1);
    }
}
