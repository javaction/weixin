
#!/usr/bin/ruby
# -*- coding: UTF-8 -*-


#ruby 字符串  学习

#Ruby 中的 String 对象用于存储或操作一个或多个字节的序列。
#Ruby 字符串分为单引号字符串（'）和双引号字符串（"），区别在于双引号字符串能够支持更多的转义字符。

puts ' --- 1  ---------------华丽丽的分割线------------'

#在双引号字符串中我们可以使用 #{} 井号和大括号来计算表达式的值。

x,y,z = 10,20,30
puts "x+y+z = #{x+y+z}"

puts ' --- 2  ---------------华丽丽的分割线------------'
#采用 %q 和 %Q 来引导的字符串变量，%q 使用的是单引号引用规则，而 %Q 是双引号引用规则，
#		后面再接一个 (! [ { 等等的开始界定符和与 } ] ) 等等的末尾界定符。 

desc1 = %Q{Ruby 的字符串可以使用 '' 和 ""。}
desc2 = %q|Ruby 的字符串可以使用 '' 和 ""。|
desc3 = %Q[Ruby 的字符串可以使用 '' 和 ""。]
desc4 = %Q(Ruby 的字符串可以使用 '' 和 ""。)
desc5 = %Q*Ruby 的字符串可以使用 '' 和 ""。*

#开始界定符 和 末尾界定符 ，有很多种，上面写的几个都是可以的。

puts desc1
puts desc2
puts desc3
puts desc4
puts desc5

puts ' --- 3  ---------------华丽丽的分割线------------'

#转义字符
#注意：在一个双引号括起的字符串内，转义字符会被解析。在一个单引号括起的字符串内，转义字符不会被解析，原样输出。


#字符编码

#字符串内建方法

mystr = String.new("我是字符串ABCDE")
foo = mystr.downcase   	#大写转小写
puts "#{foo}"

puts ' --- 4  ---------------华丽丽的分割线------------'

#一些字符串方法 地址： http://www.runoob.com/ruby/ruby-string.html

str = "字符串测试;ABCdefdef"
puts str
#  str1 = str1%arg			 #使用格式规范格式化字符串。没搞明白，需要再测下..
#str2 = str*2				 #重复字符串指定的次数，这里是2次
#str3 = str + "123"		 	 #字符串连接
#str4 = str<<98			 	 #连接一个对象到字符串。如果对象是范围为 0.255 之间的固定数字 Fixnum，则它会被转换为一个字符。把它与 concat 进行比较。
#str5 = str<=>"123"	 	 	 #把 str 与 other_str 进行比较，返回 -1（小于）、0（等于）或 1（大于）。比较是区分大小写的。
#str6 = str.delete("e")  	 #返回 str 的副本，参数交集中的所有字符会被删除。
#str7 = str.delete!("e") 	 #与 delete 相同，但是 str 会发生变化并返回。
#str8 = str.downcase		 #大写转小写

#str9 = str.eql?("字符串测试ABCdefdef")	#判断是否相同。

#str10 = str.insert(1,"插入") #

=begin
arr = str.split(";") 		  #切割为 数组，下面是数组遍历
arr.each do |i|
	puts i
end
=end

=begin
strr = " 123abcABC南海  "
len1 = strr.length
str11 = strr.strip 				   # 去空格
len2 = str11.length
puts len1 ,len2
=end

#str12 = str.tr("ABC","哈哈哈")	#替换指定的字符串

#str13 = str.replace("嘿嘿嘿")		#字符串替换

#str14 = str.index("ABC")

#str15 = str[2..4]					#字符串截取，so easy啊, http://blog.csdn.net/jiedushi/article/details/8485245

#puts str15



puts ' --- 4  ---------------华丽丽的分割线------------'

# 字符串 unpack 指令    http://www.runoob.com/ruby/ruby-string.html		












