package com.github.yukihane.java.dozer.from;

import java.util.List;

public class FromParent {

    private FromInterElement element;

    private List <FromChild> children;

    public FromParent() {
    }

    public FromParent(final List <FromChild> children) {
        this.children = children;
    }

    public FromInterElement getElement() {
        return element;
    }

    public void setElement(final FromInterElement element) {
        this.element = element;
    }

    public List <FromChild> getChildren() {
        return children;
    }

    public void setChildren(final List <FromChild> children) {
        this.children = children;
    }

}
