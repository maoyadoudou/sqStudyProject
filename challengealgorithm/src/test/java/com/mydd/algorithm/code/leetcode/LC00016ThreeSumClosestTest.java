package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00016ThreeSumClosestTest {

    @Test
    void threeSumClosest() {
        assertEquals(2, new LC00016ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4}, 1));
        assertEquals(0, new LC00016ThreeSumClosest().threeSumClosest(new int[]{0,0,0}, 1));
        assertEquals(9, new LC00016ThreeSumClosest().threeSumClosest(new int[]{5,2,2,8}, 1));
        assertEquals(1, new LC00016ThreeSumClosest().threeSumClosest(new int[]{-5,-2,-2,8}, 1));
        assertEquals(-9, new LC00016ThreeSumClosest().threeSumClosest(new int[]{-5,-2,-2,-8}, 1));
        assertEquals(0, new LC00016ThreeSumClosest().threeSumClosest(new int[]{5,0,0,0,3}, 1));
        assertEquals(129, new LC00016ThreeSumClosest().threeSumClosest(new int[]{-12,-10,32,88,4,64,-57,-57,62,0,74,95,-23,10,-21,80,-74,36,-54,17,-97,-8,-86,43,95,-76,-18,-43,-43,31,-64,-96,-66,-42,-88,-44,-6,-2,16,-6,90,-45,52,48,-6,58,21,7,-18,73,-75,-90,-34,6,3,94,26,33,-92,73,-25,-67,16,-99,-90,-40,19,-78,-53,-36,28,82,33,66,-27,54,-34,-30,27,51,-32,-13,-52,37,-41,-95,68,56,23,57,25,-69,-65,43,-60,-41,-51,77,44,-6,-19,-87,-43,-54,97,82,-54,-13,82,43,-83,100,37,-34,-56,-65,-7,27,-25,-82,91,-76,46,-29,-78,69,-21,25,-10,71}, 129));
    }
}