
import java.util.*;
import java.io.*;
/**
 * Write a description of class gene_algo_2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tic_toe1 extends Essentials2
{ 
public static void main(String args[]) throws Exception{
 //26 alphabets
 
 
 // genes = genes_t.split("");





 
//range = 9 & 0

  //genes[26]=" ";
  //double tar[]={1.0,4.0,2.0,4.0,2.0,4.0,1,4,2,4,2.0,3,1,4,2,4,2,3,1,4,2,4,2,2};
  //System.out.println(tar.length);
//          FGQGULETECTI
//making player1

 int w=143;
  short player1[][]=new short[30][w];

  
 // player1=player1_generator(genes);

  race_generator(player1);



 short ans1[]=new short[w];


 short player11[]=new short[w];
 player11=player1[3];




//end of making the player1 
int lstat1=9;
int iter=0;
int a[]=new int[5];
int b[]=new int[8];
int m[]=new int[15];

//w[24] = 8.901203000080471 ; 
//player1[1]=w;
double gr[]=new double [11];
   int r1;
    int r2;
  int perc;
  int perc1=0;
 double stat11=0;
  int c5=(int)Math.random()*30; 



 double stat_1=1E10;


  double gr2=0;
  double gr1=0;

 boolean ch=true;
 boolean win=false;
 double stat1[]=new double[30];

int c2=0;
int y1=0;

   double stat12=1E10;
//-1 for player 1
//1 for player 2
   for(int ip=0 ;ip<=player1.length-1;ip++){ 
   stat1[ip]=(-fitness(player1[ip] , ans1)+fitness(ans1,player1[ip] ))/2;
 }
  a = p_find(stat1,a.length);
  b = k_find(stat1,b.length);
 

while(true){
 iter++;
 


  for(int ip=0 ;ip<=b.length-1;ip++){ 
   stat1[b[ip]]=(-fitness(player1[b[ip]] , ans1)+fitness(ans1,player1[b[ip]] ))/2;
 }
  for(int ip=0 ;ip<=m.length-1;ip++){ 
  stat1[m[ip]]=(-fitness(player1[m[ip]] , ans1)+fitness( ans1,player1[m[ip]] ))/2;
 }
  a = p_find(stat1,a.length);
  b = k_find(stat1,b.length);

 if(stat1[a[0]]==1){

    for(int y=0;y<=w-1;y++){
     ans1[y]=player1[a[0]][y];
}


stat12=stat1[a[0]];
  //race_generator(player1);
//break;


}

   nr_generator(a ,b ,player1);
c2=0;
for(int i=0;i<=m.length-1;i++){
c2=(int)(Math.random()*(player1.length-1));
 m[i]=c2;
 player1[c2][(int)Math.random()*(w)]=range();
}
 c2=0;
 







 
   //Arrays.fill(stat1,0); 
/*
 if((Math.ceil(Math.random()*iter))%(Math.ceil(Math.random()*iter/2))==0){
System.out.print(".");
if(iter%2==0){
  race_generator(player1);
   for(int ip=0 ;ip<=player1.length-1;ip++){ 
   stat1[ip]=fitness(player1[ip] , ans2);
 }
  a = p_find(stat1,a.length);
  b = k_find(stat1,b.length);



}
if(iter%2==0){
  race_generator(player2);
   for(int ip=0 ;ip<=player2.length-1;ip++){ 
   stat2[ip]=-(fitness(player1[ip] , ans2));
 }
  a1 = p_find(stat2,a1.length);
  b1 = k_find(stat2,b1.length);


}

}
*/
// System.out.println(stat12+" | "+ch);
 if(iter==20000){
 break;
}




}
 //ans=player1[a[0]];
 System.out.println("ans : ");
 System.out.print("\n");
  int co=0;

 System.out.println("----------------");
co=0;
/*
for(double r : ans1){
 
  System.out.println("w["+co+"] = "+r*0.004+" ; ");

  co++;
}
 co=0;
for(double r : gr){
 
  System.out.println(co+"  = "+r);

  co++;
}
*/
 System.out.println("");
 System.out.println("itereations : ");
 System.out.print(iter);
 System.out.println("fitness : "+stat12); 
  Scanner in1 = new Scanner (System.in );
   boolean aop=false;

 trial(ans1,player1[a[0]]);
 trial(player1[a[0]],ans1);
