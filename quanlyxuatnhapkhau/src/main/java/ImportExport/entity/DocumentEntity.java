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
@Table(name = "tb_document")
public class DocumentEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    public UUID id;
    public String idImportExport;
    public String imageUrl;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(optional=false)
    @JoinColumn(name = "importExportEntity_id",nullable = false)
    private ImportExportEntity importExportEntity;

}