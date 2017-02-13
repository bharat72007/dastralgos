import java.lang.*;


public class RegxEngine{

public static boolean match(String str, String pattern){
    if(str == null || pattern == null) throw new IllegalArgumentException("Either pattern or string is null");
    else if(str.length() == 0 && pattern.length() == 0) return true;
    else if (str.length() == 1 && pattern.length() == 1 && str.charAt(0) == pattern.charAt(0)) return true;
    else if (str.length() == 1 && pattern.length() == 1 && str.charAt(0) != pattern.charAt(0) && pattern.charAt(0) != '*'&& pattern.charAt(0) != '.' && pattern.charAt(0) != '?' &&pattern.charAt(0) != '+') return false;
    else if (pattern.length() == 0 && str.length() > 0) return false;
    else if(pattern.length()>0 && str.length()==0){
        //Linearly check if it contains, only "*" ==> return true, else false.
        for(int k=0;k<pattern.length();k++){
            if(pattern.charAt(k) != '*' && pattern.charAt(0) != '?') return false;
        }
        return true;
    }
    else if(pattern.length() == 0 && str.length()>0){ return false;}
    else if(pattern.charAt(0) != '*' && pattern.charAt(0) == str.charAt(0)) {
        return match(str.substring(1), pattern.substring(1));
    }
    else if(pattern.charAt(0) == '.' && str.length()>0){
      return match(str.substring(1), pattern.substring(1));
    }
    
    else{
      if(pattern.charAt(0) == '*')
        return match(str.substring(1), pattern.substring(0)) || match(str.substring(0), pattern.substring(1)) || match(str.substring(1), pattern.substring(1)); 
      else if(pattern.charAt(0) == '?'){
        return  match(str.substring(0), pattern.substring(1)) || match(str.substring(1), pattern.substring(1));
      }
      else if(pattern.charAt(0) == '+'){
        return match(str.substring(1), pattern.substring(0)) || match(str.substring(1), pattern.substring(1)); 
        
      }
      else
      return false;
    }
}


public static void main(String args[]){
  System.out.println(match("abbbbbbbbbbbbbbb","******a***b****b"));
  System.out.println(match("acbd","*..*."));
  System.out.println(match("ac","a??c"));
  System.out.println(match("ac","a+c"));
  System.out.println(match("acc","a+c"));
  System.out.println(match("a0bcde01234","a+b*0?12+3**"));
  //System.out.println(match("abbbbbbbbbbbbbbb",null));
}

}