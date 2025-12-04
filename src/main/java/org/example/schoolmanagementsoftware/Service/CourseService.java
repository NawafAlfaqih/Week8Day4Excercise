package org.example.schoolmanagementsoftware.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiException;
import org.example.schoolmanagementsoftware.DTO.CourseDTO;
import org.example.schoolmanagementsoftware.Model.Course;
import org.example.schoolmanagementsoftware.Model.Teacher;
import org.example.schoolmanagementsoftware.Repository.CourseRepository;
import org.example.schoolmanagementsoftware.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> dtoList = new ArrayList<>();

        for (Course c: courses) {
            CourseDTO dto = new CourseDTO(c.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse == null)
            throw new ApiException("Course was not found");

        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null)
            throw new ApiException("Course was not found");

        courseRepository.delete(course);
    }

    public void assignCourseToTeacher(Integer teacherID, Integer courseID) {
        Teacher teacher = teacherRepository.findTeacherById(teacherID);
        Course course = courseRepository.findCourseById(courseID);
        if (teacher == null || course == null)
            throw new ApiException("Cannot assign");

        course.setTeacher(teacher);

        courseRepository.save(course);
    }

    public void unassignCourse(Integer courseID) {
        Course course = courseRepository.findCourseById(courseID);
        if (course == null)
            throw new ApiException("Course was not found");
        if (course.getTeacher() == null)
            throw new ApiException("Course is already unassign to teacher");

        course.setTeacher(null);

        courseRepository.save(course);
    }

    public String getTeacherNameOfCourse(Integer courseID) {
        Course course = courseRepository.findCourseById(courseID);
        if (course == null)
            throw new ApiException("Course was not found");
        if (course.getTeacher() == null)
            throw new ApiException("Course is not assigned to any Teacher");

        return "The Teacher's for course '" +course.getId()+"' is: '"
                +course.getTeacher().getName()+"'";

    }
}
