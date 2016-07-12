#!/usr/bin/ruby
# -*- coding: UTF-8 -*-
#!/usr/bin/ruby
# -*- coding: UTF-8 -*-
#ruby循环语句学习



#ruby while语句
$i = 1 
$num = 5
	while $i < $num
		puts "在while循环语句中 i = #{$i} "
		$i = $i + 1
	end
	
puts ' --- 1  ---------------华丽丽的分割线------------'	

#ruby until语句
$i1 = 1 
$num1 = 5
	until $i1 > $num1
		puts "在until循环语句中 i = #{$i1} "
		$i1 = $i1 + 1
	end

puts ' --- 2  ---------------华丽丽的分割线------------'
	
#ruby for 语句
# 关于 do，如果是分行写的，可以省略 do ，如果是 一行写的，必须使用do隔开
for i in 0..5 do  puts "输出变量的值为 #{i}"
end
	
puts ' --- 3  ---------------华丽丽的分割线------------'	
(0..4).each do |i|
	puts "局部变量#{i}"
end

puts ' --- 4  ---------------华丽丽的分割线------------'
	
#ruby break 语句

for ii in 0..5
	if ii > 2 then 
		break
	end
		puts "局部变量 #{ii}"
end	
		
puts ' --- 5  ---------------华丽丽的分割线------------'	

#ruby next 语句
 	
	for oo in 0..5
		if oo < 2 then 
			puts "哈哈，执行一下而已，然后跳出去"
			next 
		end
			puts "next形式局部变量的值 #{oo}"		
	end		

puts ' --- 6  ---------------华丽丽的分割线------------'			



#ruby redo语句

=begin
for pp in 0..5
	if pp < 2 then
		puts "redo 局部变量的值 #{pp}"
		redo
	end
end
#上面代码 会进入一个无限的循环
=end	
	
#ruby retry 语句
# 1.9 及 > 1.9的版本中不支持在循环中使用retry
	

	
	
	
	
	
	
	