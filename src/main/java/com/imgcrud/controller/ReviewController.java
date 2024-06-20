package com.imgcrud.controller;

import com.imgcrud.payload.ReviewDto;
import com.imgcrud.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    //http://localhost:8080/api/v1/addReview?addId=1
    @PostMapping("/addReview")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto dto, @RequestParam long addId){
        ReviewDto reviewDto = reviewService.addReview(dto, addId);
        return new ResponseEntity<>(reviewDto, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/v1/deleteReview/1
    @DeleteMapping("/deleteReview/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable long id){
        reviewService.deleteReview(id);
        return  new ResponseEntity<>("Your Review is deleted", HttpStatus.OK);
    }
}
