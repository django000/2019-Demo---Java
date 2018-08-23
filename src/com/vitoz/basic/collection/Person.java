package com.vitoz.basic.collection;

public class   Person implements Comparable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return this.name + " :: "+ this.age;
    }

    @Override
    public int hashCode(){
        System.out.println(this.name+"....hashCode");
        return name.hashCode()+age*37;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Person)){
            return false;
        }
        Person p = (Person) obj;
        System.out.println(this.name+"...equals.."+p.name);
        return this.getName().equals(p.getName()) && this.getAge() == p.getAge();
    }

    @Override
    public int compareTo(Object obj){
        if (!(obj instanceof Person)){
            throw new RuntimeException("不是Person对象");
        }
        int tmp = this.getAge() - ((Person) obj).getAge();
        if (tmp == 0){
            tmp = this.getName().compareTo(((Person) obj).getName());
        }
        return tmp;
    }
}