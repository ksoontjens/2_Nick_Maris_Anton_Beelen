import java.util.Arrays;
//Nick Maris 
public class Oef6

{ 

    public static void main(String args[]) 

{ 
int a[ ]={12,34,56,78,123,234,99,88};
int b = 0;
for(int i=0;i<8;i++)
{

if(a[i]>b)
{
b = a[i];
}if(i==7)
{
System.out.println("grootste is: " +b);
}
}
}
}