package com.mydd.model;

import java.util.Arrays;

public class One2NNode {
    public One2NNode parent;
    public One2NNode[] children = new One2NNode[0];
    public One2NNode(One2NNode parent) {
        this.parent = parent;
    }
    public One2NNode(One2NNode[] children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(children);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof One2NNode) || !(this == (One2NNode) obj)) return false;
        return true;
    }
}
