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
            String likePattern = "%" + value.toLowerCase() + "%";
            return cb.or(
                    cb.like(cb.lower(root.get("mrNumber")), likePattern),
                    cb.like(cb.lower(root.get("mobileNumber")), likePattern),
                    cb.like(root.get("tblPatientId").as(String.class), likePattern),
                    cb.like(cb.lower(root.get("firstNm")), likePattern),
                    cb.like(cb.lower(root.get("lastNm")), likePattern)
            );
        };
    }

}
