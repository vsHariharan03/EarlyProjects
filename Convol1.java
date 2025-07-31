import java.io.*;
import java.nio.file.*;
import java.util.*;
public class Convol1

{


  public static void main(String args[]) throws Exception{
String data=("C:\\Users\\vshar\\Datasets\\mnist_784_csv.csv");
BufferedReader in=new BufferedReader(new FileReader(data));
in.readLine();

String a="";
String a1[];
int ac=0;
int dtlen =70000;
int input[][]=new int [28][28];
int ans[][]=new int[20][20];


String st="";
BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\vshar\\Datasets\\mnist_corrected2"));
  double i1[]=new double[784];
while(true){
if(ac==dtlen){
 break;
}
ac++;

 a1=in.readLine().split(",");

for(int i=0;i<input.length;i++){
for(int j=0;j<input.length;j++){
 input[i][j]=Integer.parseInt(a1[(i*28)+j]);
}
}

      ans= scale(input,ans.length,ans[0].length);
      ans=recenter1(ans);

for(int i=0;i<ans.length;i++){
for(int j=0;j<ans.length;j++){
 st=st+Integer.toString((int)ans[i][j])+",";
}
}
st+=a1[a1.length-1];

 for(int i=0;i<ans.length;i++){
 for(int j=0;j<ans[0].length;j++){    
  ans[i][j]=0;
}
 }

bw.write(st);
bw.newLine();
st="";
if(ac%700==0){
 System.out.println((ac/700)+"...");
}

}
bw.close();
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

b=scale(b,b.length+s,b[0].length+s);
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
}
