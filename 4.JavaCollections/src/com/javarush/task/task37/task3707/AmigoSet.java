package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by XPMUser on 5/10/19.
 */
public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public static void main(String[] args) {

    }
    public AmigoSet() {
      map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int  capacity = Math.max((int) (collection.size() / .75f) + 1, 16);
        map = new HashMap<>(capacity);
        for (E e: collection)
            map.put(e, PRESENT);

    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return null == map.remove(o);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        } catch(Exception e){
            throw new InternalError(e);
        }

    }
    private void writeObject (ObjectOutputStream s) throws Exception {
        s.defaultWriteObject();

        s.writeObject(map.size());
        for(E e:map.keySet()){
            s.writeObject(e);
        }
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));

    }
    private void readObject (ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = (int)s.readObject();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)s.readObject());
        }
        int capacity = (int)s.readObject();
        float loadFactor = (float)s.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }

    @Override
    public boolean add(Object o) {
        return null == map.put((E) o,PRESENT);
    }
}
