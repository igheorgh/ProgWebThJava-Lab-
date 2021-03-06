package com.java.proiect.mapper;

import com.java.proiect.dto.UserInformationDto;
import com.java.proiect.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends EntityMapper<UserInformationDto, User>{
}
