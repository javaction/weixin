#!/usr/bin/ruby -w
# -*- coding: UTF-8 -*-

#ruby 其他 

#包括 文件的输入与输出、File类和方法、Dir类和方法、异常

puts ' --- 1  ---------------华丽丽的分割线------------'
#gets 语句可用于获取来自名为 STDIN 的标准屏幕的用户输入。
puts "enter a value :"
val = gets
puts val

######################################
#与 puts 语句不同，puts 语句输出整个字符串到屏幕上，而 putc 语句可用于依次输出一个字符。
str = "Hello Ruby"
putc str

######################################
#print 语句与 puts 语句类似。唯一的不同在于 puts 语句在输出内容后会跳到下一行，而使用 print 语句时，光标定位在同一行。

######################################
#打开和关闭文件

#File.new 方法

file001 = File.new("filename","mode")
	# 文件处理..
file001.close

######################################
#File.open 方法
File.open("filename", "mode") do |aFile|
   # ... process the file
end

######################################
#打开文件的不同模式    http://www.runoob.com/ruby/ruby-input-output.html



























