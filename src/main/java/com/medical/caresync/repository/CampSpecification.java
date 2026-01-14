package com.medical.caresync.repository;

import com.medical.caresync.entities.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class CampSpecification {

    public static Specification<Camps> hasStatus(String status) {
        return (root, query, cb) -> {
            if (status == null || status.equalsIgnoreCase("ALL")) {
                return null;
            }
            return status.equalsIgnoreCase("ACTIVE")
                    ? cb.isTrue(root.get("isActive"))
                    : cb.isFalse(root.get("isActive"));
        };
    }

    public static Specification<Camps> hasAddressFilters(
            Long stateId, Long districtId, Long mandalId, String cityName
    ) {
        return (root, query, cb) -> {

            if (stateId == null && districtId == null
                    && mandalId == null && cityName == null) {
                return null;
            }

            query.distinct(true);

            Join<Camps, CampAddress> campAddressJoin =
                    root.join("campAddresses", JoinType.INNER);

            campAddressJoin.on(
                    cb.equal(
                            campAddressJoin.get("addressType"),
                            AddressType.LOCATION
                    )
            );

            Join<CampAddress, Address> addressJoin =
                    campAddressJoin.join("address", JoinType.INNER);

            var predicate = cb.conjunction();

            if (stateId != null) {
                Join<Address, StateLookup> stateJoin =
                        addressJoin.join("state", JoinType.INNER);

                predicate = cb.and(
                        predicate,
                        cb.equal(stateJoin.get("stateLookupId"), stateId)
                );
            }

            if (districtId != null) {
                Join<Address, DistrictLookup> districtJoin =
                        addressJoin.join("district", JoinType.INNER);

                predicate = cb.and(
                        predicate,
                        cb.equal(
                                districtJoin.get("districtLookupId"),
                                districtId
                        )
                );
            }

            if (mandalId != null) {
                Join<Address, MandalLookup> mandalJoin =
                        addressJoin.join("mandal", JoinType.INNER);

                predicate = cb.and(
                        predicate,
                        cb.equal(
                                mandalJoin.get("mandalLookupId"),
                                mandalId
                        )
                );
            }

            if (cityName != null) {
                predicate = cb.and(
                        predicate,
                        cb.like(
                                cb.lower(addressJoin.get("city")),
                                "%" + cityName.toLowerCase() + "%"
                        )
                );
            }

            return predicate;
        };
    }

    public static Specification<Camps> hasCampName(String campName) {
        return (root, query, cb) ->
                campName == null ? null :
                        cb.like(
                                cb.lower(root.get("campName")),
                                "%" + campName.toLowerCase() + "%"
                        );
    }
}
