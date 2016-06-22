import java.util.Arrays;
//Nick Maris 
public class Oef7

{ 

    public static void main(String args[]) 

{ 
int a[ ]={12,34,56,78,123,234,99,88};
int b[ ]= new int[a.length];
int c = 0;
for(int j=0;j<a.length;j++)
{
for(int i=0;i<a.length;i++)
{

if(a[i]>b[j])
{
b[j] = a[i];
c=i;
}
}
a[c]=0;
}
System.out.println(Arrays.toString(b));
}
}