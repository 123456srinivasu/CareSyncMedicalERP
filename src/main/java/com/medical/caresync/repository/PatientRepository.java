package com.medical.caresync.repository;


import com.medical.caresync.entities.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PatientRepository {

    private final JdbcTemplate jdbcTemplate;

    public PatientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<Patient> PATIENT_ROW_MAPPER = new RowMapper<>() {
        @Override
        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Patient(
                    rs.getLong("TBL_PATIENT_ID"),
                    rs.getString("FIRST_NM"),
                    rs.getString("LAST_NM"),
                    rs.getInt("AGE"),
                    rs.getString("MOBILE_NUMBER")
            );
        }
    };

    public List<Patient> findPatients() {
        String sql = "SELECT TBL_PATIENT_ID, FIRST_NM, LAST_NM, AGE, MOBILE_NUMBER FROM tbl_patient";
        return jdbcTemplate.query(sql, PATIENT_ROW_MAPPER);
    }

    public Patient findPatientById(Long id) {
        String sql = "SELECT TBL_PATIENT_ID, FIRST_NM, LAST_NM, AGE, MOBILE_NUMBER FROM tbl_patient WHERE TBL_PATIENT_ID = ?";
        return jdbcTemplate.queryForObject(sql, PATIENT_ROW_MAPPER, id);
    }

    public int deletePatientById(Long id) {
        String sql = "DELETE FROM tbl_patient WHERE TBL_PATIENT_ID = ?";
        return jdbcTemplate.update(sql, id);
    }

}
