package com.imgcrud.controller;

import com.imgcrud.entity.Add;
import com.imgcrud.payload.AddDto;
import com.imgcrud.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddController {

    @Autowired
    private AddService addService;


    //Add Employee Data in a Table (Create)
    //http://localhost:8080/api/v1/addData
    @PostMapping("/addData")
    public ResponseEntity<AddDto> addEmp(@RequestBody AddDto addDto){
        AddDto dto = addService.addEmp(addDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //Delete Employee Data from a table

    //http://localhost:8080/api/v1/delete/2
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable long id){
        addService.deleteData(id);
        return new ResponseEntity<>("Account Deleted", HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<AddDto> empById(@RequestParam long id){
        AddDto addDto = addService.empById(id);
        return new ResponseEntity<>(addDto, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/allEmployees
    @GetMapping("/allEmployees")
    public ResponseEntity<List<Add>> getAllEmployees() {
        List<Add> employees = addService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //Update
    //http://localhost:8080/api/v1/updateEmployee/{id}
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<AddDto> updateEmployee(@PathVariable long id, @RequestBody AddDto addDto) {
        AddDto updatedEmployee = addService.updateEmployee(id, addDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/search?search=chakshu

    @GetMapping("/search")
    public List<Add> searchEmployees(@RequestParam String search) {

        return addService.searchEmployees(search);
    }

}
