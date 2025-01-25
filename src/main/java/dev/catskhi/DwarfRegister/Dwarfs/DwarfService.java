package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DwarfService {

    private DwarfRepository dwarfRepository;
    private DwarfMapper dwarfMapper;

    public DwarfService(DwarfRepository dwarfRepository, DwarfMapper dwarfMapper) {
        this.dwarfRepository = dwarfRepository;
        this.dwarfMapper = dwarfMapper;
    }

    // List all dwarfs
    public List<DwarfModel> listDwarfs() {
        return dwarfRepository.findAll();
    }

    public DwarfModel getDwarfsById(Long id) {
        Optional<DwarfModel> dwarfById = dwarfRepository.findById(id);
        return dwarfById.orElse(null);
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

    public DwarfModel updateDwarf(Long id, DwarfModel updatedDwarf) {
        if (dwarfRepository.existsById(id)) {
            updatedDwarf.setId(id);
            return dwarfRepository.save(updatedDwarf);
        }
        return null;
    }
}
