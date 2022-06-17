package ru.lop.kinopo.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "critic")
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

    @OneToMany
    private List<Review> reviewList;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfCritic() {
        return nameOfCritic;
    }

    public void setNameOfCritic(String nameOfCritic) {
        this.nameOfCritic = nameOfCritic;
    }

    public String getSurnameOfCritic() {
        return surnameOfCritic;
    }

    public void setSurnameOfCritic(String surnameOfCritic) {
        this.surnameOfCritic = surnameOfCritic;
    }

    public String getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(String personalInformation) {
        this.personalInformation = personalInformation;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
