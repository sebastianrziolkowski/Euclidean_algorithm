package main.java.Algorithm;

public class Function {


    public int NWDo(int a, int b)
    {
        if(a<0)
            a=a*-1;
        if(b<0)
            b=b*-1;

        if(a>b)
            a=a-b;
        else b=b-a;

        while(a!=b)
        {
            if(a>b)
                a=a-b;
            else b=b-a;
        }

        return a;
    }


    public int NWDd(int a, int b)
    {

        int x = 0;
        if(a<0)
            a=a*-1;
        if(b<0)
            b=b*-1;


        while(b!=0)
        {
            int temp = a%b;
            a=b;
            b=temp;
        }

        return a;
    }
}
