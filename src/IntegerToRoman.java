/**
 * Created by NicolasTsui on 7/18/15.
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        while(num>0){
            if(num>=1000){
                apnd(sb,'M',num/1000);
                num%=1000;
            }else if(num>=500){
                if(num>=900){
                    sb.append("CM");
                    num-=900;
                }else{
                    sb.append("D");
                    num-=500;
                }
            }else if(num>=100){
                if(num>=400){
                    sb.append("CD");
                    num-=400;
                }else{
                    apnd(sb,'C',num/100);
                    num%=100;
                }
            }else if(num>=50){
                if(num>=90){
                    sb.append("XC");
                    num-=90;
                }else{
                    sb.append("L");
                    num-=50;
                }
            }else if(num>=10){
                if(num>=40){
                    sb.append("XL");
                    num-=40;
                }else{
                    apnd(sb,'X',num/10);
                    num%=10;
                }
            }else if(num>=5){
                if(num>=9){
                    sb.append("IX");
                    num-=9;
                }else{
                    sb.append("V");
                    num-=5;
                }
            }else{
                if(num>=4){
                    sb.append("IV");
                    num-=4;
                }else{
                    apnd(sb,'I',num);
                    num=0;
                }

            }

        }
        return sb.toString();
    }
    public static void apnd(StringBuilder sb,char c,int count){
        for(int i=0;i<count;i++){
            sb.append(c);
        }
    }
    public static void main(String[] args){
        System.out.println(intToRoman(1990));
    }
}
