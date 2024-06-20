package com.imgcrud.service;

import com.imgcrud.entity.Add;
import com.imgcrud.entity.Review;
import com.imgcrud.exeption.ResourceNotFoundException;
import com.imgcrud.payload.ReviewDto;
import com.imgcrud.repository.AddRepository;
import com.imgcrud.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private AddRepository addRepository;

    @Autowired
    private ReviewRepository reviewRepository;
    public ReviewDto addReview(ReviewDto dto, long addId) {

        Add add= addRepository.findById(addId).orElseThrow(
                ()-> new ResourceNotFoundException("No Employee Found with this id "+addId)
        );

        Review review= new Review();
        review.setContent(dto.getContent());
        review.setStars(dto.getStars());
        review.setAdd(add);

        Review savedReview = reviewRepository.save(review);

        dto.setId(savedReview.getId());
        dto.setContent(savedReview.getContent());
        dto.setStars(savedReview.getStars());
        return  dto;

    }

    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }
}
