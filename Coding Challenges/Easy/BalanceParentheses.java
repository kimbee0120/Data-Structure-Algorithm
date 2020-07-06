/*********************************************
You are given a string with 3 types of tokens, 
each with an "open" type and "closed" type.

A string is "balanced" if all open tokes of a 
certain type are closed appropriately.

Given a string s, return true if it is balanced,
return false otherwise.

Opening tokens:
An open parenthesis (
An open bracket [
An open brace {

Closing tokens:
A closing parenthesis )
A closing bracket ]
A closing brace }

*****************************************/

class BalanceParentheses {
  public boolean isBalance(String S) {
    
    Stack<Character> stack = new Stack<>();
    
    for(int i=0; i<S.length(); i++)
    {
      Character s = S.charAt(i);
      
      if(s== '(' || s=='[' || s=='{'){
        stack.push(s);
      }else if(stack.isEmpty()){
        return false;
      }else if(s == ')'){
        if(stack.pop() != '(')
          return false;
      }else if(s == ']'){
        if(stack.pop() != '[')
          return false;
      }else{
        if(stack.pop() != '{')
          return false;
      }
    }
    
    return true;
      
  }
}