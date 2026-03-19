package com.masenjo.restaurantlisting.mapper;

import com.masenjo.restaurantlisting.dto.RestaurantDto;
import com.masenjo.restaurantlisting.entity.Restaurant;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-19T19:58:49+0100",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto) {
        if ( restaurantDto == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setAddress( restaurantDto.getAddress() );
        restaurant.setCity( restaurantDto.getCity() );
        if ( restaurantDto.getId() != null ) {
            restaurant.setId( restaurantDto.getId() );
        }
        restaurant.setName( restaurantDto.getName() );
        restaurant.setRestaurantDescription( restaurantDto.getRestaurantDescription() );

        return restaurant;
    }

    @Override
    public RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantDto restaurantDto = new RestaurantDto();

        restaurantDto.setAddress( restaurant.getAddress() );
        restaurantDto.setCity( restaurant.getCity() );
        restaurantDto.setId( restaurant.getId() );
        restaurantDto.setName( restaurant.getName() );
        restaurantDto.setRestaurantDescription( restaurant.getRestaurantDescription() );

        return restaurantDto;
    }
}
