package com.masenjo.restaurantlisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masenjo.restaurantlisting.dto.RestaurantDto;
import com.masenjo.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://k8s-default-awsingre-9aa4c55379-1495487178.eu-west-2.elb.amazonaws.com")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants() {
        List<RestaurantDto> allRestaurants = restaurantService.findAllRestaurants();
        return ResponseEntity.ok(allRestaurants);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDto> fetchRestaurantById(@PathVariable Integer id) {
        return restaurantService.findRestaurantById(id);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto restaurantAdded = restaurantService.addRestaurantToDb(restaurantDto);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

}
