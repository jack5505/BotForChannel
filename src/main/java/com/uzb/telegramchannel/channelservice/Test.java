package com.uzb.telegramchannel.channelservice;

import java.util.Scanner;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class Test {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while (t-- > 0)
        {
            int n = cin.nextInt();
            int temp = n;
            int cnt = 0;
            while (n >= 2020){
                n -= 2020;
                cnt ++;
            }
            if(cnt >= n && ((cnt - n) * 2020 + (n * 2021)) == temp){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
