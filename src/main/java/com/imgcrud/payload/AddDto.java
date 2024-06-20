package com.imgcrud.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDto {
    private Long id;
    private String name;
    private String department;
    private String empId;
    private List<ReviewDto> reviews;
}

