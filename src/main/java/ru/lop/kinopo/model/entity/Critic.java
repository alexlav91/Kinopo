package ru.lop.kinopo.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "critic")
@Setter
@Getter
public class Critic {
    @Id
    @GenericGenerator(
            name = "ID_GENERATOR",
            strategy = "increment",
            parameters = @org.hibernate.annotations.Parameter(name = "sequence_name", value = "MY_SEQUENCE")
    )
    @GeneratedValue(generator = "ID_GENERATOR")
    private long id;
    @Column(name="name_of_critic")
    private String nameOfCritic;
    @Column(name="surname")
    private String surnameOfCritic;
    @Column(name="personal_information")
    private String personalInformation;
    @OneToMany(mappedBy = "critic")
    private List<Review> reviewList;
}
