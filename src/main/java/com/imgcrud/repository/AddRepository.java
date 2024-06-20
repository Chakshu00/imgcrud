package com.imgcrud.repository;

import com.imgcrud.entity.Add;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddRepository extends JpaRepository<Add,Long> {
    @Query("SELECT DISTINCT d FROM Add d LEFT JOIN FETCH d.reviews WHERE LOWER(d.name) LIKE %:search% OR LOWER(d.department) LIKE %:search%")
    List<Add> searchByNameOrDepartment(@Param("search") String search);


}
