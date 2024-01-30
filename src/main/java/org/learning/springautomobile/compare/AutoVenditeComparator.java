package org.learning.springautomobile.compare;

import org.learning.springautomobile.model.Auto;

import java.util.Comparator;

public class AutoVenditeComparator implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
        return Integer.compare(o1.vendite(), o2.vendite());
    }
}
