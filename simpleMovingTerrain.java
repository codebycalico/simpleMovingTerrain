PImage sky;
int cols,rows;
int scl=20;
int w=1800;
int h=1000;

float flying=0;
float[][] terrain;

void setup(){
  size(600, 600,P3D);
  cols = w/scl;
  rows=h/scl;
  terrain= new float [cols][rows];
  frameRate(60);
}

void draw(){
  background(100,0,200);
  flying -=  0.08;

//movement
  float yoff = flying;
   for (int y = 0; y < rows; y++){
  float xoff=0;
   for (int x = 0; x < cols; x++){
     terrain[x][y] = map(noise(xoff,yoff),0,1,-100,100);
     xoff += 0.15;
   }
    yoff +=0.15;
  }

  stroke(255);
  noFill();

  translate(width*0.5,height*0.5+50);
  rotateX(PI/3);
 
 
 //creates "terrain"
  translate(-w*0.5,-h*0.5);
  for (int y = 0; y < rows-1; y++){
    beginShape(TRIANGLE_STRIP);
    lights();
    noStroke();
    fill(255,216,0);
    for (int x = 0; x < cols; x++){
      vertex(x*scl,y*scl,terrain[x][y]);
      vertex(x*scl,(y+1)*scl,terrain[x][y+1]);
    }
    endShape();
  }
}