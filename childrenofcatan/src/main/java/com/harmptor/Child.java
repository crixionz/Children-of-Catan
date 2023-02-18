package com.harmptor;

public abstract class Child {
    private final String sex;

    // Constructor, used by class Girl and Boy
    Child(String sex){
        this.sex = sex;
    }
    
    public static Child create(String sex){
        if (sex.startsWith("f")) {
            return new Girl();
        } else {
            return new Boy();
        }
    }

    public String getGender(){
        return (this.sex == "male") ? "Boy " : "Girl"; // whitespace for prettier formatting
    }
}
