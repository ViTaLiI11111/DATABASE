package database;

public class Main {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager("jdbc:mysql://localhost:3306/hospital", "vitalii", "02032003v");
        HospitalService hospitalService = new HospitalService(dbManager);

        hospitalService.createTables();

        //hospitalService.dropTables();

        dbManager.close();
    }

}