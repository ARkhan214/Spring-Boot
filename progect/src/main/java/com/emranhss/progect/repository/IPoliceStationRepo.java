package com.emranhss.progect.repository;

import com.emranhss.progect.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPoliceStationRepo extends JpaRepository<PoliceStation,Integer> {
    List<PoliceStation> findByDistrictId(Integer districtId);
}
