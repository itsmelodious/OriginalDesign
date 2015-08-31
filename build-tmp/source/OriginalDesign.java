import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OriginalDesign extends PApplet {

int starSize;
int starX;
int starY;
int num = 0;
int x = 100;
int squareX = 8;

public void setup()
{
  size(700, 450);
  background(32);
  frameRate(150);
}
public void draw()
{
  star();
  cat();
}

public void star()
{
  noStroke();
  if (num <= 700)
  {
    starSize = (int)(Math.random()*5)+1;
    starX = (int)(Math.random()*701);
    starY = (int)(Math.random()*451);
    fill(255);
    ellipse(starX, starY, starSize, starSize);
    num++;
    if (num == 700)
    {
      background(32);
      num = 0;
    }
  }
}

public void cat()
{
  if ( x < 800)
  {
    fill(32);

    // clear trail
    rect(squareX, 165, 160, 140);
    squareX++;

    // ears
    int topOfEar = x + 10;
    int rightOfEar = x+30;
    int leftOfEar = x+16;
    fill(252, 234, 192);
    triangle(topOfEar, 165, rightOfEar, 175, leftOfEar, 190);
    triangle(topOfEar + 55, 165, rightOfEar + 34, 190, leftOfEar + 30, 175);

    // tail
    stroke(252, 234, 192);
    strokeWeight(10);
    noFill();
    bezier(x - 85, 175, x - 40, 170, x - 85, 230, x - 45, 240);

    // legs
    noStroke();
    fill(252, 234, 192);
    ellipse(x - 30, 260, 15, 40);
    ellipse(x - 10, 260, 15, 40);
    ellipse(x + 27, 260, 15, 40);
    ellipse(x + 45, 260, 15, 40);

    // head
    fill(255, 189, 23);
    ellipse(x + 40, 200, 50, 50);
    
    // eyes
    fill(0);
    ellipse(x+27, 200, 5, 5);
    ellipse(x+53, 200, 5, 5);

    // body
    fill(255, 189, 23);
    ellipse(x + 5, 240, 100, 50);
    x++;
  }
  if (x == 800)
  {
    x = 100;
    squareX = 5;
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OriginalDesign" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
