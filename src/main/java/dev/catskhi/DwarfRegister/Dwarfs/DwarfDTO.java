package dev.catskhi.DwarfRegister.Dwarfs;

import dev.catskhi.DwarfRegister.Quests.QuestsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DwarfDTO {

    private Long id;
    private String name;
    private String email;
    private String imgUrl;
    private int age;
    private String rank;
    private QuestsModel quests;

}
