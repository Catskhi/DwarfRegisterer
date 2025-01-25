package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.stereotype.Component;

@Component
public class DwarfMapper {

    public DwarfModel map(DwarfDTO dwarfDTO) {
        DwarfModel dwarfModel = new DwarfModel();
        dwarfModel.setId(dwarfDTO.getId());
        dwarfModel.setName(dwarfDTO.getName());
        dwarfModel.setEmail(dwarfDTO.getEmail());
        dwarfModel.setImgUrl(dwarfDTO.getImgUrl());
        dwarfModel.setAge(dwarfDTO.getAge());
        dwarfModel.setQuests(dwarfDTO.getQuests());
        dwarfModel.setRank(dwarfDTO.getRank());

        return dwarfModel;
    }

    public DwarfDTO map(DwarfModel dwarfModel) {

        DwarfDTO dwarfDTO = new DwarfDTO();
        dwarfDTO.setId(dwarfModel.getId());
        dwarfDTO.setName(dwarfModel.getName());
        dwarfDTO.setEmail(dwarfModel.getEmail());
        dwarfDTO.setImgUrl(dwarfModel.getImgUrl());
        dwarfDTO.setImgUrl(dwarfModel.getImgUrl());
        dwarfDTO.setQuests(dwarfModel.getQuests());
        dwarfDTO.setRank(dwarfModel.getRank());

        return dwarfDTO;
    }

}
