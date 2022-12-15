package database;

public class HospitalService {

        private DBManager dbManager;

        public HospitalService(DBManager dbManager){
            this.dbManager = dbManager;
        }
        public void createHospital(){
            dbManager.executeUpdate("CREATE TABLE Hospital " +
                    "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                    "address VARCHAR(60) NOT NULL, " +
                    "CONSTRAINT UNIQUE (address))");
        }
        public void createDoctor(){
            dbManager.executeUpdate("CREATE TABLE Doctor " +
                    "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                    "hospital INT NOT NULL, " +
                    "firstname VARCHAR(50) NOT NULL, " +
                    "lastname VARCHAR(50) NOT NULL, " +
                    "dateOfBirth DATE NOT NULL, " +
                    "phoneNumber VARCHAR(10) NOT NULL, " +
                    "cabinetNumber INT NOT NULL," +
                    "salary INT NOT NULL," +
                    "position VARCHAR(10) NOT NULL," +
                    "FOREIGN KEY (hospital) REFERENCES Hospital (id), " +
                    "CONSTRAINT UNIQUE (firstname, lastname, dateOfBirth, phoneNumber, cabinetNumber, position, salary))");
        }
        public void createPatient(){
            dbManager.executeUpdate("CREATE TABLE Patient " +
                    "(id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                    "firstname VARCHAR(50) NOT NULL, " +
                    "lastname VARCHAR(50) NOT NULL, " +
                    "dateOfBirth DATE NOT NULL, " +
                    "phoneNumber VARCHAR(10) NOT NULL, " +
                    "doctor INTEGER NOT NULL, " +
                    "medicalCardNumber INTEGER NOT NULL, " +
                    "bloodType INTEGER NOT NULL, " +
                    "FOREIGN KEY (doctor) REFERENCES Doctor (id), " +
                    "CONSTRAINT UNIQUE (firstname, lastname, dateOfBirth, phoneNumber, medicalCardNumber, doctor, bloodType))");
        }

        public void createTables() {
            createHospital();
            createDoctor();
            createPatient();
        }

        public void dropPatient(){
            dbManager.executeUpdate("DROP TABLE Patient;");
        }
        public void dropDoctor(){
            dbManager.executeUpdate("DROP TABLE Doctor;");
        }
        public void dropHospital(){
            dbManager.executeUpdate("DROP TABLE Hospital;");
        }
        public void dropTables(){

            dropPatient();
            dropDoctor();
            dropHospital();
        }


}
