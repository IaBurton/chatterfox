package com.code.fox.chatterfox;

import com.google.common.base.Joiner;
 
public class GuavaApp
{
    public static void main(String[] args) 
    {
        String[] words = {"Hello", "World", "using", "the", "Guava", "library"};
        String joined = Joiner.on(" ").join(words);
        System.out.println(joined);
    }
}
