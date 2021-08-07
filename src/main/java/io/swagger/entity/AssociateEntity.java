package io.swagger.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "SQ_TB_ASSOCIATE_ID", allocationSize = 1)
@Table(name = "associate")
public class AssociateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ASSOCIATE_ID")
    private Long associateId;
    private String name;
    private String cpfCnpj;

}
