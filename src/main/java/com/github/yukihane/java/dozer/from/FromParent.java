package com.github.yukihane.java.dozer.from;

import java.util.List;

public class FromParent {

    private List <FromChild> children;

    public FromParent() {
    }

    public FromParent(final List <FromChild> children) {
        this.children = children;
    }

    public List <FromChild> getChildren() {
        return children;
    }

    public void setChildren(final List <FromChild> children) {
        this.children = children;
    }

}
