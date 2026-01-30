package com.medical.caresync.util;

import com.medical.caresync.entities.Patient;
import org.springframework.data.jpa.domain.Specification;

public class PatientSpecs {

    public static Specification<Patient> isActive() {
        return (root, query, cb) -> cb.isTrue(root.get("active"));
    }

    public static Specification<Patient> hasId(Long id) {
        return (root, query, cb) -> cb.equal(root.get("tblPatientId"), id);
    }

    public static Specification<Patient> nameLike(String name) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("firstNm")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Patient> hasMrNumber(String mr) {
        return (root, query, cb) -> cb.equal(root.get("mrNumber"), mr);
    }

    public static Specification<Patient> hasMobile(String mobile) {
        return (root, query, cb) -> cb.equal(root.get("mobileNumber"), mobile);
    }

    public static Specification<Patient> searchPatient(String value) {
        return (root, query, cb) -> {
            // Strict match for MR Number and Mobile Number
            var predicate = cb.or(
                    cb.equal(root.get("mrNumber"), value),
                    cb.equal(root.get("mobileNumber"), value)
            );

            // strict match for Patient ID if the input is a number
            try {
                Long id = Long.parseLong(value);
                predicate = cb.or(predicate, cb.equal(root.get("tblPatientId"), id));
            } catch (NumberFormatException ignored) {
                // Not a number, so it can't be an ID. Ignore.
            }

            return predicate;
        };
    }

}
