package service;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 视图由控制器管理，控制器接收应用程序的请求并确定返回的视图。 它还向视图传递所需显示的任何信息（这称为控制器）。 该应用程序的控制器名为
 * HelloController
 *
 * @author Administrator
 */
public class HelloController extends SimpleFormController {
    
    //声明一个 HelloService 的私有字段，并创建一个公用的set方法
    private HelloService helloService;

    public HelloController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Name.class);// 设置命令类的名称。填充该类的一个实例并在每个请求上验证它。
        setCommandName("name"); //在模型中定义命令的名称。在本例中，命令就是将请求参数绑定到自身的窗体对象。
        setSuccessView("helloView"); //设置在成功提交时应该显示的视图的名称。
        setFormView("nameView"); //设置用于显示窗体的视图的名称。这是包含允许用户输入器名称的文本字段的页面。
    }

//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        
        Name name = (Name)command; //将 command 重塑为 Name 对象。
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        
        mv.addObject("helloMessage", helloService.sayHello(name.getValue()));
        
        return mv;
    }
    
    
    
    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
    
}
