import java.util.*;
import java.io.*;
/**
 * Write a description of class Essentials1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Essentials2
{
public static void race_generator(short ans[][]){
//10 parents
 

 for(int i=0;i<=ans.length-1;i++){

  for(int i1=0;i1<=ans[0].length-1;i1++){
   
  ans[i][i1]=range();


 }

//System.out.println(per+"pr");

}

}
public static void nr_generator(int a[],int b[],short race[][]){
 
//6 parents

//String per="";
//String b1[]=a11.split("");
//String b2[]=a21.split("");
//int r=(int)(Math.round(Math.random()*5)+1);
int s1=a[(int)Math.floor(Math.random()*(a.length-1))];
int s2=a[(int)Math.floor(Math.random()*(a.length-1))];
if(s1==s2){
 s2=a[(int)Math.floor(Math.random()*(a.length-1))];
}
if(s1==s2){
 s2=a[(int)Math.floor(Math.random()*(a.length-1))];
} 
 
int w=race[0].length;
int p=race[0].length/5;//6-3
int p1=(int)(Math.random()*p);//1
int p2=(int)(Math.random()*p);//4(3+1)
int p3=(int)(Math.random()*p);//1
int p4=(int)(Math.random()*p);//4(3+1)
int p5=(int)(Math.random()*p);//1

 int k1=0;
short race1[]=new short[w];
short race2[]=new short[w];


   

 for(int i=0;i<=Math.floor(b.length/2)-1;i++){
 s1=a[(int)Math.floor(Math.random()*(a.length-1))];
 s2=a[(int)Math.floor(Math.random()*(a.length-1))];
for(int i1=0;i1<=w-1;i1++){
  race1[i1]=race[s1][i1];
}
for(int i1=0;i1<=w-1;i1++){
  race2[i1]=race[s2][i1];
} 
//int p=a11.length/5;//6-3
  p1=(int)(Math.random()*p);//1
  p2=(int)(Math.random()*p);//4(3+1)
  p3=(int)(Math.random()*p);//1
  p4=(int)(Math.random()*p);//4(3+1)
  p5=(int)(Math.random()*p);//1
//int p6=a11.length-(p1+p2);//1

//String s1[]=a11.split("");
//String s2[]=a21.split("");

for(int i3=0;i3<=p1;i3++){
 race[b[i]][i3]=race1[i3];//a11[i3];
}
for(int i3=p1+1;i3<=p1+p2;i3++){
 race[b[i]][i3]=race2[i3];//a21[i3];
}
for(int i3=p1+p2+1;i3<=p1+p2+p3;i3++){
 race[b[i]][i3]=race1[i3];
}
for(int i3=p1+p2+p3+1;i3<=p1+p2+p3+p4;i3++){
 race[b[i]][i3]=race2[i3];
}
for(int i3=p1+p2+p3+p4+1;i3<=p1+p2+p3+p4+p5;i3++){
 race[b[i]][i3]=race1[i3];
}
for(int i3=p1+p2+p3+p4+p5+1;i3<=w-1;i3++){
 race[b[i]][i3]=race2[i3];
}

}

 for(int i=(int)Math.floor(b.length/2);i<=(b.length-1);i++){
  s1=a[(int)Math.floor(Math.random()*(a.length-1))];
 s2=a[(int)Math.floor(Math.random()*(a.length-1))];
for(int i1=0;i1<=w-1;i1++){
  race1[i1]=race[s1][i1];
}
for(int i1=0;i1<=w-1;i1++){
  race2[i1]=race[s2][i1];
} 
  p1=(int)(Math.random()*p);//1
  p2=(int)(Math.random()*p);//4(3+1)
  p3=(int)(Math.random()*p);//1
  p4=(int)(Math.random()*p);//4(3+1)
  p5=(int)(Math.random()*p);//1
//int p6=a11.length-(p1+p2);//1

//String s1[]=a11.split("");
//String s2[]=a21.split("");

for(int i3=0;i3<=p1;i3++){
 race[b[i]][i3]=race2[i3];
}
for(int i3=p1+1;i3<=p1+p2;i3++){
 race[b[i]][i3]=race1[i3];
}
for(int i3=p1+p2+1;i3<=p1+p2+p3;i3++){
 race[b[i]][i3]=race2[i3];
}
for(int i3=p1+p2+p3+1;i3<=p1+p2+p3+p4;i3++){
 race[b[i]][i3]=race1[i3];
}
for(int i3=p1+p2+p3+p4+1;i3<=p1+p2+p3+p4+p5;i3++){
 race[b[i]][i3]=race2[i3];
}
for(int i3=p1+p2+p3+p4+p5+1;i3<=w-1;i3++){
 race[b[i]][i3]=race1[i3];
}
}


 




}

public static int[] p_find(double a[],int b){
int ans[] = new int[b];

double a1[]=new double[a.length];
int x=0;
for(int i=0;i<=a.length-1;i++){
 a1[i]=a[i];
}
Arrays.sort(a1);

 

for(int i=0;i<=ans.length-1;i++){

 for(int ip=0;ip<=a.length-1;ip++){

 if(a[ip]==a1[i]){ 
 ans[x]=ip;
 x++;
 if(x==ans.length){
  return ans;
 }
}
}

}
return ans;
}



public static int[] k_find(double a[],int b){
int ans[] = new int[b];

double a1[]=new double[a.length];
int x=0;
for(int i=0;i<=a.length-1;i++){
 a1[i]=-a[i];
}
Arrays.sort(a1);

 

for(int i=0;i<=ans.length-1;i++){

 for(int ip=0;ip<=a.length-1;ip++){

 if(a[ip]==a1[i]){ 
 ans[x]=ip;
 x++;
 if(x==ans.length){
  return ans;
 }
}
}

}
return ans;
}



 public static short range(){
 
  return (short)((6000*Math.random())-3000);
}
 public static double range1(double stat){
 // double max=(10-stat)*0.005;//10-stat;
 double max=(100-stat)*0.05;
 
 double ans;
   ans=((Math.random()*max));
   
  
  return ans;
}


   public static double[] nnet(int b[],double in[],short w[]){
     
         double hid[];
 
 // double b1[]=new double[5];
   hid=in;
 
int c=0;//a[0]*a[1];
int c1=0;
  for(int i=0;i<b.length-1;i++){
   hid=layer(b[i],b[i+1],hid,w,c,c1);  
//   System.out.println("iob - "+i+" a - "+b[i]);
   c+=(b[i]*b[i+1]);
   c1+=b[i+1];
}
  
        //h[m]=(i[0]*w[0+(m*9)])+(i[1]*w[1+(m*9)])+(i[2]*w[2+(m*9)]);
  return hid;
} 
  public static double[] layer( int a,int b,double a1[] ,short w[],int r,int r1){

 //double layer1[]=new double[a];
 double layer2[]=new double[b]; 
 //Arrays.fill(layer2,0);
  int c=r; 
  int c1=r1;
for(int i1=0;i1<b;i1++){
//layer2[]
  for(int i=0;i<a;i++){
  
  layer2[i1]+= (double)((((double)w[c])*0.004)*a1[i]); // 1 nueron


// System.out.println((transalate(read(w,c))));
// layer2[i1]= ( layer2[i1]);
 c++;
}

// layer2[i1]+=((double)((double)w[(w.length-c1-1)])*0.004);
 //System.out.println(transalate(read(w,((w.length()/4)-c1-1))));
//  layer2[i1]+=((double)((double)w[(w.length-c1-1)])*0.004);
 //System.out.println(transalate(read(w,((w.length()/4)-c1-1))));
  layer2[i1]=Leakyrelu(layer2[i1]);
 //layer2=softmax(layer2);

//layer2[i1]=0;
 c1++;
//System.out.println(i1+" : "+o[i1]);
}

 return (layer2);
}



   public static double[] nnet(int b[],double in[],double w[]){
     
         double hid[];
 
 // double b1[]=new double[5];
   hid=in;
 
int c=0;//a[0]*a[1];
int c1=0;
  for(int i=0;i<b.length-1;i++){
   hid=layer(b[i],b[i+1],hid,w,c,c1);  
//   System.out.println("iob - "+i+" a - "+b[i]);
   c+=(b[i]*b[i+1]);
   c1+=b[i+1];
}
  
        //h[m]=(i[0]*w[0+(m*9)])+(i[1]*w[1+(m*9)])+(i[2]*w[2+(m*9)]);
  return hid;
} 
  public static double[] layer( int a,int b,double a1[] ,double w[],int r,int r1){

 //double layer1[]=new double[a];
 double layer2[]=new double[b]; 
 Arrays.fill(layer2,0);
  int c=r; 
  int c1=r1;
for(int i1=0;i1<b;i1++){
  for(int i=0;i<a;i++){
  layer2[i1]+= (double)((((double)w[c]))*a1[i]); // 1 nueron
// System.out.println((transalate(read(w,c))));
// layer2[i1]= ( layer2[i1]);
 c++;
}

// layer2[i1]+=((double)((double)w[(w.length-c1-1)])*0.004);
 //System.out.println(transalate(read(w,((w.length()/4)-c1-1))));
  layer2[i1]+=((double)((double)w[(w.length-c1-1)]));
 //System.out.println(transalate(read(w,((w.length()/4)-c1-1))));
 layer2[i1]=tanh(layer2[i1]);
 //layer2=softmax(layer2);
 c1++;
//System.out.println(i1+" : "+o[i1]);
}

 return (layer2);
}
public static void muto(short a1[]){
double ans[]=new double[25];
 int r1=(int)Math.floor((Math.random()*(a1.length)));
int t=(int)(Math.random()*(a1.length));
  short z=(short)Math.floor(9000*Math.random() );
 //a1[r1]=z;

if(t%2==0){
 t=1;
}
else {
 t=0;
}



if(t==0&&a1[r1]+z<32000){
a1[r1]=(short)(a1[r1]+z);}
else if(t==1&&a1[r1]-z>-32000){
a1[r1]=(short)(a1[r1]-z);
}
else{
 a1[r1]=range();
}


 //return ans;
}

  public static double[] argmax(double z[]){
int ans =0;
double s=-1E10;
 
 
 
for(int i=0;i<=z.length-1;i++){

 if(z[i]>s){

 ans=i;
  s=z[i];
}
 z[i]=0;
 
}
//Arrays.fill(z,0); 
z[ans]=1;
return z;

}
   public static double[] softmax(double z[]){

double ans[] = new double[z.length];
double d=0;
for(int i=0;i<=z.length-1;i++){
 d+=Math.exp(z[i]);
}
for(int i=0;i<=z.length-1;i++){
 ans[i]=Math.exp(z[i])/d;
}

return ans;
}
  public static double[] max(double z[]){

double ans[] = new double[z.length];
double d=0;
for(int i=0;i<=z.length-1;i++){
 d+= (z[i]);
}
for(int i=0;i<=z.length-1;i++){
 ans[i]= (z[i])/d;
}

return ans;
}
   public static double active(double x){
 
// double ans=Math.sin(z);
  return (((2*x*x)-(5*x)-40)/((x*x)+x+4));

}
   public static double tanh(double z){
  double ans=0;
  double e1=Math.pow(Math.E,z);
  double e2=Math.pow((Math.E),-z);
  ans=(e1-e2)/(e1+e2);
// double ans=Math.sin(z);
  return ans;

}
   public static double sigmoid(double z){

double ans = 1/(1+(Math.pow(Math.E,-z)));

return ans;
}
   public static double relu(double z){
 return Math.max(z,0);
}
   public static double Leakyrelu(double z){
 return Math.max(z,z*0.02);
}
}
