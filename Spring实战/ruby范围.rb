#!/usr/bin/ruby -w
# -*- coding: UTF-8 -*-

#ruby 范围 学习

# 指定范围
digits = 0..6

puts digits.include?(5)
ret = digits.min
puts "最小值为 #{ret}"

ret = digits.max
puts "最大值为 #{ret}"

ret = digits.reject {|i| i < 5 }
puts "不符合条件的有 #{ret}"

digits.each do |digit|
   puts "在循环中 #{digit}"
end

puts ' --- 1  ---------------华丽丽的分割线------------'

score = 100

result = case score when 0..40 then "不好"
when 41..60 then "一般" when 61..100 then "好"
end
	puts result
	
puts ' --- 2  ---------------华丽丽的分割线------------'	

#作为间隔的范围
#范围的最后一个用途是间隔检测：检查指定值是否在指定的范围内。需要使用 === 相等运算符来完成计算。
	
if((1..10) === 15)
	puts "5在这个范围内"
	
elsif
	puts "不在这个范围内"
end
	
if(("'a'..'j'") === 'z')
	puts "z在这个范围呢"
elsif
	puts "z不在这个范围"
end
	
	
	
	
	
	
	
