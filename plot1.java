import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.Arrays;

public class plot1 extends JComponent {

public void paintComponent(Graphics g)
{   
     //w is x, and h is y (as in x/y values in a graph)
     int w = this.getWidth()/2;
     int h = this.getHeight()/2;
//    w=w-180;
 Graphics2D g1 = (Graphics2D) g;
 g1.setStroke(new BasicStroke(2));
 g1.setColor(Color.black);
 g1.drawLine(0,h,this.getWidth(),h);
 g1.drawLine(w,0,w,h*2); 
 g1.drawString("0", w  , h  );
 double x[][]={{9,1},{8,7},{9,6}};


 Graphics2D g2 = (Graphics2D) g;
 g2.setStroke(new BasicStroke(2));
  g2.setColor(Color.green);
  //line1
 Graphics2D g3 = (Graphics2D) g;
 g3.setStroke(new BasicStroke(2));
  

  Polygon p = new Polygon();
  Polygon p1 = new Polygon();
  double x1=0;
 double x2=0;
 double r1=0;
  int w1=w;
  int w2=w;
int h1=h;
 double tar[]={1,4};
 double xc[]={0,0};
 double xr[]={0,0};
 double xe[]={0,0};
 double xco[]={0,0};
 double xci[]={0,0};
 double xb[]={0,0};

double er[]={0,0,0};
int b[]=new int[er.length];
int bl=b.length-1;
double err=0, 
       erc=0,
       ere=0,
       erco=0,
       erci=0,
       erb=0;


double alp=1;
double bet=0.5;
double del=0.5;
double temi=0;




 x2=0;
  




 er[0]=error(tar,x[0]);
 er[1]=error(tar,x[1]);
 er[2]=error(tar,x[2]);
 b=find(er);

 xc= cent(x[b[0]],x[b[1]],xc);
 xr= refl(xc,xr,x[b[bl]],alp);
 xe= expa(xc,xe,xr,del);
 xci=conin(xc,xci,x[b[bl]],bet);
 xco=conot(xc,xco,x[b[bl]],bet);
 xb=btw(x[b[bl]],xc,xb,0);


 err=error(tar,xr);
 erc=error(tar,xc);
 ere=error(tar,xe);
 erco=error(tar,xco);
 erci=error(tar,xci);


//fh=maxj f(j),fs=maxj≠h f(j),fl=minj≠h f(j).
//Determine the indices h,s,l of the worst, ok and the best
 g2.setColor(Color.green);
 for(int i1=0;i1<=x.length-1;i1++){
  p.addPoint(w-(int)(x[i1][0]*20),h-(int)(x[i1][1]*20)) ;
}
  g2.drawPolygon(p.xpoints, p.ypoints , p.npoints);
  p = new Polygon();
 g2.setColor(Color.blue);
 for(int k1=0;k1<x.length;k1++){
 for(int k=0;k<xr.length;k++){
 x[k1][k]-=(xc[k]-x[k1][k])*0.5;
}
}
 for(int i1=0;i1<=x.length-1;i1++){
  p.addPoint(w-(int)(x[i1][0]*20),h-(int)(x[i1][1]*20)) ;
}
  g2.drawPolygon(p.xpoints, p.ypoints , p.npoints);
  p = new Polygon();
//System.out.println("ex");
 er[bl]=ere;
/*
if(er[bl]>err){
 for(int k=0;k<xr.length;k++){
 x[b[bl]][k]=xr[k];
}
//System.out.println("re");\
 er[bl]=err;
}
if(er[bl]>erco){
 for(int k=0;k<xr.length;k++){
 x[b[bl]][k]=xco[k];
}
//System.out.println("co");
 er[bl]=erco;
}
if(er[bl]>erci){
 for(int k=0;k<xr.length;k++){
 x[b[bl]][k]=xci[k];
}
//System.out.println("ci");
 er[bl]=erci;
}
if(er[bl]>ersh){
 for(int k=0;k<xr.length;k++){
 x[b[bl]][k]=xsh[k];
}
//System.out.println("sh");
 er[bl]=ersh;
}
*/

System.out.println(b[bl]);

 for(int i1=0;i1<x.length;i1++){
 for(int j=0;j<x[0].length;j++){
// x[i1][j]+=(Math.random()-0.5)*0.2;
}
}

       w2=w1;
      h1=h-(int)x2;
//      w1=w1+2;
   r1+=0.01;

      // x3=x3+0.01
 

//  g2.drawPolygon(p.xpoints, p.ypoints , p.npoints);
// g3.setColor(Color.blue);
// g1.drawPolyline(p1.xpoints, p1.ypoints , p1.npoints);
   
 System.out.println("/-----/");

}
public static double[] btw(double xb[],double xr[],double x[],double alp){

  for(int i=0;i<x.length;i++){
  x[i]=(xr[i])-(xb[i]);
}
return x;
}

public static double[] cent(double x1[],double x2[],double xc[]){

  for(int i=0;i<x1.length;i++){
xc[i]=0;

xc[i]=(x1[i]+x2[i]);

xc[i]=xc[i]/(2);

}
return xc;
}
public static double[] refl(double xc[],double xr[],double x[],double alp){

  for(int i=0;i<xc.length;i++){
  xr[i]=(2*xc[i])-(x[i]);
}
return xr;
}
public static double[] expa(double xc[],double xe[],double xr[],double gam){

  for(int i=0;i<xc.length;i++){
  xe[i]=(xr[i])+gam*(xr[i]-xc[i]);
}
return xe;
}
public static double[] conin(double xc[],double xco[],double x[],double bet){
  for(int i=0;i<xc.length;i++){
  xco[i]=(xc[i])-bet*(xc[i]-x[i]);
}
return xco;
}
public static double[] conot(double xc[],double xco[],double x[],double bet){
  for(int i=0;i<xc.length;i++){
  xco[i]=(xc[i])+bet*(xc[i]-x[i]);
}
return xco;
}

public static double error(double tar[],double ini[]){
double err=0;
for(int i=0;i<tar.length;i++){
err+=Math.abs(tar[i]-ini[i]);
}
return err;
}
public static int[] find(double a[]){
int ans[] = new int[3];


int r=a.length-1;

double a1[]=new double[a.length];
for(int i=0;i<=r;i++){
 a1[i]=a[i];
}
Arrays.sort(a1);

double r1=a1[0];
double r2=a1[1];
double r3=a1[2];

int l1=0;
int l2=0;
int l3=0;
for(int i=0;i<=r;i++){
 if(a[i]==r1&&l1==0){
 ans[0]=i;
 l1++;
}
 if(a[i]==r2&&l2==0){
 ans[1]=i;
 l2++;
}
 if(a[i]==r3&&l3==0){
 ans[2]=i;
 l3++;
}
}
return ans;
}
public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(1000, 1000);
    frame.setTitle("Graphs");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);  
    plot1 draw = new plot1();
    frame.add(draw);
    frame.setVisible(true);
    
}


}