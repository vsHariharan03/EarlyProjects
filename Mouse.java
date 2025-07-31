import java.awt.*;  
import java.awt.event.*;  
import javax.swing.JFrame;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
public class Mouse extends JFrame implements MouseMotionListener{  

static int can[][]=new int[56][56];
static int ch[][]=new int[28][28];
static int x=200;
static int y=250;
final static int arc[]={784,16,18,10};

static  double node[]=new double[ arc[1]+arc[2]+arc[3] ];



    Mouse () throws Exception  { 
      
        addMouseMotionListener(this);  
        setSize(500,600);  
        setLayout(null);  
        setVisible(true);  
    }  
public void mouseDragged(MouseEvent e) {  
int a=e.getX();
int b=e.getY();


 if( ( (x<a)&&((56*2)+x>a) ) && ( (y<b)&&((56*2)+y>b) ) ){
a=(56*2)+x-a;
a=56-(a/2)-1;


b=(56*2)+y-b;
b=56-(b/2)-1;

can[a][b]=250;

boolean a1=(((a+1)<56)&&((b+1)<56));
boolean a2=(((a-1)>=0)&&((b-1)>=0));
if(a1){
can[a+1][b+1]=250;
can[a][b+1]=180;
can[a+1][b]=180;


if(((a+2)<50)&&((b+2)<50)){
can[a+2][b+2]=200;
can[a+1][b+2]=200;
can[a+2][b+1]=200;
can[a][b+2]=200;
can[a+2][b]=200;
}

}
if(a2){
can[a-1][b-1]=250;
can[a][b-1]=180;
can[a-1][b]=180;

if(((a-2)>=0)&&((b-2)>=0)){
can[a-2][b-2]=200;
can[a-1][b-2]=200;
can[a-2][b-1]=200;
can[a][b-2]=200;
can[a-2][b]=200;
}

}
if(a1&&a2){
can[a-1][b+1]=250;
can[a+1][b-1]=250;
}

  Graphics g=getGraphics();
 g.setColor(new Color(255,255,255 ));
 g.fillRect((a*2)+x,(b*2)+y,4,4); 
}


}  
 public void mouseMoved(MouseEvent e) {}  
 

 public static void main(String[] args) throws Exception {   
 Mouse ob= new  Mouse();
     Graphics g=ob.getGraphics();

  Scanner in = new Scanner ( new FileReader( "C:\\Users\\vshar\\OneDrive\\Documents\\10th\\Datasets\\mnist_best2"  ));//mnist_best
        in.useDelimiter(",");
int wlen=0;
for(int i=0;i<arc.length-1;i++){
 wlen+=(arc[i]*arc[i+1]);
 wlen+=arc[i+1];
}
 double wts[]=new double[wlen];
       for(int i=0;i<wts.length;i++){
//    System
     wts[i]=Double.parseDouble( in.next() );
}

in.close();
try{   Thread.sleep(150);}    catch(Exception e){ System.out.println("AAAAAAAAHHHHHHHHHH!!!!!!!!");}  


  Button bu1=new Button("Find");  

   bu1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
    double i1[]=new double[784];
   double ans[]=new double[10];
 int cn=0;
 for(int i=0;i<10;i++){
   cn=(int)((1-ans[i])*100);
  g.clearRect(180+(i*20) -1 , 180-cn-1 , 15+2, cn+2);
  }
      cnvrt(ch,can);
      ch=recenter1(ch);
     ch=map(ch,0,250);

int col=0;
for(int i=0;i<28;i++){
 for(int j=0;j<28;j++){  
 col=ch[i][j];//(255>=a[i][j])?a[i][j]:255;
// k=Math.max(a[i][j]*4,k);
  //g.setColor(new Color(col,col,col) );    
 //g.fillRect((i*4)+50,(j*4)+440,4,4);   
}
 }

    // int cn=0;
    for(int i=0;i<28;i++){
 for(int j=0;j<28;j++){    
   i1[(j*28)+i]=( (ch[i][j])/200 );
//   cn++;
}
 }
  ans=nnet(arc,i1,wts);
   norm(ans);
//clearing inital array
for(int i=0;i<28;i++){
 for(int j=0;j<28;j++){  
 ch[i][j]=0;//(255>=a[i][j])?a[i][j]:255;
}
 }

  g.setColor(Color.black);
 for(int i=0;i<10;i++){
// System.out.println(i+" : "+Math.floor(ans[i]*1000)/10);
   cn=(int)((ans[i])*100);
  
  g.drawRect(180+(i*20)  , 180-cn , 15, cn);
  g.drawString(""+i, 180+(i*20)+2  , 200  );
  }
    }  
    });
    bu1.setBounds(  400/2 ,    400+50,       30,30); 


  Button bu2=new Button("Clear");  

   bu2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){ 
 g.setColor(Color.black);  
      for(int i=0;i<56;i++){
 for(int j=0;j<56;j++){  
  g.fillRect((i*2)+x,(j*2)+y,2,2); 
 can[i][j]=0;
 if(i<28){
 if(j<28){
 ch[i][j]=0;
}
}
}
 }
    }  
    });
    bu2.setBounds(  (400/2)+50 ,    400+50,       30,30); 


