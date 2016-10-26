package com.github.yukihane.java.dozer.to;

import java.util.List;

public class ToParent {

    private ToInterElement element;

    private List <ToChild> children;

    public ToInterElement getElement() {
        return element;
    }

    public void setElement(final ToInterElement element) {
        this.element = element;
    }

    public List <ToChild> getChildren() {
        return children;
    }

    public void setChildren(final List <ToChild> children) {
        this.children = children;
    }

}
