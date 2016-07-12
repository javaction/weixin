#!/usr/bin/ruby
# -*- coding: UTF-8 -*-

#ruby 数组 学习

=begin


Ruby 数组是任何对象的有序整数索引集合。数组中的每个元素都与一个索引相关，并可通过索引进行获取。
数组的索引从 0 开始，这与 C 或 Java 中一样。一个负数的索相对于数组的末尾计数的，也就是说，索引为 -1 表示数组的最后一个元素，-2 表示数组中的倒数第二个元素，依此类推。
Ruby 数组可存储诸如 String、 Integer、 Fixnum、 Hash、 Symbol 等对象，甚至可以是其他 Array 对象。
Ruby 数组不需要指定大小，当向数组添加元素时，Ruby 数组会自动增长。
=end


puts ' --- 1  ---------------华丽丽的分割线------------'
#数组示例	
# names = Array.new
 names = Array.new(20)

puts names.length
puts names.size


puts ' --- 2  ---------------华丽丽的分割线------------'

names001 = Array.new(2,"asd")
puts "#{names001}"

puts ' --- 3  ---------------华丽丽的分割线------------'

#数组创建的形式有多种。很灵活。
#也可以使用带有 new 的块，每个元素使用块中的计算结果来填充：
names002 = Array.new(10){|i| i = i + 1}
puts "#{names002}"

puts ' --- 4  ---------------华丽丽的分割线------------'

#自己写一个数组的遍历

names003 = Array.new(6){|i| i = i + 1}
names003.each do |m|
	puts m
end

puts ' --- 5  ---------------华丽丽的分割线------------'
#数组的很多公共方法   http://www.runoob.com/ruby/ruby-array.html



puts ' --- 6  ---------------华丽丽的分割线------------'

#数组 pack 指令



