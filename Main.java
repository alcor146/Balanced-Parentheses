package wkrjn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        String s = "{egwg}{fe}{wefw{weg{weg}}}{rd}{{wegrg}}";

        System.out.println(s);
        System.out.println(s.substring(0, 4 + 1)+ s.substring(5 + 1));

        for(int index=0; index<s.length()-1; index++) {
            if(s.charAt(index) == '/' && s.charAt(index+1) == '/')
                if(index != 0)
                    s = s.substring(0, index);
        }


        Deque<Character> stack = new ArrayDeque<Character>();
        List<Integer> positions = new ArrayList<>();

        int maxLength = 0;

        
            for(int index=0; index<s.length(); index++) {
                char x = s.charAt(index);
                if(x == '{') {
                    stack.push(x);
                    if(maxLength < stack.size()) {
                        maxLength = stack.size();
                        if(!positions.isEmpty()) {
                            positions.clear();
                        }
    
                        positions.add(index);
                    }
                    else if(maxLength == stack.size()) 
                        positions.add(index);
                }

                if(stack.isEmpty())
                    System.out.println("not balanced");
                
                if(x == '}') {
                    stack.pop();
                    if(maxLength-1 == stack.size())
                        positions.add(index);
                }
            }

        if(!stack.isEmpty())
            System.out.println("error");
        
        System.out.println(positions);

        StringBuffer text = new StringBuffer(s);


        if(!positions.isEmpty()) {
            for(int i=0; i<positions.size(); i=i+2) {
                //s = s.substring(0, positions.get(i) + 1) + "..." + s.substring(positions.get(i+1) + 1);
                text.replace(positions.get(i)+1 ,positions.get(i+1) ,"...");
                for(int j=i+2; j<positions.size();j++)
                    positions.set(j, positions.get(j) - (positions.get(i+1) - positions.get(i) - 4));

            }
        System.out.println(text);}
        
    }
}


