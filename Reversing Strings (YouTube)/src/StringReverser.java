public class StringReverser{
    String word;
    StringReverser(String word){
        this.word = word;
    }
    public void reverseString(){
       String reversedString = "";
       for(int i = word.length()-1;i >=0;i--){
           reversedString += word.charAt(i);
       
       
       }
        
        System.out.println("Word: " + this.word);
        System.out.println("Word Reversed: " + reversedString);
    }
    
    
    public static void main(String[] args) {
        StringReverser sr = new StringReverser("Goku");
        sr.reverseString();
        
 }
    
}