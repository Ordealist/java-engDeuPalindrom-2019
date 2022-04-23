/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringbuilderfx;

import java.util.*;

/**
 *
 * @author Austin Brown
 */
public class PlindromeFX {

    public static Boolean evalText(String args) {

        StringBuilder palindrome = new StringBuilder();

        palindrome.append(args);

        String reversed = palindrome.reverse().toString();

        //palindrome.reverse() cannot be resolved to a variable,
        //so I think of this as typecasting
        //palindrome.setLength(0);
        int compareString = args.compareTo(reversed);

        //System.out.println(" " + compareString);
        if (compareString != 0) {
            return false;

        }

        return true;

    }

}
