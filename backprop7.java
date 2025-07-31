import java.util.*;
import java.io.*;
import java.nio.file.*;
public class backprop7
{

//2-4-2

final static int arc[]={784,16,18,10};

static  double node[]=new double[ arc[1]+arc[2]+arc[3] ];

public static void main(String args[]) throws Exception{

int wlen=0;
for(int i=0;i<arc.length-1;i++){
 wlen+=(arc[i]*arc[i+1]);
 wlen+=arc[i+1];
}
System.out.println(wlen);
 double wts []=new double[wlen];
 double wts1[]=new double[wlen];
  for(int i=0;i<wlen;i++){
 wts[i]=(Math.random()-0.5);
}

 int cls=10;
int attr=arc[0];
int dtlen=60000;

 double ans[]=new double[cls];
 double ans1[]=new double[cls];
 
double wm1[]=new double[wts.length];
double wm[]=new double[wts.length];

int k=0;

//mnist_corrected is 28 x 28
//mnist_corrected is 14x 14
String data=("C:\\Users\\vshar\\Datasets\\mnist_corrected");
BufferedReader in=new BufferedReader(new FileReader(data));


String a="";
String a1[];
  double i1[]=new double[attr];


int d=0;
int stat=0;
int ac=0;
int r1=0;

boolean fin=false;
 in.close();
 in=new BufferedReader(new FileReader(data));


 Scanner sc= new Scanner(System.in);
dtlen=60000;
ac=0;
r1=0;
Arrays.fill(ans,0);

while(true){
// a=in.readLine();
if(ac==dtlen){
 break;
}
ac++;

//System.out.println("aonx "+a+" "+i);   


   r1=input(in,i1);
  nnet1(arc,i1,wts);
// Arrays.fill(ans,0); replacing eith  ans[r1]=0;
 ans[r1]=1;
//if(Math.random()<0.5){ muto(wts); continue;}

 wm= backpropagation(ans,wts,i1);
 for(int s=0;s<wts.length;s++){
 wm1[s]+=wm[s];
}
d++;
if(d==50){
 for(int s=0;s<wts.length;s++){
 wts[s]=wm1[s]/50;
wm1[s]=0;
}
d=0;
}

//muto(wts);
 ans[r1]=0;


}

Arrays.fill(ans,0);

int ch=0;
d=0;
 int  acc1=0;
 int  acc2=0;
for(int i=1;i<=50;i++){
//
  in.close();
 in=new BufferedReader(new FileReader(data));


dtlen=60000;
ac=0;
r1=0;
acc1=0;
acc2=0;
while(true){

if(ac==dtlen){
 break;
}
ac++;

   r1=input(in,i1);
 ch=argmax1( nnet1(arc,i1,wts) );
// nnet1(arc,i1,wts) ;
// Arrays.fill(ans,0); replacing eith  ans[r1]=0;
 ans[r1]=1;
// wts= backpropagation(ans,wts,i1);

 wm= backpropagation(ans,wts,i1);
 for(int s=0;s<wts.length;s++){
 wm1[s]+=wm[s];
}
d++;
if(d==10){
 for(int s=0;s<wts.length;s++){
 wts[s]=wm1[s]/10;
wm1[s]=0;
}
d=0;
}

 ans[r1]=0;

if(ch==r1){
 acc2++;
}
else{
 acc1++;
}

}

System.out.println(((double)acc2)/600+" : ");



dtlen=10000;
ac=0;
r1=0;
acc1=0;
acc2=0;
while(true){

if(ac==dtlen){
 break;
}
ac++;

   r1=input(in,i1);
 ch=argmax1( nnet1(arc,i1,wts) );

if(ch==r1){
 acc2++;
}
else{
 acc1++;
}

}

System.out.println(((double)acc2));
 
 

if(stat<acc2){
 for(int s=0;s<wts.length;s++){
 wts1[s]=wts[s];
}
stat=acc2;
}
System.out.println(i);
}

ac=0;
dtlen=60000;
  in.close();
 in=new BufferedReader(new FileReader(data));
// in.readLine();
while(true){

if(ac==dtlen){
 break;
}
ac++;
}
ac=0;
acc1=0;
acc2=0;

dtlen=10000;
ac=0;
while(true){
// a=in.readLine();

if(ac==dtlen){
 break;
}
ac++;
 r1=input(in,i1);
//System.out.println("aonx "+a+" "+i);   

ch=argmax1( nnet1(arc,i1,wts));
ans1[ch]+=1;
if(ch==r1){
 acc2++;
}
else{
 acc1++;
ans[ch]+=1;
}

}
d=0;

for(int j=0;j<10;j++){
int an=(int)(ans[j]*100/ans1[j]);
 System.out.print(an+" : ");
 ans[j]=0;
 ans1[j]=0;
if(an<10){
 d++;
}
}
 System.out.print(acc2);
System.out.println("Want to save this ?(y/n)");
char c=sc.next().charAt(0);
if(c=='y'){
String st="";
//mnist_best is 28 x 28
//mnist_best1 is reshaped ,resized 28 x 28
//mnist_best2 is reshaped ,resized 14 x 14
BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\vshar\\Datasets\\mnist_best2"));
int cn=0;
while(cn!=wts.length){
 for(int j=1;j<=100;j++){
 st=st + (Float.toString((float)wts1[cn])+"," ) ;
 cn++;
 if(cn==wts.length){
 break;
}
}
bw.write(st);
bw.newLine();
st="";
}

bw.close();
}
////----------------------///
 



}


