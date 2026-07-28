package dev.sid.VeritasBackend.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dev.sid.VeritasBackend.DTO.Auth.SignupDTO;
import dev.sid.VeritasBackend.Entities.Users;

@Mapper(componentModel = "spring")
public interface AuthMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "authorities", ignore = true)
  Users signupDTOToUser(SignupDTO signupDTO);

  SignupDTO userToSignupDTO(Users user);
}
