
#!/usr/bin/ruby -w
# -*- coding: UTF-8 -*-

#ruby 
#定义一个类
class Box
	def initalize(w,h)
		@width,@height = w, h 
	end	
end
box1 = Box.new

#具体分析：

#initialize 方法
=begin
这是一个标准的Ruby类方法，是类的构造方法，与其他面向对象编程语言中的 constructor 工作原理类似。
如果需要在创建对象的同时初始化一些类变量，initalize方法就派上用场了。
该方法带有一系列参数，与其他 Ruby 方法一样，使用该方法时，必须在前面放置 def 关键字
=end



puts ' --- 1  ---------------华丽丽的分割线------------'
puts "自己简单写个类，熟悉下先前的学习"

=begin
class Student
	def initialize(classroom,teachername)
		@cla = classroom
		@tea = teachername
		#puts classroom
	end
	def getInformation
		puts "班级是：#{@cla}"
	end
end

stu = Student.new("123","tom")
puts stu.getInformation

=end
puts ' --- 2  ---------------华丽丽的分割线------------'

class Car
	
	#构造方法
	def initialize(color,brand)
		@colorr = color
		@brandd = brand
	end
	
	#访问器方法 #为了在类的外部使用变量，我们必须在访问器方法内部定义这些变量，accessor 其实相当于 getter。
	def getColor
		@colorr
	end
	def getBrand
		@brandd
	end
	
	#设置器方法
	#在这里遇到的问题，def setColor = (value) ，这一段代码，都加了空格，执行失败。去掉空格，就可以了。为啥么？
	def setColor= (value)
		@colorr = value
	end
	def setBrand= (value)
		@brandd = value
	end
end

#创建对象
car = Car.new("black","buick")

#使用设置器方法
car.setColor = "red"
car.setBrand = "aodi"

#使用访问器方法
co = car.getColor
br = car.getBrand

puts "车子是 #{br}，颜色是#{co}"



puts ' --- 3  ---------------华丽丽的分割线------------'


















