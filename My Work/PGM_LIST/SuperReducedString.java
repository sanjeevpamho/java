/*1. input : zztqooauhujtmxnsbzpykwlvpfyqijvdhuhiroodmuxiobyvwwxupqwydkpeebxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh
  output : tqauhujtmxnsbzpykwlvpfyqijvdhuhirdmuxiobyvxupqwydkpbxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh

2. input : kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuerhhsanpdtmrzibswswzjjbjqytgfewiuu
  output : kagoyzkgfjnyvjewazalxngpdcfahneqoqgiyjgpzobhaghmgzmnwcmeykqzgajlmuersanpdtmrzibswswzbjqytgfewi

3. input : ggppppuurrjjooddwwyyllmmvvffddmmppxxaabbddddooppxxgghhhhvvnneeqqyyttbbffvvjjiiaammmmddddhhyywwqqiijj
  output : Empty String

4. input : aaabccddd
  output : abd
*/

package way.to.go.commonProblems;

public class SuperReducedString {

	public static void main(String[] args) {
		
		String str = "ggppppuurrjjooddwwyyllmmvvffddmmppxxaabbddddooppxxgghhhhvvnneeqqyyttbbffvvjjiiaammmmddddhhyywwqqiijj";
		System.out.println("str : "+str);
		
		str = str.replaceAll("\\s", "");
       
        boolean isDone=false;
        String res="";
        
        while(!isDone){
        	int i=0;
        	res="";
        	char[] arr = str.toCharArray();
        	boolean isReplaced = false;
        	for(; i<arr.length-1; i++){
        		if(arr[i]==arr[i+1]){
        			i=i+1;
        			isReplaced = true;
        		}else{
        			res=res+""+arr[i];
        		}
        	}
        	
        	
        	  if(i==arr.length-1)
              	res=res+""+arr[i];
        	  
        	  if(!isReplaced){
          		isDone = true;
          		break;
          	}
        	  
        	  str = res;
        }
        
      
        
        if(res.equals(""))
            System.out.println("Empty String");
        else
            System.out.println("res : "+res);
		
	}

}
