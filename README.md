# B-spring-ioc-container-homework
Spring IoC Container Basics 课程课后作业。
Problem 1
分支：p1-starts-from-here

主观题：
@Component 已经可以支持声明一个 bean 了，为何还要再弄个 @Bean 出来？
答案请写在对应分支的 README.md 文件中

答案：首先笼统的讲，@Bean是针对方法的，而@Component则是针对类的注解。简单来说，当使用非Spring的
     类或自定义的类时（即使用第三方的类），则需要使用@Bean来将其注释。且@Component注释在Spring
     的Application运行之时就被Ioc容器所扫描，并进行实例化；而@Bean则是在配置中显示的声明单个
     Bean，举例说明：
     
     1. @Component：
     @Component //定义bean 交由Spring Ioc控制
     public Class JavaBean {
     }
     
     @Autowired
     JavaBean javaBean； //to get bean
     
     总结：就是简化了实例化和使用该类的所有配置，交给Spring的Ioc进行管理，无须手动new
     
     2.@Bean:
     @Configuration
     public Class MyConfiguration {
        @Bean
        public OtherBean getOtherBean() {
            return new OtherBean();
        }
     }
     
     //to get bean
     OtherBean otherBean = applicationContext.getBean("getOtherBean");
     
     总结：直观的来看就是将getOtherBean方法作为一个外包的Bean类来使用，在该"Bean"中手动new了。
     
     
     对比：
     @Component由Spring扫描自动检测并配置Bean，而@Bean显式声明单个Bean，而不是让Spring自动执行。
     @Component不会将Bean的声明与类定义解耦，而@Bean会将Bean的声明与类定义解耦，因为只是一个方法。
     @Component是类级别的注释，而@Bean是方法级别的注释，该方法的名称用作Bean名称。
     @Component不必与@Configuration注释一起使用，因为@Bean注释必须在用@Configuration注释的类中使用。
     我们不能创建一个bean使用@Component一类，如果类是外spring容器，而我们可以创建一个bean如果类是目前使用@Bean甚至一类外Spring容器。