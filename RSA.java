import java.util.*;
import java.math.*;
class RSA
{static int gcd(int e, int z)
{
	if(e==0)
		return z;	
	else
		return gcd(z%e,e);
}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int p,q,n,piofn,d=0,e,i;
		System.out.println("Enter the number ");
		int msg=sc.nextInt();
		double plntxt;
		double ciptxt; 
		System.out.println("Enter 1st prime number p");
		p=sc.nextInt();
		System.out.println("Enter 2nd prime number q");
		q=sc.nextInt();
		
		n=p*q;
		piofn=(p-1)*(q-1);
		System.out.println("the value of z = "+piofn);		

		for(e=2;e<piofn;e++)
		{
			if(gcd(e,piofn)==1)            // e is for public key exponent
			{				
				break;
			}
		}
		System.out.println("the value of e = "+e);				
		for(i=0;i<=9;i++)
		{
			int x=1+(i*piofn);
			if(x%e==0)      //d is for private key exponent
			{
				d=x/e;
				break;
			}
		}
		System.out.println("the value of d = "+d);		
		plntxt=(Math.pow(msg,e));
		double rr=plntxt%n;
                //converting int value of n to BigInteger
		ciptxt = (Math.pow(msg,d));
		double ss=ciptxt%n;

	
	   
	System.out.println("Enter the option 1 for encryption and 2 for decryption");
    int option=sc.nextInt();
   
	switch (option) { 
    case 1: 
    
		System.out.println("Encrypted message is : ");
		System.out.println(plntxt);
		System.out.println(rr);
        break; 
    case 2: 
    	
		System.out.println("Derypted message is : ");
		System.out.println(ciptxt);
		System.out.println(ss);
        break; 
    default: 
       System.out.println("Enter valid option");
        break;
	}
   }
}
