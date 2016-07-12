#!/usr/bin/ruby
# -*- coding: UTF-8 -*-

#ruby Module（模块） 学习

#模板 ：一种把方法、类和常量组合在一起的方式
#好处：
#1.模块提供了一个命名空间和避免名字冲突
#2.模块实现了mixin装置。（这是啥？）

#模块与类的区别
#1.模块不能实例化
#2.模块没有子类
#3.模块只能被另一个模块定义

#模块常量命名与类常量命名类似，以大写字母开头。方法定义看起来也相似：模块方法定义与类方法定义类似。

#通过类方法，您可以在类方法名称前面放置模块名称和一个点号来调用模块方法，您可以使用模块名称和两个冒号来引用一个常量。
puts ' --- 1  ---------------华丽丽的分割线------------'	

=begin
下面的这个是个模板样式
module Moban001
	PI = 3.1415926
	def Moban001.sin(x)
	end
	def Moban001.cos(x)
	end
end
=end

puts ' --- 2  ---------------华丽丽的分割线------------'	

#ruby require 语句  #引入
=begin
#在这里，我们使用 （ $LOAD_PATH << '.' ） 让 Ruby 知道必须在当前目录中搜索被引用的文件。如果您不想使用 $LOAD_PATH，那么您可以使用 require_relative 来从一个相对目录引用文件。
#注意：在这里，文件包含相同的函数名称。所以，这会在引用调用的程序时导致代码模糊，
但是模块避免了这种代码的模糊，而且我们可以使用模块的名称调用适当的函数。

=end

#ruby include 语句  # 可以将模块嵌入到类中

puts ' --- 3  ---------------华丽丽的分割线------------'	

#当一个类可以从多个父类继承类的特性时，该类显示为多重继承。

#ruby Mixins 

module A
	def a1
		puts "a1的"
	end
	def a2
		puts "a2的"
	end
end

module B
	def b1
		puts "b1的"
	end
	def b2
		puts "b2的"
	end
end

class Sample
	include A 	#使用include，在类中嵌入模块
	include B   
	def s1
		puts "s1的"
	end
end

samp = Sample.new
samp.a1
samp.a2
samp.b1
samp.b2
samp.s1