  public static double[] backpropagation(double tar[],double w[],double inp1[] ){
 double wm[]=new double[w.length];
  for(int i=0;i<w.length;i++){
wm[i]=w[i];
}
//err input is just 
//if (target-output)it is wm+=..;
//if (output-target)it is wm-=..;
//double err[]=new double[2];
//Math.signum(tar[1]-out[1])*(tar[1]-out[1])*
int c1=w.length-arc[1]-arc[2]-arc[3]-1;
int len=node.length;
double lr=0.1;
 double err[]=new double[arc[3]];
 int arcs=0;
//    err[i]=Math.signum(tar[i]-out[i])*(tar[i]-out[i])*(tar[i]-out[i])*deriv(out[i]);
//c1+=arc[2];
c1+=arc[3];
len-=arc[3];

  for(int i=0;i<arc[3];i++){
//err[i]=  (tar[i]-node[len+i])*deriv(node[len+i]);
//err[i]=  (( (tar[i]-node[len+i])>0 )?1:-1)*(tar[i]-node[len+i])*(tar[i]-node[len+i])*deriv(node[len+i]);
//err[i]=  (tar[i]-node[len+i])*(tar[i]-node[len+i])*deriv(node[len+i]);
err[i]=  (tar[i]-node[len+i])*(tar[i]-node[len+i])*(tar[i]-node[len+i])*deriv(node[len+i]);
   //System.out.println("err["+i+"]=tar["+i+"]-out["+i+"]*deriv(out["+i+"]);");
     wm[(c1-i)]+=err[i]*lr;
  // System.out.println("w["+(c1-i)+"]= err["+i+"]*lr;");

}


double err2[]=new double[arc[1+1]];

//c1+=arc[1+1];
c1+=arc[1+1];
len-=arc[1+1];
arcs=(arc[1]*arc[0])+(arc[1+1]*arc[1+0]);
for(int i=0;i<arc[1+1];i++){
for(int j=0;j<arc[1+2];j++){
 wm[ arcs+(arc[1+1]*j)+i]+=( err[j]* lr * (node[len+i]) );
err2[i]+=w[arcs+(arc[1+1]*j)+i ]*err[j]*deriv(node[len+i]);
//System.out.println("err1["+i+"]+=w["+( (arc[1+1]*arc[1+0])+(arc[1+1]*j)+i  )+"]*err["+j+"]*deriv(node1_1["+i+"]);");
}
//System.out.println("w["+( c1-i )+"]+=err1["+i+"]*lr , "+(wm[ c1-i ])+" , "+(err1[i]));//
//System.out.println("w["+(c1)+"]+=err1["+i+"]*lr , "+(wm[c1])+" , "+(err1[i]));//
 wm[ c1-i]+=err2[i]*lr;

}
//error = (weight_k * error_j) * transfer_derivative(output)
/*
for(int i=0;i<arc[1];i++){
 for(int j=0;j<arc[2];j++){
 wm[ (arc[1]*arc[0])+(arc[2]*j)+i]+=( err[j]* lr * (node1_1[i]) );

//   System.out.println("wm["+( (arc[1]*arc[0])+(arc[1]*j)+i )+"]+=err["+j+"]*lr*(node1_1["+i+"]);");
}
}
*/
double err1[]=new double[arc[1]];

//c1+=arc[1];
c1+=arc[1];
len-=arc[1];
arcs=(arc[1]*arc[0]);
for(int i=0;i<arc[1];i++){
for(int j=0;j<arc[2];j++){
 wm[ arcs+(arc[1]*j)+i]+=( err2[j]* lr * (node[len+i]) );
err1[i]+=w[ arcs+(arc[1]*j)+i ]*err2[j]*deriv(node[len+i]);
//System.out.println("err1["+i+"]+=w["+( (arc[1]*arc[0])+(arc[1]*j)+i  )+"]*err["+j+"]*deriv(node1_1["+i+"]);");
}
//System.out.println("w["+( c1-i )+"]+=err1["+i+"]*lr , "+(wm[ c1-i ])+" , "+(err1[i]));//
//System.out.println("w["+(c1)+"]+=err1["+i+"]*lr , "+(wm[c1])+" , "+(err1[i]));//
 wm[ c1-i]+=err1[i]*lr;

}

for(int i=0;i<arc[0];i++){
 for(int j=0;j<arc[1];j++){
 wm[ (arc[0]*j)+i ]+=( err1[j]* lr * (inp1[i]) );
//   System.out.println("wm["+( +(arc[0]*j)+i )+"]+=err["+j+"]*lr*(imp1["+i+"]);");
}
}

return wm;

} 