try{   Thread.sleep(200);}catch(Exception e){ System.out.println("AAAAAAAAHHHHHHHHHH!!!!!!!!");}  
  ob.add(bu1);
  ob.add(bu2);
try{   Thread.sleep(200);}catch(Exception e){ System.out.println("AAAAAAAAHHHHHHHHHH!!!!!!!!");}  

 g.setColor(Color.black);  
 for(int i=0;i<56;i++){
 for(int j=0;j<56;j++){  
 g.fillRect((i*2)+x,(j*2)+y,2,2);   

}
 }


}  


public static void cnvrt(int a[][],int b[][]){


 for(int i=0;i<56;i++){
 for(int j=0;j<56;j++){    
 a[(int)(i/2)][(int)(j/2)]+=b[i][j]/4;
}
 }

// int k=0;

 
//System.out.println(k);

}
public static double[] nnet (int b[],double in[],double w[]){
     
         double hid[];
       
 // double b1[]=new double[5];
   hid=in;
 
int c=0;//a[0]*a[1];
int c1=0;

  for(int i=0;i<b.length-1;i++){
   hid=layer(b[i],b[i+1],hid,w,c,c1); 
for(int j=0;j<hid.length;j++){
 node[j+c1]=hid[j];
} 
//   System.out.println("iob - "+i+" a - "+b[i]);
   c+=(b[i]*b[i+1]);
   c1+=b[i+1];



 // System.out.println("---");
}
  
        //h[m]=(i[0]*w[0+(m*9)])+(i[1]*w[1+(m*9)])+(i[2]*w[2+(m*9)]);
  return hid;
} 
  public static double[] layer( int a,int b,double a1[] ,double w[],int r,int r1){
 
  double layer2[]=new double[b]; 
// Arrays.fill(layer2,0);
  int c=r; 
  int c1=r1;
for(int i1=0;i1<b;i1++){
  layer2[i1]=0;
  for(int i=0;i<a;i++){
  layer2[i1]+= (((w[c]))*a1[i]);
 // System.out.println("layer["+i1+"]+=w["+c+"]* a1["+i+"]; : "+(w[c])+" , "+(a1[i])+" , "+layer2[i1]);  
 c++;
}

  layer2[i1]+=w[(w.length-c1-1)];
//  System.out.println("layer["+i1+"]+=w["+( (w.length-c1-1) )+"]; : "+(w[(w.length-c1-1)])+" , "+" , "+sigmoid(layer2[i1]) );  
 layer2[i1]=sigmoid(layer2[i1]); 
 c1++; 
}

 return (layer2);
}
   public static double tanh(double z){
//  double ans=0;
  double e1=Math.pow(Math.E,z);
  double e2=Math.pow((Math.E),-z);
//  ans=(e1-e2)/(e1+e2);
  return (e1-e2)/(e1+e2);

}
   public static double sigmoid(double z){

//double ans = 1/(1+(Math.pow(Math.E,-z)));

return 1/(1+(Math.pow(Math.E,-z)));
}
 public static void norm(double z[]){


double d=0;
for(int i=0;i<=z.length-1;i++){
 d+=(z[i]);
}
for(int i=0;i<=z.length-1;i++){
 z[i]=(z[i])/d;
}


}
 public static double mean(double f[]){
double a=0.01;
double b=0;
for(int i=0;i<f.length;i++){
 a+=f[i];
 b+=(i+1)*f[i];
}

return b/a;
}
 public static double mean(int f[]){
double a=0.01;
double b=0;
for(int i=0;i<f.length;i++){
 a+=f[i];
 b+=(i+1)*f[i];
}

return b/a;
}
 public static double mean(double m[],int f[]){
double a=0.01;
double b=0;
for(int i=0;i<f.length;i++){
 a+=f[i];
 b+=(i+1)*f[i];
}

return b/a;
}
 public static int[][] recenter(int f[][]){
int a[][]=new int[f.length][f[0].length];



boolean bx=true;
boolean by=true;
int x_max=0;
int y_max=0;
int x_min=100;
int y_min=100;
 for(int i=0;i<f.length;i++){
 for(int j=0;j<f.length;j++){
 if(f[i][j]!=0){

 x_min = Math.min(x_min,i);
 y_min = Math.min(y_min,j);

 x_max = Math.max(x_max,i);
 y_max = Math.max(y_max,j);
}
}
}




int x=(x_max+x_min)/2;
int y=(y_max+y_min)/2;



int shift_x=x-(f.length/2);
int shift_y=y-(f.length/2);


 for(int i=0;i<f.length;i++){
 for(int j=0;j<f.length;j++){
if( (i+shift_x)<0 ){
continue;
}
if( (j+shift_y)<0 ){
continue;
}
if( (i+shift_x)>=f.length ){
continue;
}
if( (j+shift_y)>=f.length ){
continue;
}
if( (f[i+ shift_x][j+ shift_y])==0 ){
continue;
}
 a[i][j]=f[i+ shift_x][j+ shift_y];
}
}
/*
int col=0;
 for(int i=0;i<50;i++){
 for(int j=0;j<50;j++){  
 col=(255>=a[i][j])?(int)a[i][j]:255;
  g.setColor(new Color(col,col,col) );    
 g.fillRect((i*2)+50,(j*2)+40,2,2);   
}
 }
*/
 //g.setColor(Color.RED);
// g.fillRect((14*4)+50+shift_x+(f.length/2),(14*4)+shift_x+40+(f.length/2),4,4);   
return a;
}
 public static int argmax1(double z[]){
int ans =0;
double s=-1E10;
for(int i=0;i<=z.length-1;i++){
 if(z[i]>s){
  ans = i ;
  s = z[i];
}
}

 return ans;
}
public static int[][] map(int a[][],int l,int u){
int maxx =0;
int maxy =0;
int minx =0;
int miny =0;
double s=-1E10;
double s1=1E10;
for(int i=0;i<a.length-1;i++){
for(int j=0;j<a[0].length-1;j++){
 if(a[i][j]>s){
  s = a[i][j];
}
 if(a[i][j]<s1){
  s1 = a[i][j];
}
}
}

for(int i=0;i<a.length-1;i++){
for(int j=0;j<a[0].length-1;j++){
 a[i][j]=(int)map(a[i][j],s,s1,u,l);
}
}

return a;
}
public static double map(double OldValue,double OldMax,double OldMin,double NewMax,double NewMin){
return  (((OldValue - OldMin) * (NewMax - NewMin)) / (OldMax - OldMin)) + NewMin;
}
public static int[][] recenter1(int f[][]){
int a[][]=new int[f.length][f[0].length];


 f=reshape(f);
boolean bx=true;
boolean by=true;
int x_max=0;
int y_max=0;
int x_min=100;
int y_min=100;
 for(int i=0;i<f.length;i++){
 for(int j=0;j<f.length;j++){
 if(f[i][j]!=0){

 x_min = Math.min(x_min,i);
 y_min = Math.min(y_min,j);

 x_max = Math.max(x_max,i);
 y_max = Math.max(y_max,j);
}
}
}
int x=(x_max+x_min)/2;
int y=(y_max+y_min)/2;



int shift_x=x-(f.length/2);
int shift_y=y-(f.length/2);


 for(int i=0;i<f.length;i++){
 for(int j=0;j<f.length;j++){
if( (i+shift_x)<0 ){
continue;
}
if( (j+shift_y)<0 ){
continue;
}
if( (i+shift_x)>=f.length ){
continue;
}
if( (j+shift_y)>=f.length ){
continue;
}
if( (f[i+ shift_x][j+ shift_y])==0 ){
continue;
}
 a[i][j]=f[i+ shift_x][j+ shift_y];
}
}

return a;
}
public static int[][] reshape(int a[][]){
int x_max=0;
int y_max=0;
int x_min=100;
int y_min=100;
 for(int i=0;i<a.length;i++){
 for(int j=0;j<a[0].length;j++){
 if(a[i][j]!=0){
 x_min = Math.min(x_min,i);
 y_min = Math.min(y_min,j);

 x_max = Math.max(x_max,i);
 y_max = Math.max(y_max,j);
}
}
}

if((y_min==100)&&(x_max==0)){
 return a;
}

int b[][]=new int[x_max-x_min+2][y_max-y_min+2];

for(int i=0;i<(x_max-x_min);i++){
for(int j=0;j<(y_max-y_min);j++){
 b[i][j]=a[i+x_min][j+y_min];
}
}

int s=Math.max(a.length,a[0].length)-Math.max(b.length,b[0].length);
//int sc=Math.max( b.length+s,b[0].length+s );
b=scale1(b,b.length+s,b[0].length+s);
//b=scale1(b,sc,sc);
 for(int i=0;i<a.length;i++){
 for(int j=0;j<a[0].length;j++){
 a[i][j]=0;
}
}
for(int i=0;i<b.length;i++){
for(int j=0;j<b[0].length;j++){
  a[i][j]=b[i][j];
}
}

return a;
}

