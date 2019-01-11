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


    public long[] expandedEuclidean(long a, long b)
    {
        long x = 0, y = 1, q, r;
        long nwd_a = 1, nwd_b = 0;
        long temp;

        while (b != 0)
        {
            q = a / b;
            r = a % b;

            a = b;
            b = r;

            temp = x;
            x = nwd_a - q * x;
            nwd_a = temp;

            temp = y;
            y = nwd_b - q * y;
            nwd_b = temp;
        }

        long tab[] = new long[3];

        //NWD
            tab[0]=a;
        //x
            tab[1]=nwd_a;
        //y
            tab[2]=nwd_b;


            return tab;

    }


}
