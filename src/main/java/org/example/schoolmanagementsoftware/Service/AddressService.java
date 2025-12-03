package org.example.schoolmanagementsoftware.Service;

import lombok.RequiredArgsConstructor;
import org.example.schoolmanagementsoftware.Api.ApiException;
import org.example.schoolmanagementsoftware.DTO.AddressDTO;
import org.example.schoolmanagementsoftware.Model.Address;
import org.example.schoolmanagementsoftware.Model.Teacher;
import org.example.schoolmanagementsoftware.Repository.AddressRepository;
import org.example.schoolmanagementsoftware.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null)
            throw new ApiException("Teacher was not found");

        Address address = new Address(
                teacher.getId(), addressDTO.getArea(),
                addressDTO.getStreet(), addressDTO.getBuildingNumber(),
                teacher
        );

        addressRepository.save(address);
    }

    public void updateAddress(Integer id, AddressDTO addressDTO) {
        Address oldAddress = addressRepository.findAddressById(id);
        if (oldAddress == null)
            throw new ApiException("Teacher Address was not found");

        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(oldAddress);
    }

    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null)
            throw new ApiException("Teacher Address was not found");

        addressRepository.delete(address);
    }

}
