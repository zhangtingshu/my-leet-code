package com.shboot.leetcode;

/**
 * @author: zhangtingshu
 * @date: 2020/5/19 11:06
 * @description: .
 */
public class Q680ValidPalindrome {
    public boolean validPalindrome(String s) {
        if (s==null|| s.isEmpty()){
            return true;
        }
        int start=0;
        int end=s.length()-1;
        boolean flag=false;
        while (end>=start){
            if (s.charAt(start)==s.charAt(end)){
                end--;
                start++;
            }else {
                //不相等了，需要移位，但移动左边还是右边，是一个问题，因为只会有一个多余字符，则进行两种尝试
                if (s.charAt(start+1)==s.charAt(end)){
                    int startnew=start+1;
                    int endnew=end;
                    while (endnew>=startnew){
                        if (s.charAt(startnew)==s.charAt(endnew)){
                            endnew--;
                            startnew++;
                        }else {
                            break;
                        }
                    }
                    flag= endnew<=startnew;
                }
                if (!flag&&s.charAt(start)==s.charAt(end-1)){
                    int startnew=start;
                    int endnew=end-1;
                    while (endnew>=startnew){
                        if (s.charAt(startnew)==s.charAt(endnew)){
                            endnew--;
                            startnew++;
                        }else {
                            break;
                        }
                    }
                    flag= endnew<=startnew;
                }
                return flag;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q680ValidPalindrome q680ValidPalindrome = new Q680ValidPalindrome();
        System.out.println(q680ValidPalindrome.validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
        System.out.println(q680ValidPalindrome.validPalindrome("abca"));
//        System.out.println(q680ValidPalindrome.validPalindrome("ba"));
//        System.out.println(q680ValidPalindrome.validPalindrome("aba"));
    }
}
