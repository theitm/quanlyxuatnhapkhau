package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_tax_bracket")
public class TaxBracketEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    private String tax_bracket_name;
    private String description;
    private Float coefficient;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "taxBracketEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<TypeOfCommodityEntity> typeOfCommodities = new ArrayList<>();
}