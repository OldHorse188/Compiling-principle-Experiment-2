# 实验二：词法分析程序的设计  

## 实验要求：  
1）完成DFA的数据结构表示和存储；  
2）编写一段程序，接受字符串的输入，判断该字符串是否为该DFA能识别的字符串；  
3）用C#或JAVA语言实现；  

## 识别字符串的DFA为参考课本P65的图3.18的DFA，且用二维数组来存储  
DFA M=（K，Σ，f，S，Z）的行为的模拟程序  

K:=S;  
c:=getchar;  
while c<>eof do  
    {  
      K:=f(K,c);  
      c:=getchar;  
    };  
if K is in Z then  
    return (‘yes’)  
else  
    return (‘no’)  
