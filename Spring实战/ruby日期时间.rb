#!/usr/bin/ruby -w
# -*- coding: UTF-8 -*-

#ruby 日期、时间学习

#Time 类在 Ruby 中用于表示日期和时间。(1970~2038)

time001 = Time.new
puts "当前时间："+ time001.inspect

time002 = Time.now
puts "当前时间："+time002.inspect

#两种方式都可以

puts ' --- 1  ---------------华丽丽的分割线------------'

#获取 Date & Time 组件

time003 = Time.new
puts time003.year
puts time003.month
puts time003.day
puts time003.wday  			#一周中的星期几（0是周日）
puts time003.yday			#365：一年中的第几天
puts time003.hour			#23：24 小时制
puts time003.min			#59
puts time003.sec			#59
puts time003.usec			#999999：微秒
puts time003.zone			#"UTC"：时区名称

puts ' --- 2  ---------------华丽丽的分割线------------'

# Time.utc、Time.gm 和 Time.local 函数

time004 = Time.local(2008, 7, 8) 
puts time004

time005 = Time.local(2008, 7, 8, 9, 10)
puts time005

time006 = Time.utc(2008, 7, 8, 9, 10) 
puts time006

time007 = Time.gm(2008, 7, 8, 9, 10, 11) 
puts time007

#还有好多嗯....

puts ' --- 3  ---------------华丽丽的分割线------------'
#时区和夏令时  转换函数
puts "时区和夏令时  转换函数"

puts ' --- 4  ---------------华丽丽的分割线------------'
#格式化时间和日期 
puts "格式化时间和日期"
time = Time.new

puts time.to_s
puts time.ctime
puts time.localtime
puts time.strftime("%Y-%m-%d %H:%M:%S")

puts ' --- 5  ---------------华丽丽的分割线------------'
#时间格式化指令
puts "时间格式化指令"

puts ' --- 6  ---------------华丽丽的分割线------------'
#时间算法
puts "时间算法"


