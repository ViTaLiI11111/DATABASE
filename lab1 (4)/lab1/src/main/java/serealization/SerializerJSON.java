package serealization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hospital.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SerializerJSON implements Serializer{
    private ObjectMapper objectMapper;
    public SerializerJSON(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    @Override
    public List<Doctor> listFromFile(String fileName) {
        try {
            return objectMapper.readValue(new File(fileName), new TypeReference<>() {
            });
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Override
    public Doctor fromFile(String fileName){
        try {
            return objectMapper.readValue(new File(fileName), Doctor.class);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void toFile(Doctor doctor, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), doctor);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }
    @Override
    public void listToFile(List<Doctor> employees, String fileName){
        try {
            objectMapper.writeValue(new File(fileName), employees);
        }
        catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static void main(String args[]) {

        Doctor doctor = new Doctor();
        doctor.setFirstname("Vasya");
        doctor.setLastname("Levytskiy");
        doctor.setPosition("Doctor");
        doctor.setCabinetNumber(11);
        doctor.setDateOfBirth(LocalDate.of(2002, 10, 11));
        doctor.setPhoneNumber("0661188726");
        doctor.setSalary(7000);
        Serializer serializer = new SerializerJSON();
        serializer.toFile(doctor, "doctorJSON");

        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor);
        doctor = new Doctor();
        doctor.setFirstname("Name");
        doctor.setLastname("Surname");
        doctor.setPosition("Nurse");
        doctor.setCabinetNumber(1);
        doctor.setDateOfBirth(LocalDate.of(2001, 1, 1));
        doctor.setPhoneNumber("0991188726");
        doctor.setSalary(9000);
        doctors.add(doctor);
        serializer.listToFile(doctors, "doctorsJSON");

        doctor = serializer.fromFile("doctorJSON");
        System.out.println(doctor);
        doctors = serializer.listFromFile("doctorsJSON");
        System.out.println(doctors);
    }
}