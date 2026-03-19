package com.masenjo.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masenjo.restaurantlisting.dto.RestaurantDto;
import com.masenjo.restaurantlisting.entity.Restaurant;
import com.masenjo.restaurantlisting.mapper.RestaurantMapper;
import com.masenjo.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> allRestaurants = restaurantRepo.findAll();
        List<RestaurantDto> resturantDtoList = allRestaurants.stream()
                                                             .map(restaurant -> RestaurantMapper
																.INSTANCE
																.mapRestaurantToRestaurantDto(restaurant))
                                                             .collect(Collectors.toList());
        
        return resturantDtoList;
    }

    public RestaurantDto addRestaurantToDb(RestaurantDto restaurantDto) {
        Restaurant savedRestaurant = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }

    public ResponseEntity<RestaurantDto> findRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);

        if (restaurant.isPresent()) {
            return ResponseEntity.ok(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
