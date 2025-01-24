package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DwarfService {

    private DwarfRepository dwarfRepository;

    public DwarfService(DwarfRepository dwarfRepository) {
        this.dwarfRepository = dwarfRepository;
    }

    // List all dwarfs
    public List<DwarfModel> listDwarfs() {
        return dwarfRepository.findAll();
    }

    public DwarfModel getDwarfsById(Long id) {
        Optional<DwarfModel> dwarfById = dwarfRepository.findById(id);
        return dwarfById.orElse(null);
    }

    public DwarfModel createDwarf(DwarfModel dwarf) {
        return dwarfRepository.save(dwarf);
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
