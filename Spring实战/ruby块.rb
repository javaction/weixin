
#!/usr/bin/ruby
# -*- coding: UTF-8 -*-

#ruby 块 学习

#块由大量代码组成
#块需要一个明确的名称
#块中的代码总是包含在大括号{}内
#块总是从与其具有相同名称的函数调用。也就是，块的名称是 kuai001，那么调用这个
#  			块的函数也需是 kuai001

puts ' --- 1  ---------------华丽丽的分割线------------'	

#ruby yield语句

def testfun
	puts "在test方法内"
	yield
	puts "你又回到了test方法内"
	yield
end
testfun{
	puts "你在块内"	
}
# 关于 yield 调用块。 在这里，网上有个比较形象的比喻为 占位 ，先占个位置，
#					代码的实现，在后面的块中完成。如果是重用代码的话，可不可以
#					写在一个块中呢？貌似可以！自己的理解。

puts ' --- 2  ---------------华丽丽的分割线------------'

# 带有参数的yield语句
def testfun002
	yield "哈哈"
	puts "在002方法内"
	yield "123321"
	
end

testfun002 {
	|i|  # 参数
	puts "你在块#{i}内"	
}
puts ' --- 3  ---------------华丽丽的分割线------------'

#传递多个参数的yield语句
def testfun003
	yield "哈哈",'1232'
	puts "在002方法内"
	yield "123321","你好"
end
testfun003 {
	|a,b|  # 参数
	puts "你在块#{a}内，也在#{b}内"	
}

puts ' --- 4  ---------------华丽丽的分割线------------'

#ruby  块和方法
#很简单的理解，可以在方法中直接调用一个块来实现一个小功能.
#如果方法的最后一个参数前带有 & ，那么可以向该方法中传递一个块，且这个块
#		可被赋给最后一个参数。如果 * 和 & 同时出现在参数列表中， & 放在后面

def testfun004(&block)
	block.call
end

testfun004 {
	puts "hello world"	
}

puts ' --- 5  ---------------华丽丽的分割线------------'

#BEGIN 和 END 块
BEGIN{
	#BEGIN 代码块
	puts "begin代码块1"
}
BEGIN{
	#BEGIN 代码块
	puts "begin代码块2"
}

END{
	#END 代码块
	puts "end代码块1"
}
END{
	#END 代码块
	puts "end代码块2"
}

#可以存在多个 BEGIN代码块 和 END代码块。 BEGIN代码块 按照他们出现的先后顺序执行
#	END代码块 按照他们的相反顺序执行
	
	