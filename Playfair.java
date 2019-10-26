import java.util.Scanner;

class Playfair{

	String ciphertext = "";
	void showKeyMatrix(String key[][]){
		for(int i = 0;i<5;i++){
			for(int j = 0;j<5;j++){
				System.out.print(key[i][j]);
			}
			System.out.println();
		}
	}

	String Encryprion(String a,String b,String[][] key){
		int xa=0,ya=0,xb=0,yb=0;
		for(int i = 0;i<5;i++){
			for(int j = 0;j<5;j++){
				if(key[i][j].equals(a)){
					xa=i;ya=j;
					break;
				}		
		}
	}

		for(int i = 0;i<5;i++){
			for(int j = 0;j<5;j++){
				if(key[i][j].equals(b)){
					xb=i;yb=j;
					break;
				}		
		}
	}

		if(ya==yb){
			if(xa==4)
				xa=0;
			else if(xb==4)
				xb=0;


			ciphertext+=key[xa+1][ya]+key[xb+1][yb];

		}
		else if(xa==xb){
			if(ya==4)
				ya=0;
			else if(yb==4)
				yb=0;

			ciphertext+=key[xa][ya+1]+key[xb][yb+1];
		}
		else{
			ciphertext+=key[xa][yb]+key[xb][ya];
		}

		return ciphertext;
	}
	String Decryprion(String a,String b,String[][] key){
		int xa=0,ya=0,xb=0,yb=0;
		for(int i = 0;i<5;i++){
			for(int j = 0;j<5;j++){
				if(key[i][j].equals(a)){
					xa=i;ya=j;
					break;
				}		
		}
	}

		for(int i = 0;i<5;i++){
			for(int j = 0;j<5;j++){
				if(key[i][j].equals(b)){
					xb=i;yb=j;
					break;
				}		
		}
	}

		if(ya==yb){
			if(xa==4)
				ya=3;
			else if(xb==4)
				yb=3;


			ciphertext+=key[xa][ya]+key[xb][yb];

		}
		else if(xa==xb){
			if(ya==4)
				xa=3;
			else if(yb==4)
				xb=3;

			ciphertext+=key[xa][ya]+key[xb][yb];
		}
		else{
			ciphertext+=key[xa][yb]+key[xb][ya];
		}

		return ciphertext;
	}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	Playfair p = new Playfair();
	String cipher="";
	System.out.println("Enter the key."+"\n"+"Make sure that each character is not repeated");
	String key[][] = new String[5][5];
	for(int i = 0;i<5;i++)
	{
		for(int j = 0;j<5;j++){
			key[i][j] = s.nextLine();
		}
	}
	p.showKeyMatrix(key);
	System.out.println("Enter the plaintext");
	String text = s.nextLine();
	text=text.toLowerCase();
	if((text.length()%2)!=0)
		text = text.concat("x");
	System.out.println("Enter the option to perform action '1'"+
			 "for encryption and '2' for decryption");

    int option=s.nextInt();
	
	switch (option) { 
    case 1: 
    	for(int i = 0;i<text.length();i+=2){
    		String a = Character.toString(text.charAt(i));
    		String b = Character.toString(text.charAt(i+1));
    		cipher = p.Encryprion(a,b,key);
    	}
    	System.out.println("The ciphertext will be  "+cipher);
        break; 
    case 2: 
    	for(int i = 0;i<text.length();i+=2){
    		String a = Character.toString(text.charAt(i));
    		String b = Character.toString(text.charAt(i+1));
    		cipher = p.Decryprion(a,b,key);
    	}
    	System.out.println("The plaintext will be  "+cipher);
        break; 
    default: 
       System.out.println("Enter valid option");
        break; 
	

}
}
}
