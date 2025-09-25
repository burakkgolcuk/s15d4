// src/main/java/org/example/WorkintechList.java
package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WorkintechList<E extends Comparable<? super E>> extends ArrayList<E> {

    // Aynı elemanı birden fazla ekleme (engelle)
    @Override
    public boolean add(E e) {
        if (e == null) return false;              // null eklemeyelim (sıralamada sorun çıkarır)
        if (this.contains(e)) return false;
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        if (element == null || this.contains(element)) return;
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (e != null && !this.contains(e)) {
                super.add(e);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean modified = false;
        int i = index;
        for (E e : c) {
            if (e != null && !this.contains(e)) {
                super.add(i++, e);
                modified = true;
            }
        }
        return modified;
    }

    // Parametresiz sort: String ise A→Z, sayısal ise küçük→büyük (Comparable ile)
    public void sort() {
        Collections.sort(this);
    }

    // Sil ve ardından sıralamayı güncelle
    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        if (removed) {
            Collections.sort(this);
        }
        return removed;
    }
}
