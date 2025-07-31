 import java.util.*;
/**
 * Write a description of class Essentials here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Essentials
{
   public static double[] nnet(int b[],double in[],String w){
     
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
  public static double[] layer( int a,int b,double a1[] ,String w,int r,int r1){

 //double layer1[]=new double[a];
 double layer2[]=new double[b]; 
  int c=r; 
  int c1=r1;
for(int i1=0;i1<b;i1++){
  for(int i=0;i<a;i++){
  layer2[i1]+=(((((double)transalate(read(w,c)))/1000)-80)*2*a1[i]); // 1 nueron
// System.out.println((transalate(read(w,c))));
// layer2[i1]= ( layer2[i1]);
 c++;
}

 layer2[i1]+=((((double)transalate(read(w,((w.length()/4)-c1-1))))/1000)-80)*2;
 //System.out.println(transalate(read(w,((w.length()/4)-c1-1))));
 layer2[i1]=sigmoid(layer2[i1]);
 //layer2=softmax(layer2);
 c1++;
//System.out.println(i1+" : "+o[i1]);
}

 return (layer2);
}
   public static double[] nnet1(int b[],double in[],String w){
     
         double hid[];
 
 // double b1[]=new double[5];
   hid=in;
 
int c=0;//a[0]*a[1];
int c1=0;
  for(int i=0;i<b.length-1;i++){
   hid=layer1(b[i],b[i+1],hid,w,c,c1);  
//   System.out.println("iob - "+i+" a - "+b[i]);
   c+=(b[i]*b[i+1]);
   c1+=b[i+1];
}
  
        //h[m]=(i[0]*w[0+(m*9)])+(i[1]*w[1+(m*9)])+(i[2]*w[2+(m*9)]);
  return hid;
} 
  public static double[] layer1( int a,int b,double a1[] ,String w,int r,int r1){

 //double layer1[]=new double[a];
 double layer2[]=new double[b]; 
  int c=r; 
  int c1=r1;
for(int i1=0;i1<b;i1++){
  for(int i=0;i<a;i++){
  layer2[i1]+=(((((double)transalate(read(w,c)))/1000)-80)*2*a1[i]); // 1 nueron
// System.out.println((transalate(read(w,c))));
// layer2[i1]= ( layer2[i1]);
 c++;
}

 layer2[i1]+=((((double)transalate(read(w,((w.length()/4)-c1-1))))/1000)-80)*2;
 //System.out.println(transalate(read(w,((w.length()/4)-c1-1))));
 layer2[i1]=sigmoid(layer2[i1]);
 //layer2=softmax(layer2);
 c1++;
//System.out.println(i1+" : "+o[i1]);
}

 return (layer2);
}
public static int[] p_find(double a[]){
int ans[] = new int[6];
 
double a1[]=new double[a.length];
for(int i=0;i<=a.length-1;i++){
 a1[i]=a[i];
}
Arrays.sort(a1);

double r1=a1[0];
double r2=a1[1];
double r3=a1[2];
double r4=a1[3];
double r5=a1[4];
double r6=a1[5];


 

for(int i=0;i<=a.length-1;i++){
 if(a[i]==r1 ){  ans[0]=i; }
 if(a[i]==r2 ){  ans[1]=i; }
 if(a[i]==r3 ){  ans[2]=i; }
 if(a[i]==r4 ){  ans[3]=i; }
 if(a[i]==r5 ){  ans[4]=i; }
 if(a[i]==r6 ){  ans[5]=i; }
}

return ans;
}

public static String muto (String a){
 String ans="";

  int x=(int)Math.floor(Math.random()*a.length());//pos
 
int min=1;
int max=5;

int r=(int)(((Math.random()*(max-min))+min));//char
int b1=a.length()-(r+1);
int b2=0;
  x=(int)(Math.random()*(b1-b2)+b2);//pos
 // String s3 = new StringBuilder(s1).append(s2).toString();
 ans =  a.substring(0,x);
  for(int j=1;j<=r;j++)
  ans+= transalate((int)(((Math.random()*(max-min))+min)));
 ans =new StringBuilder(ans).append(a.substring(x+r)).toString();
/*
 if(r>9)
 ans = new StringBuilder(a.substring(0,x)+((((char)((r+97)-10) )))).append(a.substring(x+1)).toString();
else {
 ans = new StringBuilder(a.substring(0,x)+((""+((int)(((Math.random()*(max-min))+min)))) )).append(a.substring(x+1)).toString();

}
 */
 
 return ans;

}
  public static double[] argmax(double z[]){
int ans =0;
double a1[]=new double[z.length]; 
 for(int i=0;i<=z.length-1;i++)
 a1[i]=z[i];
Arrays.sort(a1);
double r1=a1[a1.length-1];
 
for(int i=0;i<=z.length-1;i++){
 if(z[i]==r1){
 ans=i;
 break;
}
 
}
Arrays.fill(z,0); 
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
  double ans=0;
  double e1=Math.pow(Math.E,z);
  double e2=Math.pow((Math.E),-z);
  ans=(e1-e2)/(e1+e2);
// double ans=Math.sin(z);
  return ans;

}
   public static double sigmoid(double z){

return   1/(1+(Math.pow(Math.E,-z)));
}
   public static double relu(double z){
 return Math.max(z,0);
}
   public static double Leakyrelu(double z){
 return Math.max(z,z*0.05);
}
public static String read(String a1,int a){
int i=1;
 a=((a)*4);
return(a1.charAt(a)+""+a1.charAt(a+1)+""+a1.charAt(a+2)+""+a1.charAt(a+3));
}
public static String transalate(int a){
String a1="";

int base=20;
do{
  if(a%base>9)
  a1=((char)((a%base)+65-10))+a1;
else
  a1=(Integer.toString((a%base)))+a1;
  a=a/base;
}
while(a>0);

 
 return a1;
}
public static int transalate(String a){

 return Integer.parseInt(a,20);
}
public static String individual(int w){
 String ans ="";
int min=0;
int max=20;
for(int i1=0;i1<=w-1;i1++){
   for(int j=1;j<=4;j++)
  ans+= transalate((int)(((Math.random()*(max-min))+min)));

 }
 return ans;
}
public static String[] race_generator(int w){
//10 parents
 
String ans[]= new String[30];
 int min=0;
int max=19;
 for(int i=0;i<=29;i++){
 ans[i]="";
for(int i1=0;i1<=w-1;i1++){

   for(int j=1;j<=4;j++)
  ans[i]=ans[i]+(transalate((int)(((Math.random()*(max-min))+min))));


 }

//System.out.println(per+"pr");

}
return ans;
}

