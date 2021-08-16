package com.leverx.spring.test.workers.mapper;

import com.leverx.spring.test.workers.dto.ShortcutWorkerDto;
import com.leverx.spring.test.workers.entity.Worker;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ShortcutWorkerMapper {

     ShortcutWorkerDto mapEntityToShortcutDto(Worker worker);

     Set<ShortcutWorkerDto> mapEntitySetToShortcutDto(Set<Worker> workers);
}