   public static double[] backpropagation1(double tar[],double w[],double inp1[] ){
 double wm[]=new double[w.length];

  for(int i=0;i<w.length;i++){
wm[i]=w[i];
}
//err input is just 
//if (target-output)it is wm+=..;
//if (output-target)it is wm-=..;
//double err[]=new double[2];
//Math.signum(tar[1]-out[1])*(tar[1]-out[1])*
//int c1=w.length-arc[1]-arc[2]-arc[3]-1;
int c1=w.length-1;
 int arcs=0;
arcs=0;
for(int i=1;i<arc.length;i++){
 c1-=arc[i];
arcs+=(arc[i-1]*arc[i]);
}
int len=node.length;
double lr=0.1;
 double err[]=new double[arc[arc.length-1]];

//    err[i]=Math.signum(tar[i]-out[i])*(tar[i]-out[i])*(tar[i]-out[i])*deriv(out[i]);
//c1+=arc[2];
c1+=arc[arc[arc.length-1]];
len-=arc[arc[arc.length-1]];

  for(int i=0;i<arc[arc.length-1];i++){
//err[i]=  (tar[i]-node[len+i])*deriv(node[len+i]);
err[i]=  (( (tar[i]-node[len+i])>0 )?1:-1)*(tar[i]-node[len+i])*(tar[i]-node[len+i])*deriv(node[len+i]);
//err[i]=  (tar[i]-node[len+i])*(tar[i]-node[len+i])*(tar[i]-node[len+i])*deriv(node[len+i]);
   //System.out.println("err["+i+"]=tar["+i+"]-out["+i+"]*deriv(out["+i+"]);");
     wm[(c1-i)]+=err[i]*lr;
  // System.out.println("w["+(c1-i)+"]= err["+i+"]*lr;");

}


double err2[];
for(int i=arc.length-2;i>1;i--){
c1+=arc[i];
len-=arc[i];
arcs-=arc[i]*arc[i+1];
//public static void back (int err1[],double err2[],double wm[],double w[],int len,int arcs,double lr,int c1){
err=back(new double[arc[i]],err,wm,w,len,arcs,lr,c1);
}



for(int i=0;i<arc[0];i++){
 for(int j=0;j<arc[1];j++){
 wm[ (arc[0]*j)+i ]+=( err[j]* lr * (inp1[i]) );
//   System.out.println("wm["+( +(arc[0]*j)+i )+"]+=err["+j+"]*lr*(imp1["+i+"]);");
}
}

return wm;

} 
public static double[] back (double err1[],double err2[],double wm[],double w[],int len,int arcs,double lr,int c1){
for(int i=0;i<err1.length;i++){
if((Math.random()<0.5)){continue;}
for(int j=0;j<err2.length;j++){
 wm[ arcs+(err1.length*j)+i]+=( err2[j]* lr * (node[len+i]) );
err1[i]+=w[ arcs+(err1.length*j)+i ]*err2[j]*deriv(node[len+i]);
//System.out.println("err1["+i+"]+=w["+( (arc[1]*arc[0])+(arc[1]*j)+i  )+"]*err["+j+"]*deriv(node1_1["+i+"]);");
}
//System.out.println("w["+( c1-i )+"]+=err1["+i+"]*lr , "+(wm[ c1-i ])+" , "+(err1[i]));//
//System.out.println("w["+(c1)+"]+=err1["+i+"]*lr , "+(wm[c1])+" , "+(err1[i]));//
 wm[ c1-i]+=err1[i]*lr;

}
return err1;
}

public static double[] nnet1 (int b[],double in[],double w[]){
     
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
 layer2[i1]= tanh(layer2[i1]); 
 c1++; 
}

 return (layer2);
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
public static double deriv(double a){
return 1-(a*a); //tanh
//return a*(1-a); //sigmoid
// return (a<0)?0:1;
}
public static int input(BufferedReader in,double[] i2) throws Exception {
String a="";
String a1[];
//double k=2;
a=in.readLine();   
 a1=a.split(","); 
//int k=0;
 //int r=Integer.parseInt(a1[a1.length-1]);


  for(int i=0;i<i2.length;i++){

 i2[i]=((Integer.parseInt(a1[i]))/100);
//k++;

}
// norm(i2);
   return Integer.parseInt(a1[a1.length-1]);

}
public static int input1(BufferedReader in,double[] i2) throws Exception {
String a="";
String a1[];
//double k=2;
a=in.readLine();   
 a1=a.split(","); 
//int k=0;
 //int r=Integer.parseInt(a1[a1.length-1]);


  for(int i=0;i<i2.length;i++){

 i2[i]=((Integer.parseInt(a1[i]))/200);
//k++;

}
// norm(i2);
   return Integer.parseInt(a1[a1.length-1]);

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
public static void muto(double a1[]){

 int r1=(int)(Math.random()*(a1.length));


a1[r1]=a1[r1]*((Math.random()-0.5)*2*0.005);




 
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
   public static double hard_sigmoid(double z){

//double ans = 1/(1+(Math.pow(Math.E,-z)));

return Math.max( 0, Math.min( 1,(z+2.718)/5.436  )  );
}
   public static double relu(double z){
 return Math.max(z,0);
}
   public static double Leakyrelu(double z){
 return Math.max(0,z*1.8);
}
}
