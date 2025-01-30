package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DwarfService {

    private DwarfRepository dwarfRepository;
    private DwarfMapper dwarfMapper;

    public DwarfService(DwarfRepository dwarfRepository, DwarfMapper dwarfMapper) {
        this.dwarfRepository = dwarfRepository;
        this.dwarfMapper = dwarfMapper;
    }

    // List all dwarfs
    public List<DwarfDTO> listDwarfs() {
        List<DwarfModel> dwarfs = dwarfRepository.findAll();
        return dwarfs.stream()
                .map(dwarfMapper::map)
                .collect(Collectors.toList());
    }

    public DwarfDTO getDwarfsById(Long id) {
        Optional<DwarfModel> dwarfById = dwarfRepository.findById(id);
        return dwarfById.map(dwarfMapper::map).orElse(null);
    }

    public DwarfDTO createDwarf(DwarfDTO dwarfDTO) {
        DwarfModel dwarf = dwarfMapper.map(dwarfDTO);
        dwarf = dwarfRepository.save(dwarf);
        return dwarfMapper.map(dwarf);
    }

    // Delete dwarf - it must be VOID
    public void deleteDwarf(Long id) {
        dwarfRepository.deleteById(id);
    }

    public DwarfDTO updateDwarf(Long id, DwarfDTO dwarfDTO) {
        Optional<DwarfModel> existentDwarf = dwarfRepository.findById(id);
        if (existentDwarf.isPresent()) {
            DwarfModel updatedDwarf = dwarfMapper.map(dwarfDTO);
            updatedDwarf.setId(id);
            DwarfModel savedDwarf = dwarfRepository.save(updatedDwarf);
            return dwarfMapper.map(savedDwarf);
        }
        return null;
    }
}
