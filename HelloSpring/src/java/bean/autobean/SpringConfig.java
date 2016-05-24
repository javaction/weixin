/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.autobean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于java的配置进行注入
 *
 * @author Administrator
 */
@Configuration
public class SpringConfig {

//    @Bean(name="pinao")
    @Bean
    public Pinao pinao() {

        return new Pinao();
    }

    @Bean
    public Counter counter() {
        return new Counter(12, "哈哈哈", pinao());
    }
}
