package org.example.schoolmanagementsoftware.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiResponse;
import org.example.schoolmanagementsoftware.Model.Student;
import org.example.schoolmanagementsoftware.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("Student update successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
    }

    @PutMapping("/assign/student-id/{studentId}/course-id/{courseId}")
    public ResponseEntity<?> assignStudentAndCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.assignStudentAndCourse(studentId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Student and Teacher Assigned successfully"));
    }

    @PutMapping("/change/major/{major}/student-id/{studentId}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer studentId, @PathVariable String major) {
        studentService.changeMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("Major Changed successfully"));
    }
}
