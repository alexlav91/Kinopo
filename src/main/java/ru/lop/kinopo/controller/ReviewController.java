package ru.lop.kinopo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lop.kinopo.exceptions.ReviewNotFoundException;
import ru.lop.kinopo.model.dto.ReviewDTO;
import ru.lop.kinopo.model.entity.Genre;
import ru.lop.kinopo.model.entity.Review;
import ru.lop.kinopo.repository.ReviewRepository;
import ru.lop.kinopo.service.impl.ReviewServiceImp;

import java.util.List;

@RestController
@RequestMapping("/Review")
public class ReviewController {
    private ReviewServiceImp reviewServiceImp;
    @Autowired
    public ReviewController(ReviewServiceImp reviewServiceImp) {

        this.reviewServiceImp = reviewServiceImp;
    }
    @GetMapping("/")
    @ApiOperation("Получить список рецензий")
    public List<Review> viewReviewHomePage(Model model){
        model.addAttribute(reviewServiceImp.getAllReviews());
        return reviewServiceImp.getAllReviews();
    }
    @GetMapping("{id}")
    @ApiOperation("Получить отзыв")
    public Review getOneReview(@PathVariable("id")long id, Model model){
        model.addAttribute(reviewServiceImp.getReviewById(id));
        return reviewServiceImp.getReviewById(id);
    }
    @PostMapping("/")
    @ApiOperation("Добавить отзыв")
    public  Review createReview(@RequestBody ReviewDTO review){

        return reviewServiceImp.saveReview(review);
    }

    @PutMapping("{id}")
    @ApiOperation("Отредактировать отзыв")
    public  Review updateReview(@RequestBody ReviewDTO review, @PathVariable(value = "id")long id) throws ReviewNotFoundException {
        return reviewServiceImp.updateReviewById(id, review);
    }
    @DeleteMapping("{id}")
    @ApiOperation("Удалить отзыв")
    public void deleteReview(@PathVariable(value="id")long id){

        this.reviewServiceImp.deleteReviewById(id);
    }

}
