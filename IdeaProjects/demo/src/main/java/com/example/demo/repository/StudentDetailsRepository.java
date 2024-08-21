package com.example.demo.repository;

import com.example.demo.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails,Long> {

//    @Query("select s from StudentDetails s where s.studentName = :name")
//    StudentDetails getByName(String name);

    @Query(value = "SELECT * FROM student_details WHERE STUDENT_NAME = :name",nativeQuery = true)
    StudentDetails getByName(String name);

//    @Modifying
//    @Query(value = "UPDATE student_details s set u.STUDENT_NAME = :name where u.id = :id",nativeQuery = true)
//    void updateDetails(String name, Long id);
}
