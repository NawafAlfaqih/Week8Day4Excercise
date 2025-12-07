package org.example.schoolmanagementsoftware.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiException;
import org.example.schoolmanagementsoftware.Model.Course;
import org.example.schoolmanagementsoftware.Model.Student;
import org.example.schoolmanagementsoftware.Repository.CourseRepository;
import org.example.schoolmanagementsoftware.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {
        Student oldStudent = studentRepository.findStudentByID(id);
        if (oldStudent == null)
            throw new ApiException("Student was not found");

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        Student student = studentRepository.findStudentByID(id);
        if (student == null)
            throw new ApiException("Student was not found");

        studentRepository.delete(student);
    }

    public void assignStudentAndCourse(Integer studentId, Integer courseId) {
        Student student = studentRepository.findStudentByID(studentId);
        Course course = courseRepository.findCourseById(courseId);
        if (student == null || course == null)
            throw new ApiException("Cannot assign");

        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentByID(studentId);
        if (student == null)
            throw new ApiException("Student was not found");

        if (major.equalsIgnoreCase(student.getMajor()))
            throw new ApiException("No change in Major");

        student.getCourses().clear(); //drop all courses
        studentRepository.save(student);
    }

}
