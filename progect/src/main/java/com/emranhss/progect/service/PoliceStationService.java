package com.emranhss.progect.service;

import com.emranhss.progect.dto.PoliceStationResponseDTO;
import com.emranhss.progect.entity.District;
import com.emranhss.progect.entity.PoliceStation;
import com.emranhss.progect.repository.IDistrictRepo;
import com.emranhss.progect.repository.IPoliceStationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceStationService {

    @Autowired
    private IPoliceStationRepo policeStationRepo;


    @Autowired
    private IDistrictRepo districtRepo;

    public List<PoliceStationResponseDTO> getAllPoliceStationDTO(){
        return policeStationRepo.findAll().stream().map(ps ->{
            PoliceStationResponseDTO dto = new PoliceStationResponseDTO();
            dto.setId(ps.getId());
            dto.setName(ps.getName());
            if (ps.getDistrict() !=null){
                dto.setDistrictId(ps.getDistrict().getId());
                dto.setDistrictName(ps.getDistrict().getName());
            }
            return dto;
        }).toList();

    }



    @Transactional
    public PoliceStation create(PoliceStation policeStation){
        if (policeStation.getDistrict() !=null){
            int districtId = policeStation.getDistrict().getId();
            District district = districtRepo.findById(districtId)
                    .orElseThrow(() -> new RuntimeException("District not found with id "+districtId));
             policeStation.save(district);
        }
        return policeStationRepo.save(policeStation);
    }



    public List<PoliceStation> findAll(){

        return policeStationRepo.findAll();

    }

    public Optional<PoliceStation> findById(Integer id) {

        return policeStationRepo.findById(id);
    }





    public void update(int id,PoliceStation updatePoliceStation) {
        PoliceStation existing = policeStationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("PoliceStation not found with id " + id));
        existing.setName(updatedPoliceStation.getName());


        if (updatedPoliceStation.getDistrict() != null) {
            // Optionally verify district exists
            District district = districtRepo.findById(updatedPoliceStation.getDistrict().getId())
                    .orElseThrow(() -> new RuntimeException("District not found with id " + updatedPoliceStation.getDistrict().getId()));
            existing.setDistrict(district);
        }

        return policeStationRepo.save(existing);
    }





    public  void deleteById(Integer id){

        policeStationRepo.deleteById(id);
    }

}