public static String[] nr_generator(String a11,String a21){
 
String ans[]= new String[30];
   
int p=(int)((a11.length())/(5));//6-3
int p1=(int)Math.floor(Math.random()*p);//1
int p2=(int)Math.floor(Math.random()*p);//4(3+1)
int p3=(int)Math.floor(Math.random()*p);//1
int p4=(int)Math.floor(Math.random()*p);//4(3+1)
int p5=(int)Math.floor(Math.random()*p);//1
 
 // String s3 = new StringBuilder(s1).append(s2).toString();

 for(int i=0;i<=29;i++){

 

  p1=(int)Math.floor(Math.random()*p);//1
   p2=(int)Math.floor(Math.random()*p);//4(3+1)
 p3=(int)Math.floor(Math.random()*p);//1
   p4=(int)Math.floor(Math.random()*p);//4(3+1)
   p5=(int)Math.floor(Math.random()*p);//1
 
 
  ans[i]= new StringBuilder((a21.substring(0,p1))).append((a11.substring(p1,p2+p1))).toString();
 ans[i]+= new StringBuilder((a21.substring(p2+p1,p2+p1+p3))).append((a11.substring(p2+p1+p3,p2+p1+p3+p4))).toString();
 ans[i]+= new StringBuilder((a21.substring(p2+p1+p3+p4,p2+p1+p3+p4+p5))).append((a11.substring(p2+p1+p3+p4+p5))).toString();
/*
 ans[i]="";
 for(int i3=0;i3<=a11.length()-1;i3++){
 if(p1%2==0)
 ans[i]=ans[i].concat(a21.charAt(i3)+"");
 else
   ans[i]=ans[i].concat(a11.charAt(i3)+"");
}
/*
 ans[i]="";
 for(int i3=0;i3<=p1;i3++){
 ans[i]=ans[i].concat(a11.charAt(i3)+"");
}
for(int i3=p1+1;i3<=p1+p2;i3++){
 ans[i]=ans[i].concat(a21.charAt(i3)+"");
}
 for(int i3=p1+p2+1;i3<=p1+p2+p3;i3++){
 ans[i]=ans[i].concat(a11.charAt(i3)+"");
}
for(int i3=p1+p2+p3+1;i3<=p1+p2+p3+p4;i3++){
 ans[i]=ans[i].concat(a21.charAt(i3)+"");
}
for(int i3=p1+p2+p3+p4+1;i3<=p1+p2+p3+p4+p5;i3++){
 ans[i]=ans[i].concat(a11.charAt(i3)+"");
}
for(int i3=p1+p2+p3+p4+p5+1;i3<=a11.length()-1;i3++){
 ans[i]=ans[i].concat(a21.charAt(i3)+"");
}
 //System.out.println(ans[i].length()+"  |  "+a11.length()+"  |  "+a21.length());
/*
ans[i]= ((a21.substring(0,p1))).concat((a11.substring(p1,p2+p1))) ;
 ans[i]+=  ((a21.substring(p2+p1,p2+p1+p3))).concat((a11.substring(p2+p1+p3,p2+p1+p3+p4))) ;
 ans[i]+=  ((a21.substring(p2+p1+p3+p4,p2+p1+p3+p4+p5))).concat((a11.substring(p2+p1+p3+p4+p5))) ;
*/
//ans[i]= new StringBuilder(ans[i]).append((a21.substring(p5))).toString();
  ans[i]=muto(ans[i]);
}
 
 for(int i=15;i<=29;i++){

 

  p1=(int)Math.floor(Math.random()*p);//1
  p2=(int)Math.floor(Math.random()*p);//4(3+1)
   p3=(int)Math.floor(Math.random()*p);//1
  p4=(int)Math.floor(Math.random()*p);//4(3+1)
  p5=(int)Math.floor(Math.random()*p);//1
 
 
  ans[i]= new StringBuilder((a11.substring(0,p1))).append((a21.substring(p1,p2+p1))).toString();
 ans[i]+= new StringBuilder((a11.substring(p2+p1,p2+p1+p3))).append((a21.substring(p2+p1+p3,p2+p1+p3+p4))).toString();
 ans[i]+= new StringBuilder((a11.substring(p2+p1+p3+p4,p2+p1+p3+p4+p5))).append((a21.substring(p2+p1+p3+p4+p5))).toString();

/*
 ans[i]="";
 for(int i3=0;i3<=p1;i3++){
 ans[i]=ans[i].concat(a21.charAt(i3)+"");
}
for(int i3=p1+1;i3<=p1+p2;i3++){
 ans[i]=ans[i].concat(a11.charAt(i3)+"");
}
 for(int i3=p1+p2+1;i3<=p1+p2+p3;i3++){
 ans[i]=ans[i].concat(a21.charAt(i3)+"");
}
for(int i3=p1+p2+p3+1;i3<=p1+p2+p3+p4;i3++){
 ans[i]=ans[i].concat(a11.charAt(i3)+"");
}
for(int i3=p1+p2+p3+p4+1;i3<=p1+p2+p3+p4+p5;i3++){
 ans[i]=ans[i].concat(a21.charAt(i3)+"");
}
for(int i3=p1+p2+p3+p4+p5+1;i3<=a11.length()-1;i3++){
 ans[i]=ans[i].concat(a11.charAt(i3)+"");
}
 //System.out.println(ans[i].length()+"  |  "+a11.length()+"  |  "+a21.length());
/*
ans[i]= ((a21.substring(0,p1))).concat((a11.substring(p1,p2+p1))) ;
 ans[i]+=  ((a21.substring(p2+p1,p2+p1+p3))).concat((a11.substring(p2+p1+p3,p2+p1+p3+p4))) ;
 ans[i]+=  ((a21.substring(p2+p1+p3+p4,p2+p1+p3+p4+p5))).concat((a11.substring(p2+p1+p3+p4+p5))) ;
*/
//ans[i]= new StringBuilder(ans[i]).append((a21.substring(p5))).toString();
  ans[i]=muto(ans[i]);
}
 

return ans;
}

}
