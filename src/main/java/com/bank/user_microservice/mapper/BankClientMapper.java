package com.bank.user_microservice.mapper;


import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.repository.entity.BankClient;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankClientMapper {


    @Mapping(source = "dpi", target = "dpi")
    @Mapping(source = "lastname", target = "lastName")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone", target = "phone")
    BankClientDto toDto(BankClient bankClient);
    List<BankClientDto> toDto(List<BankClient> bankClientList);



    @Mapping(target = "dpi", source = "dpi")
    @Mapping(target = "lastname", source = "lastName")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    BankClient toBankClientEntity(BankClientDto bankClientDto);
    List<BankClient> toBankClientEntity(List<BankClientDto> bankClientDtoList);



}
