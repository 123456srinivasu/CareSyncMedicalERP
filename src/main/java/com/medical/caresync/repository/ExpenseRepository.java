package com.medical.caresync.repository;

import com.medical.caresync.entities.Expense;
import com.medical.caresync.dto.AssetDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query("SELECT new com.medical.caresync.dto.AssetDTO(e.assetName, SUM(e.quantity), SUM(e.amount)) " +
           "FROM Expense e " +
           "WHERE e.expenseDt BETWEEN :startDate AND :endDate " +
           "AND e.tblCamp.campId = :campId " +
           "AND e.asset = true " +
           "GROUP BY e.assetName")
    List<AssetDTO> findAssetsFromExpenses(@Param("startDate") Date startDate, 
                                          @Param("endDate") Date endDate, 
                                          @Param("campId") Integer campId);
}
