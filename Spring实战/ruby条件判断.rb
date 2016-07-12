
#!/usr/bin/ruby
# -*- coding: UTF-8 -*-

x = 1
y = 2
if x > 2
   puts "x 大于 2"
elsif x <= 2 and x!=0
   puts "x 是 1"
else
   puts "无法得知 x 的值"
end


if x>y
	puts "x比y大"
elsif x < y 
	puts "x比y小"
else
	puts "相等"
end

if x == 1 then y = 3 end
	puts "y的值为#{y}"
	
puts ' ---1  ---------------华丽丽的分割线------------'	
	#  code if condition  当 if右边的条件成立，则执行左边的式子
	$debug = 123
	print "debug\n" if $debug
	
	# unless 语句 ，和if语句相反，unless的条件为假，则执行其code，反之，则执行else的code	
puts '--- 2  ---------------华丽丽的分割线------------'
w = 1
	unless w > 3
		puts "unless为假，执行unless"
	else 
		puts 'unless为真，执行else'
	end

puts '--- 3  ---------------华丽丽的分割线------------'	
	
	$var = 1
	print "这是if的\n\r" if $var
	print "这是unless" unless $var
	
	$var = false
	print "这是false的unless\r\n" unless $var
	
puts '--- 4  ---------------华丽丽的分割线------------'	

	$age = 9

	case $age 
	when 0..2
		puts '婴儿'
	when 3..6
		puts '小孩'
	when 7..12
		puts '小孩年'
	when 13..18
		puts '少年'
	else 
		puts '其他年龄段'
	end

	#同样的，可以使用case when xxxx then x when cccc then c else n end
	
	puts '--- 5  ---------------华丽丽的分割线------------'
	
	
	
	