package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
    private Shape shape;
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    private void setBorderColor(Shape shape){
        System.out.println("Setting the border color for " + shape.getClass().getSimpleName() + " to red.");
    }

    @Override
    public void draw() {
        shape = super.decoratedShape;
        setBorderColor(shape);
        shape.draw();
    }
}
