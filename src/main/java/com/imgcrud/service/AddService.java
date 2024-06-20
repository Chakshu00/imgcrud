package com.imgcrud.service;

import com.imgcrud.entity.Add;
import com.imgcrud.exeption.ResourceNotFoundException;
import com.imgcrud.payload.AddDto;
import com.imgcrud.payload.ReviewDto;
import com.imgcrud.repository.AddRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddService {


@Autowired
private AddRepository addRepository;

public AddDto addEmp(AddDto addDto) {

    Add add = new Add();
    add.setName(addDto.getName());
    add.setDepartment(addDto.getDepartment());
    add.setEmpId(addDto.getEmpId());

    Add savedEmp = addRepository.save(add);

    addDto.setId(savedEmp.getId());
    addDto.setName(savedEmp.getName());
    addDto.setDepartment(savedEmp.getDepartment());
    addDto.setEmpId(savedEmp.getEmpId());

    return addDto;

}

public void deleteData(long id) {
    addRepository.deleteById(id);
}

public AddDto empById(long id) {
    Add add = addRepository.findById(id).get();

    AddDto dto = new AddDto();
    dto.setId(add.getId());
    dto.setName(add.getName());
    dto.setDepartment(add.getDepartment());
    dto.setEmpId(add.getEmpId());

    List<ReviewDto> reviews = add.getReviews().stream().map(review -> {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setContent(review.getContent());
        reviewDto.setStars(review.getStars());
        return reviewDto;
    }).collect(Collectors.toList());
    dto.setReviews(reviews);
    return dto;

}

public List<Add> getAllEmployees() {
    return addRepository.findAll();
}

public AddDto updateEmployee(long id, AddDto addDto) {
    Add add= addRepository.findById(id).orElseThrow(
            ()-> new ResourceNotFoundException("Employee Not found with ID: " + id)
    );
    add.setName(addDto.getName());
    add.setDepartment(addDto.getDepartment());
    add.setEmpId(addDto.getEmpId());

    Add savedData = addRepository.save(add);
    AddDto dto= new AddDto();
    dto.setId(savedData.getId());
    dto.setName(savedData.getName());
    dto.setDepartment(savedData.getDepartment());
    dto.setEmpId(savedData.getEmpId());

    return dto;
}

    public List<Add> searchEmployees(String search) {
       return addRepository.searchByNameOrDepartment(search.toLowerCase());
 }


}