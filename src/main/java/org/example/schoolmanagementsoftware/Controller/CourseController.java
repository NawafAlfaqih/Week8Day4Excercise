package org.example.schoolmanagementsoftware.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiResponse;
import org.example.schoolmanagementsoftware.Model.Course;
import org.example.schoolmanagementsoftware.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses() {
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody @Valid Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Course update successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
    }

    @PutMapping("/assign/teacher-id/{teacherID}/course-id/{courseID}")
    public ResponseEntity<?> assignCourseToTeacher(@PathVariable Integer teacherID, @PathVariable Integer courseID) {
        courseService.assignCourseToTeacher(teacherID, courseID);
        return ResponseEntity.status(200).body(new ApiResponse("Course assigned successfully"));
    }

    @PutMapping("/unassign/course-id/{courseID}")
    public ResponseEntity<?> unassignCourse(@PathVariable Integer courseID) {
        courseService.unassignCourse(courseID);
        return ResponseEntity.status(200).body(new ApiResponse("Course unassigned"));
    }

    @GetMapping("/get/teacher-name/course-id/{courseID}")
    public ResponseEntity<?> getTeacherNameOfCourse(@PathVariable Integer courseID) {
        return ResponseEntity.status(200)
                .body(new ApiResponse(courseService.getTeacherNameOfCourse(courseID)));
    }
}
