package model.entities;

import java.util.Objects;

public class Person {
    private String name;
    private Integer modeling;
    private Integer git;
    private Integer java;
    private Integer apiRest;
    private Integer spring;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModeling() {
        return modeling;
    }

    public void setModeling(Integer modeling) {
        this.modeling = modeling;
    }

    public Integer getGit() {
        return git;
    }

    public void setGit(Integer git) {
        this.git = git;
    }

    public Integer getJava() {
        return java;
    }

    public void setJava(Integer java) {
        this.java = java;
    }

    public Integer getApiRest() {
        return apiRest;
    }

    public void setApiRest(Integer apiRest) {
        this.apiRest = apiRest;
    }

    public Integer getSpring() {
        return spring;
    }

    public void setSpring(Integer spring) {
        this.spring = spring;
    }

    public Double getSkillLevel() {
        return (apiRest + git + java + spring + modeling) / 5.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && modeling.equals(person.modeling) && git.equals(person.git) && java.equals(person.java) && apiRest.equals(person.apiRest) && spring.equals(person.spring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, modeling, git, java, apiRest, spring);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", modeling=" + modeling +
                ", git=" + git +
                ", java=" + java +
                ", apiRest=" + apiRest +
                ", spring=" + spring +
                ", skill=" + getSkillLevel() +
                '}';
    }


}
