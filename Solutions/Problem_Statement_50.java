import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/
public class Problem_Statement_50 {
    static List<List<String>> groupingAnagram(String[] strs) {
        HashMap<String,ArrayList<String>> hm=new HashMap<>();
        List<List<String>> lis=new ArrayList<List<String>>();
        for(int i=0;i<strs.length;i++){
            char ch[]=strs[i].toCharArray();
            Arrays.sort(ch);
            String s=new String(ch);
            if(hm.containsKey(s)){
                ArrayList<String> arr=new ArrayList<String>(hm.get(s));
                arr.add(strs[i]);
                hm.put(s, arr);
            }
            else{
                ArrayList<String> arr=new ArrayList<String>();
                arr.add(strs[i]);
                hm.put(s, arr);
            }
        }
        for(String s1: hm.keySet()){
            lis.add(hm.get(s1));
        }
        return lis;
}
    public static void main(String[] args) {
        String[] str={"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupingAnagram(str));
    }
}