public static int[][] scale(int src[][], int w, int h)
{
    int img[][] = new int[w][ h];
    int x, y;
    int ww = src.length;
    int hh =  src[0].length;
    float[] ys = new float[h];
    for (y = 0; y < h; y++)
        ys[y] = (float)(y * hh) /(float) h;

    for (x = 0; x < w; x++) {
        float newX = (float)(x * ww) /(float) w;
        for (y = 0; y < h; y++) {
             //        int col = src[(int)newX][ (int)ys[y]];
         int col=0;
         //if((Math.ceil(ys[y])<src[0].length)&&(Math.ceil(newX)<src.length))
         //  col=(int)pix_scale(newX, ys[y],src);
            col = src[(int)newX][ (int)ys[y]];

            img[x][y]=( col);
        }
    }
    return img;
}
public static int[][] scale1(int src[][], int w, int h)
{
    int img[][] = new int[w][ h];
    int x, y;
    int ww = src.length;
    int hh =  src[0].length;
    float[] ys = new float[h];
    for (y = 0; y < h; y++)
        ys[y] = (float)(y * hh) /(float) h;

    for (x = 0; x < w; x++) {
        float newX = (float)(x * ww) /(float) w;
        for (y = 0; y < h; y++) {
             //        int col = src[(int)newX][ (int)ys[y]];
         int col=0;
         //if((Math.ceil(ys[y])<src[0].length)&&(Math.ceil(newX)<src.length))
           col=(int)pix_scale(newX, ys[y],src);
          //  col = src[(int)newX][ (int)ys[y]];

            img[x][y]=( col);
        }
    }
    return img;
}
public static float pix_scale(float x,float y,int src[][]){
float rx=x-(int)x;
float ry=y-(int)y;

int x1=(int)x;
int y1=(int)y;

int x2=(int)Math.ceil(x);
int y2=(int)Math.ceil(y);
float col=0;
if(((y2>=src[0].length))&&(x2>=src.length)){
      col= (src[x1][y1])*((1-rx)*(1-ry));
     return col;   
}
if(x2>=src.length){
      col= (src[x1][y1])*((1-rx)*(1-ry))+
           //(src[x2][y1])*((  rx)*(1-ry))+
           (src[x1][y2])*((1-rx)*(  ry));
          // (src[x2][y2])*((  rx)*(  ry));
     return col;
}
if(y2>=src[0].length){
      col= (src[x1][y1])*((1-rx)*(1-ry))+
           (src[x2][y1])*((  rx)*(1-ry));
          //(src[x1][y2])*((1-rx)*(  ry));
          //(src[x2][y2])*((  rx)*(  ry));
     return col;
}
      col= (src[x1][y1])*((1-rx)*(1-ry))+
           (src[x2][y1])*((  rx)*(1-ry))+
           (src[x1][y2])*((1-rx)*(  ry))+
           (src[x2][y2])*((  rx)*(  ry));
return col;
}
public static int [][] Sharp(int [][] input1){
  double kernel[][]={
                  {0,-1,0},
                  {-1,4,-1},
                  {0,-1,0}
    };

     
    int kernelHeight = kernel.length;
    int kernelWidth = kernel[0].length;
    int width=input1[0].length;
    int height=input1.length;

    int [][] output = new int [width][height];
    double input[][]=new double[width+kernelWidth + 1][width+kernelHeight + 1];
//padding
   for(int i=0;i<input1.length;i++){
   for(int j=0;j<input1[0].length;j++){
   input[i][j]=input1[i][j];
 }
}
 //appliying kernel
    for(int i=0;i<output.length;++i){
      for(int j=0;j<output[0].length;++j){
	//output[i][j] = singlePixelConvolution(input,i,j,kernel,
	//				kernelWidth,kernelHeight);
             for(int i1=0;i1<kernelWidth;i1++){
      for(int j1=0;j1<kernelHeight;j1++){
	output[i][j] = (int)Math.max(output[i][j] + (input[i+i1][j+j1] * kernel[i1][j1]),0);
      }
    }
      }
    }
    return output;
  }
}