// trial(player2[a1[0]],player1[a[0]]);

System.out.println("Would you like to play with player1 ? y/n ");
 if(in1.nextLine().equals("y")){
 while(aop==false){
 trial_1(ans1);
 System.out.println("Want more ? y/n");
 if(in1.nextLine().equals("n")){
 break;
}
}
}

System.out.println("Would you like to play with player1 ? y/n ");
 if(in1.nextLine().equals("y")){
 while(aop==false){
 trial_2(ans1);
 System.out.println("Want more ? y/n");
 if(in1.nextLine().equals("n")){
 break;
}
}
}





}
public static double fitness(short w[],short w1[] ){
  // double w[]=new double [134];

    double val[]=new double[9];
     Scanner in = new Scanner(System.in);
   Arrays.fill(val,0);
 //       val[4]=0;
//    board(val);

   double i[]=new double[9];
   double j[]=new double[9];

   double o[]=new double[9];
  
   boolean av_spt[]=new boolean[9];
  Arrays.fill(av_spt,true);


// Arrays.fill(w,Math.random());
 
  double fitness=0;
 int m=0;
 int turns=0;
  double a1[]=new double[o.length];
double r1;
int ans=9;
 int ch1=0;

 int cont=0;
 int arc[]={9,5,5,9};
//lower ans means better fitness score 
//win -1 : lose 1 : tie 0.5
while(true){
//turns++;
for(int i1=0;i1<=i.length-1;i1++){
 i[i1]=val[i1];
 j[i1]=-val[i1];
}
    //i=val;
//nnet(arc,i1,w)
o=nnet(arc,i,w);


for(int i1=0;i1<=o.length-1;i1++){
 a1[i1]=o[i1];
}
Arrays.sort(a1);

ch1=0;
for(int ip=1;ip<=9;ip++){
r1=a1[a1.length-ip];
for(int i1=0;i1<=a1.length-1;i1++){

 if(o[i1]==r1&&av_spt[i1]==true){
 ans=i1;
 ch1=1;
 }
}
 if(ch1==1){
 break;
}
}
ch1=0;
val[ans]=1;
 av_spt[ans]=false;
    m=check(val);

 // board(val);
  if(m==1){
  //  System.out.println(" Computer wins !!!");
    fitness=1;
   break;
 }
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
  fitness=0.0;
 break;
}
cont=0;

 
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
     if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   fitness=-1;
   break;
}    
 if(m==1){
    // board(val);
  // System.out.println(" Computer wins !!!");
   fitness=1;
   break;
}
 if(cont==9){
 // System.out.println(" Tie !!!");
  fitness=0.0;
 break;
}
cont=0;
for(int i1=0;i1<=i.length-1;i1++){
 i[i1]=val[i1];
 j[i1]=-val[i1];
}
    //i=val;
//nnet(arc,i1,w)
o=nnet(arc,j,w1);


for(int i1=0;i1<=o.length-1;i1++){
 a1[i1]=o[i1];
}
Arrays.sort(a1);

ch1=0;
for(int ip=1;ip<=9;ip++){
r1=a1[a1.length-ip];
for(int i1=0;i1<=a1.length-1;i1++){

 if(o[i1]==r1&&av_spt[i1]==true){
 ans=i1;
 ch1=1;
 break;
 }
}
 if(ch1==1){
 break;
}
}
ch1=0;
val[ans]=-1;
 av_spt[ans]=false;
    m=check(val);

      if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   fitness=-1;
   break;
}

for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
  fitness=0.0;
 break;
}
cont=0;


}

// if((Math.random()*100)%50==0)
  // board(val);
 // System.out.println(fitness);
 return  -((fitness));

 }
