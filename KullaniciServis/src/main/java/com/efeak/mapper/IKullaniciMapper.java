package com.efeak.mapper;


import com.efeak.dto.request.KullaniciKayitDto;
import com.efeak.repository.entity.Kullanici;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IKullaniciMapper {
    IKullaniciMapper INSTANCE= Mappers.getMapper(IKullaniciMapper.class);
    Kullanici toKullanici(final KullaniciKayitDto dto);

}
