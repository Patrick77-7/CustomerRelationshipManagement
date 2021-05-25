package main.java;

public enum Products {
    HYBRID("hybrid"),
    FLATBED("flatbed"),
    BOX("box");

    private String name;

    Products(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


