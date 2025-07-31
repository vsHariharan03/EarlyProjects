import java.util.*;
import java.io.*;
/**
 * Write a description of class gene_algo_2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NG_2 extends Essentials
{ 
public static void main(String args[]) throws Exception{

 int w=217;
  String race[]=new String [30];
  
 // race=race_generator(genes);

  race=race_generator(w);
 String ans=individual(w);
 

//end of making the race 

int iter=0;
int a[]=new int[3];


double gr[]=new double [10];

  int perc=0;
  int perc1=0;
 double stat1=0;
   int c5=(int)Math.random()*29; 

  int gr1;
 double stat2=1E13;
  double gr2=0;
 double stat[]=new double[30];
int c2=0; 
 boolean r32=true;
 
for (iter=0;iter<=1000;iter++){
 
 
  stat=fitness(race);
 
  a = p_find(stat);


if(stat2>stat[a[0]]){
   ans=race[a[0]];
   stat2=stat[a[0]];
}
 

 


System.out.println(iter+"  :   "+((stat[a[0]] )));

 
 if(iter%100==0){
   perc=(int)Math.round(Math.floor((iter)/200));
}

  gr[perc]+=stat1-stat[a[0]];
  stat1=stat[a[0]];
 
  race = nr_generator(race[a[(int)Math.random()*4]],race[a[(int)Math.random()*2]]);
   //System.out.println(ans);
 
 //race[8]=ans;

for(int i=1;i<=30;i++){
c5=(int)Math.random()*30; 
   race[c5]=muto(race[c5]);
}
 


 if(iter%21==0){
 gr2=stat[a[0]];
 gr1=1;
}

if(iter%20==0&&gr2==stat[a[0]]){
   race=race_generator(w);
   System.out.println("commencing reshuffle /-----"+race[a[0]].length()); 
}
/*
   if(iter%30==0){

  //race=nr_generator(race[a[0]],individual(w));
 race=race_generator(w);
  System.out.println("commencing muto /-----"); 
}
  if((Math.floor(Math.random()*100)%47)==0){

  race=nr_generator(race[a[0]],ans);
  
  System.out.println("commencing help /-----"+race[a[0]].length()); 
}
*/

}
 
 System.out.println("ans : "+ans);
 System.out.print("\n");
  int co=0;

for(int w1=0;w1<=(ans.length()/5)-1;w1++){
 
  System.out.println("w["+co+"] = "+((((double)transalate(read(ans,w1)))/1000)-80)+" ; ");

  co++;
}
 co=0;
