package ru.lop.kinopo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lop.kinopo.exceptions.FilmNotFoundException;
import ru.lop.kinopo.exceptions.ReviewNotFoundException;
import ru.lop.kinopo.model.dto.ReviewDto;
import ru.lop.kinopo.model.entity.Film;
import ru.lop.kinopo.model.entity.Review;
import ru.lop.kinopo.repository.FilmRepository;
import ru.lop.kinopo.repository.ReviewRepository;
import ru.lop.kinopo.service.ReviewService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final FilmRepository filmRepository;


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
    public Review saveReview(ReviewDto review) throws FilmNotFoundException {
        Review review1=new Review();
        review1.setRating(review.getRating());
        review1.setMessage(review.getMessage());
        review1.setDate(review.getDate());
        review1.setFilm(review.getFilm());
        review1.setCritic(review.getCritic());
        this.reviewRepository.save(review1) ;
       double sum=0.0;
        if (review1.getFilm().getReviewList().size()==0) {
            filmRepository.findById(review1.getFilm().getId()).orElseThrow(()->
                    new FilmNotFoundException("Фильм с таким ID не существует")).setRatingOfFilm(review.getRating());
        }else{
            for (int i = 0; i < review1.getFilm().getReviewList().size(); i++) {
                sum+=review1.getFilm().getReviewList().get(i).getRating();
            }
            sum+=review.getRating();
            sum/=review1.getFilm().getReviewList().size()+1;
            filmRepository.findById(review1.getFilm().getId()).orElseThrow(()->
                    new FilmNotFoundException("Фильм с таким ID не существует")).setRatingOfFilm(sum);
       }
        return this.reviewRepository.save(review1) ;
    }

    @Override
    public void deleteReviewById(long id) {
       this.reviewRepository.findById(id);
    }

    @Override
    public Review updateReviewById(long id, ReviewDto review) throws ReviewNotFoundException {
        Review review1=reviewRepository.findById(id).orElseThrow(()->new ReviewNotFoundException("Отзыв с таким ID не найден"));
        review1.setRating(review.getRating());
        review1.setMessage(review.getMessage());
        review1.setDate(review.getDate());
        review1.setFilm(review.getFilm());
        review1.setCritic(review.getCritic());
        return this.reviewRepository.save(review1);
    }
}
