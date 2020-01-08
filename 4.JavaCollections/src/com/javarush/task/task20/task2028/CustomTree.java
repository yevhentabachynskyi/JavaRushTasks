package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    int count = 0;
    List<Entry> entryList = new ArrayList<>();
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

/*
    @Override
    public int size() {
        return count;
    }

    private Entry findFreeNode(Entry node){
       if (node.isAvailableToAddChildren())
           return node;
        else {
           if (node.availableToAddLeftChildren)
               return findFreeNode(node.leftChild);
           else
               return findFreeNode(node.rightChild);
       }
    }

    public Entry findItem(Entry node,String s){
        Entry tmp = null;
        if (node.elementName.equals(s))
            tmp=node;
            else{
             if ((tmp==null) && (node.availableToAddLeftChildren))
                 tmp = findItem(node.leftChild,s);
             if ((tmp==null) &&(node.availableToAddRightChildren))
                 tmp = findItem(node.rightChild,s);
        }
        return tmp;
    }



    @Override
    public boolean add(String s) {
        Entry<String> t = root;
        t = findFreeNode(t);
        if(t.availableToAddLeftChildren){
            t.leftChild = new Entry<String>(s);
            t.leftChild.parent = t;
            t.availableToAddLeftChildren = false;
            entryList.add(t);
        }
        else{
            t.rightChild=new Entry<String>(s);
            t.rightChild.parent = t;
            t.availableToAddRightChildren = false;
            entryList.add(t);
        }
        count ++;
        return true;
    }
*/
    @Override
    public int size() {
            //return entryList.size()-1;
        return count;
    }
    public Entry findItem(Entry node,String s){
        Entry tmp = null;
        if (node.elementName.equals(s))
            tmp=node;
        else{
            if ((tmp==null) && (node.availableToAddLeftChildren))
                tmp = findItem(node.leftChild,s);
            if ((tmp==null) &&(node.availableToAddRightChildren))
                tmp = findItem(node.rightChild,s);
        }
        return tmp;
    }

    @Override
    public boolean add(String s) {
        Entry tmp = new Entry<String>(s);
        if (entryList.size()>0){
            for (Entry t: entryList){
                if(t.availableToAddLeftChildren){
                    entryList.add(tmp);
                    tmp.parent = t;
                    t.availableToAddLeftChildren = false;
                    count++;
                    return true;
                }
                else{
                    entryList.add(tmp);
                    tmp.parent = t;
                    t.availableToAddRightChildren = false;
                    count++;
                    return true;
                }

            }

        }
     return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof String){
          for (Entry e: entryList) {
              if (e.elementName.equals(o))
                  if(!e.isAvailableToAddChildren()) {
                      entryList.remove(e);
                      if (e == e.parent.leftChild){
                          e.parent.availableToAddLeftChildren = true;
                      }
                      else{
                          e.parent.availableToAddRightChildren = true;
                      }
                    count--;
                      return true;
                  }
                    /*  else if (e.availableToAddLeftChildren) {
                        entryList.remove(e);
                        entryList.remove(e.leftChild);
                        e.parent.availableToAddLeftChildren = true;
                        return true;
                      }*/ else {
                       /* entryList.remove(e);
                        entryList.remove(e.rightChild);
                        e.parent.availableToAddRightChildren = true;*/
                        entryList.remove(findItem(e,(String)o));
                      if (e == e.parent.leftChild){
                          e.parent.availableToAddLeftChildren = true;
                      }
                      else{
                          e.parent.availableToAddRightChildren = true;
                      }
                      if (count>2 && count%2==0)
                        count=count/2+1;
                      else
                          count=count/2;
                        return true;
                      }
                }
          //  remove(o);
        }
        else
        {
            throw new UnsupportedOperationException();
        }
        return false;
    }

    public  String getParent(String s){
        for (int i = 0; i < entryList.size(); i++){
            if (entryList.get(i).elementName.equals(s))
                return entryList.get((i-1)/2).elementName;
        }
        return "";
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    public CustomTree() {
        this.root = new Entry<>("0");
        entryList.add(root);
    }

/*
  public  String getParent(String s){
      return findItem(root,s).parent.elementName;
    }*/

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren(){
        return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }


}
