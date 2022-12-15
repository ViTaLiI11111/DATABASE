package hospital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hospital {
    public int number;
    public String address;
    public List<Doctor> doctors = new ArrayList<>();

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "number=" + number +
                ", address='" + address + '\'' +
                ", doctors=" + doctors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital hospital)) return false;
        return number == hospital.number && Objects.equals(address, hospital.address) && Objects.equals(doctors, hospital.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, address, doctors);
    }

    public static class Builder {
        private Hospital hospital;

        public Builder(){ hospital = new Hospital(); }
        /**
         * Setter type designation
         * @param number - number of hospital
         * @return returns current object
         */
        public Builder setNumber(int number){
            hospital.number = number;
            return this;
        }

        /**
         * Setter type designation
         * @param address - address
         * @return returns current object
         */
        public Builder setAddress(String address){
            hospital.address = address;
            return this;
        }


        /**
         * Setter type designation
         * @param doctors - list of doctors
         * @return returns current object
         */
        public Builder setDoctors(List<Doctor> doctors){
            hospital.doctors.addAll(doctors);
            return this;
        }

        /**
         * Function of creating an object of class "Person"
         * @return returns new object of class "Person"
         */
        public Hospital build(){
            return hospital;
        }
    }

    public static void main(String args[]) {
    }
}
