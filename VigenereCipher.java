import java.util.Scanner;
class VigenereCipher{
	 public String encrypt(String plainText, String key){
		 plainText = plainText.toUpperCase();
		 key=key.toUpperCase();
		 String cipherText="";
		 int keyIndex=0;
		 for(int i=0;i<plainText.length();++i){
		 char c= plainText.charAt(i);
		 int index=Math.floorMod(Constants.ALPHABET.indexOf(c)+Constants.ALPHABET.indexOf(key.charAt(keyIndex)),26);
		 cipherText=cipherText+Constants.ALPHABET.charAt(index);
		 keyIndex++;
		 if(keyIndex==key.length())
		 keyIndex=0;
		 
		 }
		 return cipherText;
		 }
	 public String decrypt(String cipherText, String key){
		 cipherText = cipherText.toUpperCase();
		 key=key.toUpperCase();
		 String plainText="";
		 int keyIndex=0;
		 for(int i=0;i<cipherText.length();++i){
		 char c= cipherText.charAt(i);
		 int index=Math.floorMod(Constants.ALPHABET.indexOf(c)-Constants.ALPHABET.indexOf(key.charAt(keyIndex)),26);
		 plainText=plainText+Constants.ALPHABET.charAt(index);
		 keyIndex++;
		 if(keyIndex==key.length()){
		 keyIndex=0;
		 }
		 }
		 return plainText;
		 }
	 
}
class Constants{
	private Constants(){
	}
	public static final String ALPHABET ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}

public class Main{
	public static void main(String[]args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter your Plain Text");
		String sai = s.nextLine();
		System.out.println("Enter your key");
		String pranay =s.nextLine();
		VigenereCipher vC= new VigenereCipher();
		String cipherText = vC.encrypt(sai, pranay);
		System.out.println("Cipher Text for given Plain Text is: "+cipherText);
		String pT=vC.decrypt(cipherText,pranay);
		System.out.println("The text again after decrypting: "+pT);
	}
}

