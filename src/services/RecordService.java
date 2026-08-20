package services;

import entities.MedicalRecord;
import interfaces.Manageable;
import interfaces.Searchable;

public class RecordService implements Manageable, Searchable {

    private MedicalRecord[] records = new MedicalRecord[100];
    private int recordCount = 0;


    // =========================================================
    // Add
    // =========================================================

    @Override
    public void add(Object entity) {

        if (!(entity instanceof MedicalRecord)) {
            System.out.println(
                    "Only MedicalRecord objects can be added."
            );
            return;
        }

        MedicalRecord record =
                (MedicalRecord) entity;

        if (searchById(record.getRecordId()) != null) {
            System.out.println(
                    "Record ID already exists."
            );
            return;
        }

        if (recordCount >= records.length) {
            System.out.println(
                    "Record storage is full."
            );
            return;
        }

        records[recordCount] = record;
        recordCount++;
    }


    // =========================================================
    // Remove By ID
    // =========================================================

    @Override
    public boolean removeById(String id) {

        for (int i = 0; i < recordCount; i++) {

            if (records[i]
                    .getRecordId()
                    .equals(id)) {

                for (int j = i;
                     j < recordCount - 1;
                     j++) {

                    records[j] =
                            records[j + 1];
                }

                records[recordCount - 1] = null;
                recordCount--;

                return true;
            }
        }

        return false;
    }


    // =========================================================
    // Get All
    // =========================================================

    @Override
    public Object[] getAll() {

        MedicalRecord[] result =
                new MedicalRecord[recordCount];

        for (int i = 0; i < recordCount; i++) {
            result[i] = records[i];
        }

        return result;
    }


    // =========================================================
    // Search By Keyword
    // =========================================================

    @Override
    public Object[] search(String keyword) {

        MedicalRecord[] temp =
                new MedicalRecord[recordCount];

        int count = 0;

        for (int i = 0; i < recordCount; i++) {

            MedicalRecord record = records[i];

            if (
                    record.getRecordId()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || record.getPatientId()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || record.getDoctorId()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())

                            || record.getDiagnosis()
                            .toLowerCase()
                            .contains(keyword.toLowerCase())
            ) {

                temp[count] = record;
                count++;
            }
        }

        MedicalRecord[] result =
                new MedicalRecord[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    // =========================================================
    // Search By ID
    // =========================================================

    @Override
    public Object searchById(String id) {

        for (int i = 0; i < recordCount; i++) {

            if (records[i]
                    .getRecordId()
                    .equals(id)) {

                return records[i];
            }
        }

        return null;
    }


    // =========================================================
    // List By Patient - Task 2.7
    // =========================================================

    public MedicalRecord[] listByPatient(
            String patientId) {

        MedicalRecord[] temp =
                new MedicalRecord[recordCount];

        int count = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i]
                    .getPatientId()
                    .equalsIgnoreCase(patientId)) {

                temp[count] = records[i];
                count++;
            }
        }

        MedicalRecord[] result =
                new MedicalRecord[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }


    // =========================================================
    // Count Confidential - Task 2.7
    // =========================================================

    public int countConfidential() {

        int count = 0;

        for (int i = 0; i < recordCount; i++) {

            if (records[i].isConfidential()) {
                count++;
            }
        }

        return count;
    }


    // =========================================================
    // Record Count
    // =========================================================

    public int getRecordCount() {
        return recordCount;
    }
}