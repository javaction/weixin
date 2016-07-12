#!/usr/bin/ruby -w
# -*- coding : utf-8 -*-

=begin
class Vehicle{
	Number no_of_wheels
	Number horsepower
	Characters type_of_tank
	Number capacity
	Function speeding{
		
		}
	Function driving{
	 	
		}
	Fnction halting{
		
		}
	}
	
	class Customer
		@@no_of_customer=0  #类变量
		
		def initialize(id ,name ,addr)
			@cust_id = id
			@cust_name = name
			@cust_addr = addr
		end
	end
	
	cust1 = Customer. new("1","john","dajieda")
	cust2 = Customer. new("2","mad","dffaas") 
	
=end

class Customer
	@@no_of_customers=0
	def initialize(id ,name ,addr)
		#     @cust_id ，@cust_name ，@cust_addr  都是实例变量
		@cust_id = id
		@cust_name = name
		@cust_addr = addr
	end
	# display_details()方法包含了三个 put 语句，将在一个单行上显示文本 Customer id 和变量 @cust_id 的值。
	#  格式为 文本名称 #变量名称  。使用#连接
	def display_details()
		puts "Customer id #@cust_id"
		puts "Customer name #@cust_name"
		puts "Customer address #@cust_addr"
	end
	
	def total_no_of_customers()
		@@no_of_customers += 1
		puts "Total number of customers : #@@no_of_customers"
	end
end

#创建对象
cust1 = Customer.new("1","tom1","hh street1111111111")
cust2 = Customer.new("2","tom2","hh street2222222222")

#调用方法
cust1.display_details()
cust1.total_no_of_customers()

cust2.display_details()
cust2.total_no_of_customers()

----------------------------

#!/usr/bin/ruby -w
# -*- coding : utf-8 -*-

=begin
#ruby 变量
支持五种类型的变量 ： 一般小写字母，下划线 开头
$开头 ： 全局变量
@开头 ： 实例变量
@@开头 ：类变量 ，被共享在整个继承链中
大写字母开头 ： 常数

=end
# 全局变量
$global_variable = 10

class Class1
	def print_global
		puts "全局变量在class1的输出 #$global_variable"
	end
end

class Class2
	def print_global 
		#puts "全局变量在class1的输出 #$global_variable"
		puts "全局变量在class2的输出 #$global_variable"
	end
end

class1obj = Class1.new
class1obj.print_global
class2obj = Class2.new
class2obj.print_global


-----------------------------------










	
	
















	
	


















	
	


