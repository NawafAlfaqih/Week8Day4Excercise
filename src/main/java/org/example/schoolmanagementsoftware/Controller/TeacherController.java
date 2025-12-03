package org.example.schoolmanagementsoftware.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiResponse;
import org.example.schoolmanagementsoftware.Model.Teacher;
import org.example.schoolmanagementsoftware.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher update successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted successfully"));
    }

    @GetMapping("/get/teacher/{id}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}
