package com.stacksmplify.restservices.sprngbootbuildingblocks.mappers;

import java.util.List;

import com.stacksmplify.restservices.sprngbootbuildingblocks.dtos.UserMsDto;
import com.stacksmplify.restservices.sprngbootbuildingblocks.entities.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/*
 * UserMapper
 */
@Mapper(componentModel = "Spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // User to User DTO

    @Mappings({
    @Mapping(source = "email", target = "emailaddress"),
    @Mapping(source = "role", target = "rolename")
    })
    UserMsDto userToUserMsDto(User user);

    // List<User> to List<UserMsDto>
    List<UserMsDto> usersToUserMsDtos(List<User> users);
}