public static void trial(short w[],short w1[]){
  // double w[]=new double [134];

// Scanner in = new Scanner (System.in);

    double val[]=new double[9];
     Scanner in = new Scanner(System.in);
   Arrays.fill(val,0);
 //       val[4]=0;
//    board(val);

   double i[]=new double[9];
   double j[]=new double[9];

   double o[]=new double[9];
  
   boolean av_spt[]=new boolean[9];
  Arrays.fill(av_spt,true);

   int user;
// Arrays.fill(w,Math.random());
 
  double fitness=0;
 int m=0;
 int turns=0;
  double a1[]=new double[o.length];
double r1;
int ans=9;
 int ch1=0;
  int prev=0;
 int cont=0;
 int arc[]={9,5,5,9};
while(true){

for(int i1=0;i1<=i.length-1;i1++){
 i[i1]=val[i1];
 j[i1]=-val[i1];
}
    //i=val;
//nnet(arc,i1,w)
o=nnet(arc,i,w);


for(int i1=0;i1<=o.length-1;i1++){
 a1[i1]=o[i1];
}
Arrays.sort(a1);


for(int ip=1;ip<=9;ip++){
r1=a1[a1.length-ip];
for(int i1=0;i1<=a1.length-1;i1++){

 if(o[i1]==r1&&av_spt[i1]==true){
 ans=i1;
 ch1=1;
 break;
}
}
 if(ch1==1){
 break;
}
}
ch1=0;
val[ans]=1;
 av_spt[ans]=false;
    m=check(val);

 // board(val);
  if(m==1){
  //  System.out.println(" Computer wins !!!");\ 
   board(val);
    fitness=1;
   break;
 }
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=0.5;
 break;
}
cont=0;
  turns++;
 
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
     if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   board(val);
   fitness=-1;
   break;
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=0.5;
 break;
}
cont=0;

// System.out.println( "//----User turn----// ");
board(val);
  for(int i1=0;i1<=i.length-1;i1++){
 i[i1]=val[i1];
 j[i1]=-val[i1];
}
    //i=val;
//nnet(arc,i1,w)
o=nnet(arc,j,w1);


for(int i1=0;i1<=o.length-1;i1++){
 a1[i1]=o[i1];
}
Arrays.sort(a1);

ch1=0;
for(int ip=1;ip<=9;ip++){
r1=a1[a1.length-ip];
for(int i1=0;i1<=a1.length-1;i1++){

 if(o[i1]==r1&&av_spt[i1]==true){
 ans=i1;
 ch1=1;
}
}
 if(ch1==1){
 break;
}
}
ch1=0;
val[ans]=-1;
 av_spt[ans]=false;
    m=check(val);

     if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   board(val);

   fitness=1;
   break;
}

for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);

  fitness=20;
 break;
}
cont=0;


}

 
 System.out.println(fitness);
System.out.println("/--------------/");
// return fitness;

 }

public static void trial_1(short w[]){
  // double w[]=new double [134];

// Scanner in = new Scanner (System.in);

    double val[]=new double[9];
     Scanner in = new Scanner(System.in);
   Arrays.fill(val,0);
 //       val[4]=0;
//    board(val);

   double i[]=new double[9];
   double o[]=new double[9];
  
   boolean av_spt[]=new boolean[9];
  Arrays.fill(av_spt,true);

   int user;
// Arrays.fill(w,Math.random());
 
  double fitness=0;
 int m=0;
 int turns=0;
  double a1[]=new double[o.length];
double r1;
int ans=9;
 int ch1=0;
  int prev=0;
 int cont=0;
 int arc[]={9,5,5,9};
while(m==0){
for(int i1=0;i1<=i.length-1;i1++){
 i[i1]=val[i1];
}
    //i=val;
//nnet(arc,i1,w)
o=nnet(arc,i,w);


for(int i1=0;i1<=o.length-1;i1++){
 a1[i1]=o[i1];
}
Arrays.sort(a1);


for(int ip=1;ip<=9;ip++){
r1=a1[a1.length-ip];
for(int i1=0;i1<=a1.length-1;i1++){

 if(o[i1]==r1&&av_spt[i1]==true){
 ans=i1;
 ch1=1;
}
}
 if(ch1==1){
 break;
}
}
ch1=0;
val[ans]=1;
 av_spt[ans]=false;
    m=check(val);

 // board(val);
  if(m==1){
  //  System.out.println(" Computer wins !!!");\ 
   board(val);
    fitness=12;
   break;
 }
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=20;
 break;
}
cont=0;
  turns++;
 
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
     if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   board(val);
   fitness=-60;
   break;
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=20;
 break;
}
cont=0;

