package com.example.service;

import com.example.model.House;
import com.example.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public House getHouseById(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    public House updateHouse(Long id, House house) {
        House existingHouse = houseRepository.findById(id).orElse(null);
        if (existingHouse == null) {
            return null;
        }
        existingHouse.setName(house.getName());
        existingHouse.setDescription(house.getDescription());
        existingHouse.setLocation(house.getLocation());
        existingHouse.setPricePerNight(house.getPricePerNight());
        existingHouse.setAvailableFrom(house.getAvailableFrom());
        existingHouse.setAvailableTo(house.getAvailableTo());
        existingHouse.setAvailable(house.isAvailable());
        return houseRepository.save(existingHouse);
    }

    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }
}