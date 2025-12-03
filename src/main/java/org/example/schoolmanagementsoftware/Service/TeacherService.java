package org.example.schoolmanagementsoftware.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiException;
import org.example.schoolmanagementsoftware.Model.Teacher;
import org.example.schoolmanagementsoftware.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher == null)
            throw new ApiException("Teacher was not found.");

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setAddress(teacher.getAddress());

        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null)
            throw new ApiException("Teacher was not found.");

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null)
            throw new ApiException("Teacher was not found");

        return teacher;
    }
}
