package kr.or.ddit.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;
import kr.or.ddit.mvc.view.DownloadView;

/*
	<context:component-scan base-package="kr.or.ddit" use-default-filters="false">	
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
	</context:component-scan>
*/
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false, 
			 includeFilters = {@Filter(type=FilterType.ANNOTATION, 
					classes = {Service.class, Repository.class})} )
//<mvc:annotation-driven/>
@EnableWebMvc
public class ApplicationContext extends WebMvcConfigurerAdapter {
	/*
	<mvc:default-servlet-handler/>  ==> interface 구현 (WebMvcConfigurerAdapter)
	*/
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	
	/* view
	<bean id="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"/>
	<bean id="DownloadView" class="kr.or.ddit.mvc.view.DownloadView"/>	
	<bean id="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"/>		<!-- excel view 설정  -->						
	<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>	<!-- Resolver 등록 -->
	*/
	@Bean
	public ProfileImgView profileImgView() {
		return new ProfileImgView();
	}
	@Bean
	public DownloadView DownloadView() {
		return new DownloadView();
	}
	@Bean
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}
	@Bean
	public ExcelDownloadView excelView() {
		return new ExcelDownloadView();
	}
	
	
	
	/*
	<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="1"/>
	</bean>
	 */
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(1);
		
		return beanNameViewResolver;
	}
	
	
	
	/*
	<bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>classpath:kr/or/ddit/config/tiles/tiles-definition.xml</value>
			</list>
		</property>
	</bean>
	*/
	@Bean 
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
		
		return tilesConfigurer;
	}
	
	
	
	/*
	<bean class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
		<property name="order" value="0"></property>
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"/>
	</bean>
	*/
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		
		tilesViewResolver.setOrder(0);
		tilesViewResolver.setViewClass(TilesViewResolver.class);
		return tilesViewResolver;
	}
	
	
	
	/*
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">	<!-- view resolver -->
	<!-- prefix : 접두어, suffix : 접미어 
		 Control0ler가 리턴하는 문자열에 prefix, suffix를 적용하여 해당 경로의 파일로 응답을 생성
		 LoginController.getView() ==> "login/view"
		
			prefix				viewName	  suffix
		 "/WEB-INF/views/" + "login/view" + ".jsp"
		 
		 = "/WEB-INF/views/login/view.jsp"
	-->
	<property name="order" value="2"/>								<!-- view resolver 등록할때 같이 등록 -->
	
	<!-- url 주소를 설정 해주는  resolver  -->
	<property name="prefix" value="/WEB-INF/views/"/>
										<!--  ex)  localhost/WEB-INF/views   +   /member/member  +  .jsp -->		
	<property name="suffix" value=".jsp"/>
	
	</bean>
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	
	
	/*
	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	</bean>
	*/
	@Bean
	public MultipartResolver multipartResolver() {
		MultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		return multipartResolver;
	}
	
	
	
	/*
	<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver"></bean> 
	*/
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	
	
	/*
	 <mvc:interceptors>
	 	<mvc:interceptor>
	 		<mvc:mapping path="/**"/>
	 		<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
	 			<property name="paramName" value="lang"></property>
	 		</bean>
	 	</mvc:interceptor>
	 </mvc:interceptors>
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
	
	
	
	/*
	 <mvc:resources mapping="/resources/**" location="/WEB-INF/views/error/"/>
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/error/");
	}
	
	
	
	
	
	
	
	
	
}
