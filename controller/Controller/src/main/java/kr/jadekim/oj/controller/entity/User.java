package kr.jadekim.oj.controller.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ohyongtaek on 2016. 1. 19..
 */
@Entity
@Table(name="tbl_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="login_id")
    private String loginId;

    @Column(name="login_pw")
    private String loginPw;

    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="rate")
    private double rate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="problems")
    private List<Problem> problems;


    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public List<Team> getTeamList() {

        return teamList;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public String getLoginId() {
        return loginId;
    }

    @OneToMany(fetch = FetchType.EAGER)

    @JoinColumn(name="team_id")
    private List<Team> teamList;

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToOne
    @JoinColumn(name="group_id")
    private Group group;

    public User(){}

    public User(String loginId, String loginPw, String name, String email){
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.name = name;
        this.email = email;
        this.rate = 0;
        this.teamList = null;
        this.group = null;
        this.problems = new ArrayList<>();
        this.teamList = new ArrayList<>();
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public String getEmail() {
        return email;
    }

    public double getRate() {
        return rate;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public int getId() {
        return id;
    }

    public String getloginId() {
        return loginId;
    }

    public void setloginId(String loginId) {
        this.loginId = loginId;
    }

    public String getloginPw() {
        return loginPw;
    }

    public void setloginPw(String loginPw) {
        this.loginPw = loginPw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public User(String loginId) {
        this.loginId = loginId;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
