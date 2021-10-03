package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_statemet_32 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("ENTER THE STRING ");
        String S = in.next();   //input string
        System.out.println(permutationlist(S));
        // since we have to find permutations of given string , recursion is best way to do so
        //recursion naturally favors DFS
        // start with - string with fully lowered case
        //then each dfs call will- current unchanged and other char uppercased


    }


        public static List<String> permutationlist(String S) {
            List<String> ans = new ArrayList<>();
            dfs(S.toLowerCase().toCharArray(), ans, 0, S.length());  //char array is faster than string in java
            return ans;
        }
        public static void dfs(char[] chArr, List<String> ans, int i, int len) {
            if (i < len) {
                dfs(chArr, ans, i+1, len);
                if (Character.isLetter(chArr[i])) {
                    chArr[i] = Character.toUpperCase(chArr[i]);
                    dfs(chArr, ans, i+1, len);
                    chArr[i] = Character.toLowerCase(chArr[i]);
                }
            } else ans.add(new String(chArr));
        }
    }


