package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
