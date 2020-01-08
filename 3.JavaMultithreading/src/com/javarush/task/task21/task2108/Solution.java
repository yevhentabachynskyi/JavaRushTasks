package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/
public class Solution implements Cloneable{
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }
        @Override
        public Tree clone() throws CloneNotSupportedException {
            Tree clone = (Tree) super.clone();
            clone.branches = new String[branches.length];
            for (int i = 0; i < branches.length; i++)
                branches[i] = clone.branches[i];
            return clone;

        }
    }
}