for(double r : gr){
 
  System.out.println(co+"  = "+r);

  co++;
}
 System.out.println("");
 System.out.println("itereations : ");
 System.out.print(iter);
 System.out.println("fitness : "+stat2); 
  
 
 trial(ans);

}
public static double[] fitness(String w[]) throws Exception {
  double ans=1;
 double ans1[]=new double[30];
   
float y[][]=new float[2][2];
 
  y[0][0]=1;
  y[0][1]=0;
 
 
  y[1][0]=0;
  y[1][1]=1;
 
 
 
 String a="";
 String a1[]=new String[15];
 
 int i=0;
 int r1=0;
    

 
 i=(int)Math.floor((Math.random()*400));
 i++;
 
 
 
  double o[];
     int arc[]={34,5,5,2};
 int f[]=new int[3];
  boolean r32=true;

double acc=0;
int acc1=0;
int acc2=0;
int acc12=0;
int acc22=0;
 
 int s1=1,s2=0;

 for(int ip=0;ip<=29;ip++){
   
       //   BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\vshar\\Datasets\\ionosphere"));  
  
  Scanner in = new Scanner( new File("C:\\Users\\vshar\\Datasets\\ionosphere.data"));//16+1
      in.useDelimiter("\n");
i=(int)Math.random()*13;
 for(int r=1;r<=200;r++){
 
    
//for(int i1=0;i1<=1;i1++)
 a=in.next();    

 
 a1=a.split(",");
 
     double i1[]={

  (Float.parseFloat(a1[0])),//1
  (Float.parseFloat(a1[1])),//1
  (Float.parseFloat(a1[2])),//1
  (Float.parseFloat(a1[3])),//1
  (Float.parseFloat(a1[4])),//1
  (Float.parseFloat(a1[5])),//1
  (Float.parseFloat(a1[6])),//1
  (Float.parseFloat(a1[7])),//1
  (Float.parseFloat(a1[8])),//1
  (Float.parseFloat(a1[9])),//1
  (Float.parseFloat(a1[10])),//1
  (Float.parseFloat(a1[11])),//1
  (Float.parseFloat(a1[12])),//1
  (Float.parseFloat(a1[13])),//1
  (Float.parseFloat(a1[14])),//1
  (Float.parseFloat(a1[15])),//1
  (Float.parseFloat(a1[16])),//1
  (Float.parseFloat(a1[17])),//1
  (Float.parseFloat(a1[18])),//1
  (Float.parseFloat(a1[19])),//1
  (Float.parseFloat(a1[20])),//1
  (Float.parseFloat(a1[21])),//1
  (Float.parseFloat(a1[22])),//1
  (Float.parseFloat(a1[23])),//1
  (Float.parseFloat(a1[24])),//1
  (Float.parseFloat(a1[25])),//1
  (Float.parseFloat(a1[26])),//1
  (Float.parseFloat(a1[27])),//1
  (Float.parseFloat(a1[28])),//1
  (Float.parseFloat(a1[29])),//1
  (Float.parseFloat(a1[30])),//1
  (Float.parseFloat(a1[31])),//1
  (Float.parseFloat(a1[32])),//1
  (Float.parseFloat(a1[33])),//1


};
 
 

 

  o=nnet(arc,i1,w[ip]);
 //o=softmax(o);
// System.out.println(a);
                   
 r1=(a1[34].equals("b"))?0:1;

 o=argmax(o);
 
 

ans+=(Math.abs(y[r1][0]-o[0]))*ans ;
ans+=(Math.abs(y[r1][1]-o[1]))*ans;
 //System.out.println(y[r1][0]+" | "+y[r1][1]+" || "+r1+" || "+r32);
r32=(r32==true)?false:true;

 
 

 
 //System.out.println(y[r1][0]+" | "+y[r1][1]+" || "+r1+" || "+r32);
//r32=(r32==true)?false:true;
 /*
if(Math.abs(y[r1][0]-o[0])==1){
 acc12++;
}
if(Math.abs(y[r1][1]-o[1])==1){
 acc22++;
}
if(Math.abs(y[r1][0]-o[0])==0){
 acc1++;
}
if(Math.abs(y[r1][1]-o[1])==0){
 acc2++;
}
*/
if((Math.abs(y[r1][0]-o[0])==1)){
 s1++;
}
else{
 s2++;
}
//i=(int)Math.random()*10;
 

 
 //ans1[ip]+=ans+((s2==0)?99999990:0);
// ans1[ip]+=ans+((s1==0)?99999990:0);
// ans1[ip]+=100-((((double)(acc1+acc2)/(double)(acc12+acc22+(acc1+acc2))))*100);
// ans1[ip]+=(s1/25)*100;

 
 ans=1;
 
 s2=0;
}
 acc1=0;
 acc2=0;
 acc12=0;
 acc22=0;
//s1=1;
 ans1[ip]=s1;
 s1=0;
 }
//ans=(((Math.abs(o1[0]-o2[0])/o1[0])+(Math.abs(o1[1]-o2[1])/o1[1])+(Math.abs(o1[2]-o2[2])/o1[2])));

 //ans=(o2[0]>=7 )?ans*200:ans;
// ans=(o2[1]>=7 )?ans*200:ans;
 //ans=(o2[2]>=7 )?ans*200:ans;

//ans=Math.log(ans)/Math.log(10);
return ans1;
 
}

 
public static void trial(String w) throws Exception {
 double ans=1;
 double ans1=0;

   
float y[][]=new float[2][2];
 
  y[0][0]=1;
  y[0][1]=0;
 
 
  y[1][0]=0;
  y[1][1]=1;
 
 
 
 String a="";
 String a1[]={"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"};
 int x=0;
 int i=0;
 int r1=0;

  Scanner in = new Scanner( new File("C:\\Users\\vshar\\Datasets\\ionosphere.data"));//16+1
      in.useDelimiter("\n");
 
 double o1[]=new double[3];
 double o2[]=new double[3];
 double o3[]=new double[3];
 Arrays.fill(o1,0);
 Arrays.fill(o2,0);
 double d=0;
 int f[]=new int[3];
 i=0;

double acc=0;
int acc1=0;
int acc2=0;
int acc12=0;
int acc22=0;

 boolean r32=true;
int r=0;
for(int r2=1;r2<=200;r2++){
  in.next();
}

 while(in.hasNext()){
r++;
i=1;
 
 a=in.next();

 
 //i=2/0;
  a=a.replace(" ","");
  a1=a.split(",");
 
//System.out.println("aonx "+a+" "+i); 
// System.out.println(r);
      double i1[]={

  (Float.parseFloat(a1[0])),//1
  (Float.parseFloat(a1[1])),//1
  (Float.parseFloat(a1[2])),//1
  (Float.parseFloat(a1[3])),//1
  (Float.parseFloat(a1[4])),//1
  (Float.parseFloat(a1[5])),//1
  (Float.parseFloat(a1[6])),//1
  (Float.parseFloat(a1[7])),//1
  (Float.parseFloat(a1[8])),//1
  (Float.parseFloat(a1[9])),//1
  (Float.parseFloat(a1[10])),//1
  (Float.parseFloat(a1[11])),//1
  (Float.parseFloat(a1[12])),//1
  (Float.parseFloat(a1[13])),//1
  (Float.parseFloat(a1[14])),//1
  (Float.parseFloat(a1[15])),//1
  (Float.parseFloat(a1[16])),//1
  (Float.parseFloat(a1[17])),//1
  (Float.parseFloat(a1[18])),//1
  (Float.parseFloat(a1[19])),//1
  (Float.parseFloat(a1[20])),//1
  (Float.parseFloat(a1[21])),//1
  (Float.parseFloat(a1[22])),//1
  (Float.parseFloat(a1[23])),//1
  (Float.parseFloat(a1[24])),//1
  (Float.parseFloat(a1[25])),//1
  (Float.parseFloat(a1[26])),//1
  (Float.parseFloat(a1[27])),//1
  (Float.parseFloat(a1[28])),//1
  (Float.parseFloat(a1[29])),//1
  (Float.parseFloat(a1[30])),//1
  (Float.parseFloat(a1[31])),//1
  (Float.parseFloat(a1[32])),//1
  (Float.parseFloat(a1[33])),//1


};
 
 
 
 
 
  int arc[]={34,5,5,2};
 

  double o[]=nnet(arc,i1,w);

 r1=(a1[34].equals("b"))?0:1;
 

ans+=(Math.abs(y[r1][0]-o[0])) ;
ans+=(Math.abs(y[r1][1]-o[1]));
 //System.out.println(y[r1][0]+" | "+y[r1][1]+" || "+r1+" || "+r32);
 


 o3=argmax(o);
 o=softmax(o);
ans+=Math.abs(y[r1][0]-o3[0])*ans;
ans+=Math.abs(y[r1][1]-o3[1])*ans;

if((Math.abs(y[r1][0]-o3[0])==1)&&r1==0){
 acc12++;//false p
}
if((Math.abs(y[r1][0]-o3[0])==0)&&r1==0){
 acc22++;//true p
}
if((Math.abs(y[r1][0]-o3[0])==1)&&r1==1){
 acc1++;// flase n
}
if((Math.abs(y[r1][0]-o3[0])==0)&&r1==1){
 acc2++;// true n
}
//Math.floor((Math.random()*10)+1)%11==0)
 if((Math.floor((Math.random()*20)+1)%11==0)){
 System.out.println(r);
 System.out.println(a1[34]);
 System.out.println(a);
 System.out.println();
 for(double s1 : i1 ){
 System.out.print(s1+" , ");
}
 System.out.println();
 System.out.println(y[r1][0]+" | "+o3[0]+" | "+o[0]+" || "+Math.abs(y[r1][0]-o3[0]));
 System.out.println(y[r1][1]+" | "+o3[1]+" | "+o[1]+" || "+Math.abs(y[r1][1]-o3[1]));
 }
 if(r%20==0){
 ans=1;
 ans1+=Math.log(ans)/Math.log(10);
}

}
System.out.println(acc1);//FN
System.out.println(acc2);//TN
System.out.println(acc12);//FP
System.out.println(acc22);//TP
 
System.out.println("Accuracy report : ");
//System.out.println("Accuracy of predicting democrat : "+((double)acc1/(double)(acc12+acc1))*100);
//System.out.println("Accuracy of predicting republic : "+((double)acc2/(double)(acc22+acc2))*100);
System.out.println("Total Acuraccy : "+(((double)(acc2+acc22)/(double)(acc12+acc22+(acc1+acc2))))*100);
 System.out.println("Total Presision : "+(((double)(acc22)/(double)(acc22+(acc1))))*100);
 
}
}

