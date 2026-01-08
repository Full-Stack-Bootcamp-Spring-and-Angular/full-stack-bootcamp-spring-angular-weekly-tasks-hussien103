package com.dependencyInjection;

public class Circle implements Shape
{

   public Draw2D draw2D;
   public Draw3D draw3D;
   //constructor injection
    public Circle(Draw2D draw2D, Draw3D draw3D)
    {
        this.draw2D = draw2D;
        this.draw3D = draw3D;
    }


    @Override
    public void drawShape2d() {
        draw2D.draw("circle");
    }


    @Override
    public void drawShape3d() {
        draw3D.draw("circle");

    }
}


