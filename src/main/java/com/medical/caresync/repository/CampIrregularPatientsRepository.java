package com.medical.caresync.repository;

import com.medical.caresync.entities.CampIrregularPatients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface CampIrregularPatientsRepository extends JpaRepository<CampIrregularPatients, Long> {

    @Query(value = "select * from (select p.FIRST_NM as patientName, p.TBL_PATIENT_ID, count(cd.TBL_CAMP_DETAILS_ID) as patientsCamps "
			+ "from tbl_patient p "
			+ "join tbl_patient_consultation pc on p.tbl_patient_id = pc.TBL_PATIENT_ID "
			+ "join tbl_camp_details cd on cd.tbl_camp_details_id =  pc.tbl_camp_details_id "
			+ "join tbl_camp c on c.tbl_camp_id  = cd.TBL_CAMP_ID "
			+ "where cd.tbl_camp_id = ?1 and pc.DATE_OF_VISIT >= DATE(NOW() - INTERVAL 6 MONTH) "
			+ "and p.ENROLLMENT_DT <= DATE(NOW() - INTERVAL 6 MONTH) group by p.tbl_patient_id) as temp1 "
			+ "inner join (select count(cd.TBL_CAMP_DETAILS_ID) as totalCamps "
			+ "from tbl_camp_details cd "
			+ "join tbl_camp c on c.tbl_camp_id  = cd.TBL_CAMP_ID "
			+ "where c.TBL_CAMP_ID = ?2 and cd.CAMP_START_DT >= DATE(NOW() - INTERVAL 6 MONTH)) as temp2 "
			+ "on temp1.patientsCamps != temp2.totalCamps", nativeQuery = true)
	List<Object[]> findIrregularPatientsFullData(Integer campId, Integer campId2);
}
