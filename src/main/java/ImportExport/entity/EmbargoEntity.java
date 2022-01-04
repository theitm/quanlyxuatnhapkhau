package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_embargo")

public class EmbargoEntity  {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    private UUID idTypeOfCommodity;
    private UUID idCountry;
    private String description;
    private int activate;
    private Integer active;

}