// System.out.println( "//----User turn----// ");
board(val);
  user=in.nextInt();

 while(val[user]!=0){
  System.out.println("Invalid choice !!!  Enter choice again");
    user=in.nextInt();
 }
 val[user]=-1;
 av_spt[user]=false;
    m=check(val);
  prev=user;
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=20;
 break;
}
cont=0;
     if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   board(val);
   fitness=-60;
   break;
}

}

 
 System.out.println(fitness);
// return fitness;

 }

public static void trial_2(short w[]){
  // double w[]=new double [134];

// Scanner in = new Scanner (System.in);

    double val[]=new double[9];
     Scanner in = new Scanner(System.in);
   Arrays.fill(val,0);
 //       val[4]=0;
//    board(val);

   double i[]=new double[9];
   double o[]=new double[9];
  
   boolean av_spt[]=new boolean[9];
  Arrays.fill(av_spt,true);

   int user;
// Arrays.fill(w,Math.random());
 
  double fitness=0;
 int m=0;
 int turns=0;
  double a1[]=new double[o.length];
double r1;
int ans=9;
 int ch1=0;
  int prev=0;
 int cont=0;
 int arc[]={9,5,5,9};
while(m==0){
for(int i1=0;i1<=i.length-1;i1++){
 i[i1]=(0-val[i1]);
}
    //i=val;
//nnet(arc,i1,w)
board(val);
  user=in.nextInt();
 while(val[user]!=0){
  System.out.println("Invalid choice !!!  Enter choice again");
    user=in.nextInt();
 }
 val[user]=1;
 av_spt[user]=false;
    m=check(val);
  prev=user;


 // board(val);
  if(m==1){
  //  System.out.println(" Computer wins !!!");\ 
   board(val);
    fitness=12;
   break;
 }
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=20;
 break;
}
cont=0;
  turns++;
 
for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
     if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   board(val);
   fitness=-60;
   break;
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=20;
 break;
}
cont=0;

// System.out.println( "//----User turn----// ");
board(val);
for(int i1=0;i1<=i.length-1;i1++){
 i[i1]=(0-val[i1]);
}

o=nnet(arc,i,w);


for(int i1=0;i1<=o.length-1;i1++){
 a1[i1]=o[i1];
}
Arrays.sort(a1);


for(int ip=1;ip<=9;ip++){
r1=a1[a1.length-ip];
for(int i1=0;i1<=a1.length-1;i1++){

 if(o[i1]==r1&&av_spt[i1]==true){
 ans=i1;
 ch1=1;
}
}
 if(ch1==1){
 break;
}
}
ch1=0;
val[ans]=-1;
 av_spt[ans]=false;
    m=check(val);

for(int ip1=0;ip1<=8;ip1++){
  if(av_spt[ip1]==false){
   cont++;
}
}
 if(cont==9){
 // System.out.println(" Tie !!!");
   board(val);
  fitness=20;
 break;
}
cont=0;
     if(m==-1){
    // board(val);
  // System.out.println(" User wins !!!");
   board(val);
   fitness=-60;
   break;
}

}

 
 System.out.println(fitness);
// return fitness;

 }
public static int check(double val[]){
//0-1-2
//3-4-5
//6-7-8
int ans=0;
if(val[2]==val[4]&&val[4]==val[6]){
 if(val[2]==1)
  ans=1;
 if(val[2]==-1)
  ans=-1;
 return ans;
}
if(val[0]==val[4]&&val[8]==val[4]){
 if(val[0]==1)
  ans=1;
 if(val[0]==-1)
  ans=-1;
 return ans;
}
for(int i=0;i<=2;i++){
 if(val[0+(3*i)]==val[1+(3*i)]&&val[1+(3*i)]==val[2+(3*i)]){
  if(val[0+(3*i)]==1)
  ans=1;
  if(val[0+(3*i)]==-1)
  ans=-1;
   return ans;
}
 if(val[0+(i)]==val[3+(i)]&&val[3+(i)]==val[6+(i)]){
  if(val[0+(i)]==1)
  ans=1;
  if(val[0+(i)]==-1)
  ans=-1;
   return ans;
}
}
 return ans;
}
 
public static void board(double val[]){
  for(int i=0;i<=8;i++){


  System.out.print(i);
  if(val[i]==1)
  System.out.print("| X |");
  else if(val[i]==-1)
  System.out.print("| O |");
  else 
  System.out.print("|   |");

  if((i+1)%3==0){
  System.out.println();
}

}
 System.out.println("--------");
 }
}



