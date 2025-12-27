package com.medical.caresync.repository;

import com.medical.caresync.entities.TblDonationInfo;
import com.medical.caresync.dto.AssetDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DonationInfoRepository extends JpaRepository<TblDonationInfo, Integer> {

    @Query("SELECT new com.medical.caresync.dto.AssetDTO(d.assetName, SUM(d.quantity), SUM(d.amountDonated)) " +
           "FROM TblDonationInfo d " +
           "WHERE d.donationDt BETWEEN :startDate AND :endDate " +
           "AND d.tblCamp.tblCampId = :campId " +
           "AND d.asset = true " +
           "GROUP BY d.assetName")
    List<AssetDTO> findAssetsFromDonations(@Param("startDate") Date startDate, 
                                           @Param("endDate") Date endDate, 
                                           @Param("campId") Integer campId);
}
