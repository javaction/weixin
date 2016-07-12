#!/usr/bin/ruby
# -*- coding: UTF-8 -*-

#ruby 方法 学习

=begin
def method1(a1="语文",a2="数学")
	puts "第一门课程是 #{a1}"
	puts "第二门课程是 #{a2}"
end
method1
method1("英语","生物")
method1"英语1","生物1"
	
puts ' --- 1  ---------------华丽丽的分割线------------'	

#ruby 从方法中返回值
def method2
	a = 1
	b = 2 
	c = 3
end
var = method2
puts var	# 默认返回最后一个的值

puts ' --- 2  ---------------华丽丽的分割线------------'

def method3
	a = 4
	b = 5
	c = 6
	return a,b,c
end
var = method3
puts var
	
puts ' --- 3  ---------------华丽丽的分割线------------'

def method4(*test)
	puts "参数个数为 #{test.length}"
	for i in 0...test.length
		puts "参数值为 #{test[i]}"
	end
end

method4("aa","bb","cc")

#在这里需要注意的是，循环中的符号 .. 和 ... 是不同的。
#其中， .. 包含结束点（[]） ； ...不包含结束点 （[)）
=end
puts ' --- 4  ---------------华丽丽的分割线------------'

#ruby 类方法

class Acount001
	def fun001
		puts "fun001"
	end
	def Acount001.fun002  #特殊写法
		puts "fun002"
	end	
end

c1 = Acount001.new
c1.fun001  	       #一般写法。需要注意的是，代码后注释，尽量排齐 
Acount001.fun002   #根据特殊写法，不用创建实例，也可以直接访问方法

#注意在声明类时候，不能使用 class 开头，即使是如 class001 ，也不可以

puts ' --- 5  ---------------华丽丽的分割线------------'

#ruby alias 语句 为方法或者全局变量起别名

puts ' --- 6  ---------------华丽丽的分割线------------'

#ruby undef 语句  用于取消方法定义。undef不能出现在方法主体内。








	
	
	